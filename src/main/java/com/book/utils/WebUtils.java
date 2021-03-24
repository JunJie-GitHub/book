package com.book.utils;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 把map数据注入到bean对象中,
     * 细节: 1,传入Map而不是request对象, 这样方法的使用范围更广, 耦合度更低
     *      2,返回传入的对象, 使调用代码更简洁,
     *        例: User user = (User)WebUtils.copyParamToBean(request.getParameterMap(), new User());
     *     3,使用泛型, 调用赋值时不用类型强转了
     * @param value
     * @param bean
     * @return
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean, value);    //把所有请求参数都注入到对象中
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
    @Deprecated
    public static int strToInt(String str){
        if (str==null){
            return 0;
        }
        return Integer.parseInt(str);
    }

    /**
     * 字符串转int类型
     * @param str
     * @return
     */
    public static int parseInt(String str){
        if (str==null){
            return 0;
        }
        return Integer.parseInt(str);
    }

    /**
     * 字符串转int类型
     * @param str
     * @param def 默认值
     * @return
     */
    public static int parseInt(String str, int def){
        if (str==null){
            return def;
        }
        return Integer.parseInt(str);
    }
}
