package main.com.chemcn.ec.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author: zhoujl
 * @Date: 2018/12/3 9:37
 * @Description:
 */
public class BeanUtil {
    public BeanUtil() {
    }

    public static List getMapList(List beanList) {
        if (beanList == null) {
            return null;
        } else {
            ArrayList lstMap = new ArrayList();

            try {
                Iterator iter = beanList.iterator();

                while(iter.hasNext()) {
                    Object obj = iter.next();
                    Map map = transBean2Map(obj);
                    lstMap.add(map);
                }
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            return lstMap;
        }
    }

    public static HashMap<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        } else {
            HashMap map = new HashMap();

            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                PropertyDescriptor[] arr$ = propertyDescriptors;
                int len$ = propertyDescriptors.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    PropertyDescriptor property = arr$[i$];
                    String key = property.getName();
                    if (!key.equals("class")) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj);
                        map.put(key, value);
                    }
                }
            } catch (Exception var11) {
                System.out.println("transBean2Map Error " + var11);
            }

            return map;
        }
    }

    public static void transMap2Bean(Map<String, Object> map, Object obj) {
        String printkey = "";

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            PropertyDescriptor[] arr$ = propertyDescriptors;
            int len$ = propertyDescriptors.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                PropertyDescriptor property = arr$[i$];
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception var12) {
            System.out.println("====================" + printkey);
            System.out.println("transMap2Bean Error " + var12);
        }

    }

    public static void copyProperties(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
    }
}
