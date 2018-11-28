package main.com.em.restcontroler;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;



@RestController
public class ApiWebRestController implements InitializingBean{
    private ApplicationContext applicationContext;
    private static final Logger logger = LoggerFactory.getLogger(ApiWebRestController.class);

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping({"/rest/{beanName}/{methodName}"})
    public Object rest(@PathVariable("beanName") String beanName, @PathVariable("methodName") String methodName, @RequestParam(required = false) String jsonParam, @RequestBody(required = false) String body) throws Throwable {
        String requestParam = jsonParam == null?body:jsonParam;
        logger.info("Begin Process Proxy Method:{}.{}(..)", beanName, methodName);

        Object result;
        try {
            Object bean = this.applicationContext.getBean(beanName);
            assertNotNull(bean);
            Class<?>[] beanClass = AopProxyUtils.proxiedUserInterfaces(bean);
            Method method = findMethod(beanClass, methodName);
            assertNotNull(method);
            Class<?>[] paramType = method.getParameterTypes();
            if(paramType.length != 1) {
                throw new IllegalAccessException();
            }

            Object param = JSON.parseObject(requestParam, paramType[0]);
            result = AopUtils.invokeJoinpointUsingReflection(bean, method, new Object[]{param});
        } catch (Throwable error) {
            logger.error(String.format("Error Process Proxy Method:%s.%s(%s)", beanName, methodName, jsonParam), error);
            throw error;
        } finally {
            logger.info("End Process Proxy Method:{}.{}(..)", beanName, methodName);
        }

        return result;
    }

    private static void assertNotNull(Object obj) throws IllegalAccessException {
        if(obj == null) {
            throw new IllegalAccessException();
        }
    }

    private static Method findMethod(Class<?>[] clazz, String name) throws IllegalAccessException {
        Class<?> searchType = null;

        for (Class<?> aClazz : clazz) {
            if (aClazz.getName().startsWith("main.com.em")) {
                searchType = aClazz;
                break;
            }
        }

        assertNotNull(searchType);

        while(searchType != null) {
            Method[] methods = searchType.getMethods();

            for (Method method : methods) {
                if (name.equals(method.getName())) {
                    return method;
                }
            }

            searchType = searchType.getSuperclass();
        }

        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化 ApiWebRestController");
    }
}