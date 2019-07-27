package com.usdj.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gerrydeng
 * @date 2019-07-24 20:55
 * @Description:
 */
class MySql {

    /**
     * 通过自定义注解@Table @Column实现自定义查询语句
     *
     * @param object
     * @return
     */
    static String query(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> c = object.getClass();
        boolean annotationPresent = c.isAnnotationPresent(Table.class);
        if (!annotationPresent) {
            return null;
        }
        Table table = c.getAnnotation(Table.class);
        String tableName = table.value();
        stringBuilder.append("select * from ").append(tableName).append(" where 1=1 ");
        Field[] declaredFields = c.getDeclaredFields();
        for (Field field : declaredFields) {
            boolean annotationPresentField = field.isAnnotationPresent(Column.class);
            if (!annotationPresentField) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            // 4.2 拿到字段的值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(object);
            } catch (InvocationTargetException e) {
                // 小朋友别学怪蜀黍这样粗暴操作，对于包装类默认值null空指针暴力置空处理
                fieldValue = "";
            } catch (NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
            // 4.3 拼接sql
            if (fieldValue != null & fieldValue != "") {
                stringBuilder.append(" and ").append(columnName).append(" = ").append(fieldValue);
            }
        }
        return stringBuilder.toString();
    }
}
