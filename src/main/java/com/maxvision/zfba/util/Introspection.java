package com.maxvision.zfba.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * java 自省
 * @author minte
 * @date 2020/12/28 14:06
 */
public class Introspection {

    /**
     * 获取对象的set方法
     * @param clazz 对象
     * @param propertyName 对象属性
     */
    public static Method getWriteMethod(Class<?> clazz,String propertyName) throws Exception{
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName,clazz);
        return propertyDescriptor.getWriteMethod();
    }

    public static Method getReadMethod(Object object ,String propertyName) throws Exception{
        return getReadMethod(object.getClass(),propertyName);
    }

    /**
     * 获取对象的get方法
     * @param clazz 对象
     * @param propertyName 对象属性
     */
    public static Method getReadMethod(Class<?> clazz,String propertyName) throws Exception{
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            if(descriptor.getName().equals(propertyName)){
                return descriptor.getReadMethod();
            }
        }
        return null;
    }

    public static Object getPropertyValue(Object bean, String propertyName) throws Exception{
        Method method = getReadMethod(bean, propertyName);
        return method.invoke(bean);
    }


    public static void setPropertyValue(Object object, String propertyName,Object value) throws Exception{
        Method wirteMethod = getWriteMethod(object.getClass(), propertyName);
        wirteMethod.invoke(object,value);
    }

}
