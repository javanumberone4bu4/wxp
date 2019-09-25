package com.rimi.item.util;

/**
 * 字符串工具类
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 9:02
 */
public final class StringUtils {
    private StringUtils(){}
    public static boolean isNotEmpty(String str){
        return (str!=null&&!"".equals(str));
    }
    public static boolean isEmpty(String str){
        return !isNotEmpty(str);
    }
    public static String appendString(String prefix,String method){
        if(isEmpty(method)) {
            return "";
        }
        StringBuffer sb=new StringBuffer(prefix);
        String substring = method.substring(0, 1);
        String s = substring.toUpperCase();
        String substring1 = method.substring(1);
        sb.append(s).append(substring1);
        return sb.toString();
    }
    /**
     * 把带下划线的字符串转换成驼峰命名法
     * 例如: book_name 转换成 bookName
     *
     * @param str 需要转换的字符串 如 book_name
     * @return 转换后的字符串 如 bookName
     */
    public static String underLineToHump(String str) {
        String result = "";
        if (isEmpty(str)) {
            return result;
        }
        // 判断是否包含"_"
        if (!str.contains("_")) {
            result = str;
            return result;
        }
        StringBuilder sb = new StringBuilder();
        // 把字符串通过截取转换中字符串数组
        String[] arr = str.split("_");
        for (String s : arr) {
            // 把每个单词的首字母大写
            String aCase = s.substring(0, 1).toUpperCase();
            // 获取剩下的单词
            String s1 = s.substring(1);
            // 拼接
            sb.append(aCase).append(s1);
        }
        // 转换成字符串
        result = sb.toString();
        // 把首字符转成小写
        result = result.substring(0, 1).toLowerCase() + result.substring(1);
        return result;
    }
}
