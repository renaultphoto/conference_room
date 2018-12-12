package main.com.chemcn.ec.interceptor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


public class BaseInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);
	private static final String THREADlOCALNAME = "ThreadLocal StartTime";
	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>(THREADlOCALNAME);
	private static final String UnAuthorizedJsonMsg = "{\"code\":500" + ",\"message\":\"您没有访问权限!\"}";
	//@Autowired
	//private StringRedisTemplate stringRedisTemplate;
	@Value("${ignore.url}")
	private String ignoreUrl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTimeThreadLocal.set(System.currentTimeMillis());
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, " + ",Authorization,"
				+ "If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, " + "Content-Type, X-E4M-With"+",X_Requested_With");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String param = recordRequestParam(request.getParameterMap());
		logger.info(String.format("=========[%s]===start=========请求方式：[%s] ，请求参数：[%s]", request.getRequestURI(),
				request.getMethod(), param));
		
		if(request.getMethod().equals("OPTIONS")) {
			responseJson(response, "", response.SC_ACCEPTED);
		}
		String openId = request.getParameter("openId");
		String uri = request.getRequestURI();
		Object webToken = request.getSession().getAttribute("token");
		if (uri.contains("api")) {
			if (StringUtils.isNotBlank(openId)) {
				//openId是否存在
				//String check = stringRedisTemplate.opsForValue().get("meeting:user_" + token);
				String check="true";
				if(StringUtils.isBlank(check)) {
					responseJson(response, UnAuthorizedJsonMsg);
					return false;
				}
			} else {
				if(webToken != null) {
					return true;
				}
				responseJson(response, UnAuthorizedJsonMsg);
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long beginTime = startTimeThreadLocal.get();
		long endTime = System.currentTimeMillis();
		logger.info("=========end=========请求用时：" + (endTime - beginTime));
	}

	private String recordRequestParam(Map<String, String[]> map) {
		StringBuffer stringBuffer = new StringBuffer();
		for (String key : map.keySet()) {
			stringBuffer.append(key).append("=");
			Object mapValue = map.get(key);
			if (mapValue instanceof String[]) {
				String[] values = (String[]) mapValue;
				for (int i = 0; i < values.length; i++) {
					if (i > 0) {
						stringBuffer.append(",");
					}
					String value = values[i];
					if (value != null && value.length() > 50) {
						value = value.substring(0, 50);
					}
					stringBuffer.append(value);
				}
			} else {
				stringBuffer.append(mapValue);
			}
			stringBuffer.append(";");
		}
		return stringBuffer.toString();
	}

	public void responseJson(HttpServletResponse resp, String msg) {
		PrintWriter writer = null;
		try {
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/json; charset=utf-8");
			resp.setStatus(200);
			writer = resp.getWriter();
			writer.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	
	public void responseJson(HttpServletResponse resp, String msg, int status) {
		PrintWriter writer = null;
		try {
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/json; charset=utf-8");
			resp.setStatus(status);
			writer = resp.getWriter();
			writer.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public boolean needLogin(String url) {
		if (StringUtils.isNotBlank(ignoreUrl)) {
			String[] split = ignoreUrl.split(",");
			for (int i = 0; i < split.length; i++) {
				if (url.indexOf(split[i]) != -1) {
					return false;
				}
			}
		}
		return true;
	}
}
