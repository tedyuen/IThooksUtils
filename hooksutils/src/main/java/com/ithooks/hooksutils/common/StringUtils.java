package com.ithooks.hooksutils.common;

import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * Author:    tedyuen
 * Version    V1.0
 * Date:      16/8/1 下午4:25
 * Description: 字符串处理工具
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 16/8/1          tedyuen             1.0             1.0
 * Why & What is modified:
 */
public class StringUtils {
    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 将字符串的指定位置替换成新的字符
     *
     * @param str
     *            原字符串
     * @param n
     *            指定要替换的位数
     * @param newChar
     *            要替换的字符
     * @return String 替换后的字符串
     * @throws Throwable
     */
    public static String specialReplace(String str, int n, String newChar) {
        String s1 = "";
        String s2 = "";
        s1 = str.substring(0, n - 1);
        s2 = str.substring(n, str.length());
        return s1 + newChar + s2;
    }

    public static final Pattern PHONE
            = Pattern.compile(                      // sdd = space, dot, or dash
            "^1\\d{10}$");

    /**
     * 验证手机号码
     * @param number
     * @return
     */
    public static boolean isValidCellPhone(String number) {
        return number != null && !"".equals(number)&& number.length() == 11 && PHONE.matcher(number).matches();
    }
    /**
     * 注册页面密码长度
     * @param password
     * @return
     * */
    public static boolean isValidPassword(String password){
        return password != null && !"".equals(password) && password.length()>=6 && password.length()<=12;
    }
    /**
     * 完善信息昵称长度2-20
     * */
    public static boolean isFinishUserInfoName(String nickname){
        return nickname!=null && !"".equals(nickname) && nickname.length()>=2 && nickname.length()<=20 && NAME.matcher(nickname).matches();
    }

//    public static final boolean isCheckString(String nickname){
//        return NAME.matcher(nickname).matches();
//    }
    /**
     * 昵称姓名正则
     * */
    public static final Pattern NAME
            = Pattern.compile("[a-zA-Z0-9\u4e00-\u9fa5\\s]+");


    public static String getStr(String str) {
        return isEmpty(str) ? "" : str;
    }

    public static String getEditTextContent(EditText edt) {
        return edt.getText().toString().trim();
    }


    public static boolean isEditTextEmpty(EditText edt) {
        return isEmpty(getEditTextContent(edt));
    }

    public static boolean isEditTextConform(EditText edt1, EditText edt2) {
        return getEditTextContent(edt1).equals(getEditTextContent(edt2));
    }

    public static boolean isPhoneEditTextEmpty(EditText edt) {
        return isEmpty(getEditTextContent(edt)) || getEditTextContent(edt).length() != 11;
    }

    public static boolean notEmpty(String str) {
        return !isEmpty(str);
    }

    public static String getTextViewContent(TextView tv) {
        return tv.getText().toString().trim();
    }

    public static String replace(String str){
        if(str!=null){
            return str.replace("<br/>","\n");
        }else{
            return null;
        }
    }
    public static String total(double money){
        DecimalFormat df = new DecimalFormat();
        String style = "0.00";//定义要显示的数字的格式
        df.applyPattern(style);// 将格式应用于格式化器
        return df.format(money);
    }
    /**
     * 减法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    /**
     * 乘法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    /**
     * 清除字符串空格
     * */
    public static String removeAllSpace(String str) {
        String tmpstr=str.replace(" ","");
        return tmpstr;
    }
}
