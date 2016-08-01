package com.ithooks.hooksutils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author:    tedyuen
 * Version    V1.0
 * Date:      16/8/1 下午4:48
 * Description: 时间(转换)帮助类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 16/8/1          tedyuen             1.0             1.0
 * Why & What is modified:
 */
public class DateUtil {

    /**
     * 转换不同格式的时间表达
     * @param dataStr
     * @param preFormat
     * @param resultFormat
     * @return
     * @throws ParseException
     */
    public static String switchFormatStr(String dataStr,String preFormat,String resultFormat) throws ParseException{
        if(!StringUtils.isEmpty(dataStr)){
            SimpleDateFormat dateformat1 = new SimpleDateFormat(preFormat);
            Date date = dateformat1.parse(dataStr);
            SimpleDateFormat dateformat2=new SimpleDateFormat(resultFormat);
            String Date=dateformat2.format(date);
            return Date;
        }
        return dataStr;
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Calendar getNow(){
        Calendar date = Calendar.getInstance();
        return date;
    }

    public static Date getNowDate(){
        return getNow().getTime();
    }

    /**
     * 获取当前时间，格式：2016-05-09 10:00:11
     * @return
     */
    public static String getNowStr(String format){
        Calendar date = Calendar.getInstance();
        return dateAddByDateForString(date.getTime(),format,0);
    }

    /**
     * 时间加减，输出format格式字符串
     *
     * @param date
     * @param format
     * @param num
     * @return
     */
    public static String dateAddByDateForString(Date date, String format,
                                                int num) {
        String ret = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, num);
            date = cal.getTime();
            ret = sdf.format(date);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 获取年月日字符串
     * @return
     */
    public static String getDayOfYear(){
        Calendar now = Calendar.getInstance();
        StringBuffer buffer = new StringBuffer();
        buffer.append(now.get(Calendar.YEAR));
        buffer.append(now.get(Calendar.MONTH));
        buffer.append(now.get(Calendar.DAY_OF_MONTH));
        return buffer.toString();
    }

    /**
     * 获得日期显示格式,按照全站规范定义
     * @param time
     * @return
     */
    public static String standardDateFormat(Date time) {
        StringBuilder pattern = new StringBuilder();
        Calendar thisCalendar = Calendar.getInstance();
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTime(time);
        if (thisCalendar.get(Calendar.YEAR) == timeCalendar.get(Calendar.YEAR)) {
            // 同一年
            if ((thisCalendar.get(Calendar.MONTH) == timeCalendar
                    .get(Calendar.MONTH))
                    && (thisCalendar.get(Calendar.DATE) == timeCalendar
                    .get(Calendar.DATE))) {
                // 同一天
                pattern.append("HH:mm");
            } else {
                // 不同天
                pattern.append("MM-dd HH:mm");
            }
        } else {
            pattern.append("yyyy-MM-dd HH:mm");
        }
        return new SimpleDateFormat(pattern.toString()).format(time);
    }

    /**
     * 标准的时间格式化，是否带毫秒值
     *
     * @param time
     * @param hasSecond
     * @return
     */
    public static String standardDateFormat(Date time, boolean hasSecond) {
        StringBuilder pattern = new StringBuilder();
        Calendar thisCalendar = Calendar.getInstance();
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTime(time);
        if (thisCalendar.get(Calendar.YEAR) == timeCalendar.get(Calendar.YEAR)) {
            // 同一年
            if ((thisCalendar.get(Calendar.MONTH) == timeCalendar
                    .get(Calendar.MONTH))
                    && (thisCalendar.get(Calendar.DATE) == timeCalendar
                    .get(Calendar.DATE))) {
                // 同一天
                pattern.append("HH:mm");
            } else {
                // 不同天
                pattern.append("MM-dd HH:mm");
            }
        } else {
            pattern.append("yyyy-MM-dd HH:mm");
        }
        if (hasSecond) {
            pattern.append(":ss");
        }
        return new SimpleDateFormat(pattern.toString()).format(time);
    }

    /**
     * 时间加减
     *
     * @param date
     * @param num
     * @return
     */
    public static Date dateAdd(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, num);
        date = cal.getTime();
        return date;
    }

    /**
     * 根据格式从字符串获取时间
     * @param dateString
     * @param format
     * @return
     */
    public static Date simpleDateParse(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间相减，返回两时间的天数
     * @param date1
     * @param date2
     * @return
     */
    public static long formatStringDataToDay(String date1,String date2){
        Date time1,time2;   //定义时间类型
        long day = -1;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            time1 = inputFormat.parse(date1); //将字符型转换成日期型
            time2 = inputFormat.parse(date2); //将字符型转换成日期型
            long temp = time2.getTime() - time1.getTime();

            day = temp / (1000 * 60 * 60 * 24);                //相差天数
            long hours = temp / (1000 * 60 * 60);                //相差小时数
        } catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }
}
