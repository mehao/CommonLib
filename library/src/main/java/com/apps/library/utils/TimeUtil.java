package com.apps.library.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具
 *
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtil {

    public static String getCurrTimeToYear() {
        String currTime = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        return currTime;
    }

    public static String getCurrTimeToMonth() {
        String currTime = new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());
        return currTime;
    }

    public static String getCurrTimeToDay() {
        String currTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        return currTime;
    }

    public static String getCurrTimeToHour() {
        String currTime = new SimpleDateFormat("yyyy-MM-dd HH").format(Calendar.getInstance().getTime());
        return currTime;
    }

    public static String getCurrTimeToMinute() {
        String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
        return currTime;
    }

    public static String getCurrTimeToSecond() {
        String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return currTime;
    }

    public static String getTimeToDay(long date) {
        String ret = null;
        ret = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return ret;
    }

    public static String getTimeToMD(long date) {
        long time = System.currentTimeMillis() - date;
        String ret = null;
        ret = new SimpleDateFormat("MM-dd").format(time);
        return ret;
    }

    public static String getTimeToDay(String date) {
        String ret = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long timeMillisecond = simpleDateFormat.parse(date).getTime();
            ret = new SimpleDateFormat("yyyy-MM-dd").format(timeMillisecond);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    //得到 month-day 格式的日期
    public static String getTimeToMD(String date) {
        String ret = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long timeMillisecond = simpleDateFormat.parse(date).getTime();
            ret = new SimpleDateFormat("MM-dd").format(timeMillisecond);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String getTimeHM(long date) {
        String ret = null;
        ret = new SimpleDateFormat("HH:mm").format(date);
        return ret;
    }

    /**
     * <br>功能简述:获取HH：mm
     *
     * @param date 格式yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getTimeHM(String date) {
        String ret = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long timeMillisecond = simpleDateFormat.parse(date).getTime();
            ret = new SimpleDateFormat("HH:mm").format(timeMillisecond);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String getTimeHMS(long date) {
        String ret = null;
        ret = new SimpleDateFormat("HH:mm:ss").format(date);
        return ret;
    }

    /**
     * <br>功能简述:获取HH：mm：ss
     *
     * @param date 格式yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getTimeHMS(String date) {
        String ret = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long timeMillisecond = simpleDateFormat.parse(date).getTime();
            ret = new SimpleDateFormat("HH:mm:ss").format(timeMillisecond);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * <br>功能简述:获取距当前过去的小时数
     *
     * @param date
     */
    public static String getPassedTimeH(String date) {
        String ret = StringUtil.toString(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long timeMillisecond = simpleDateFormat.parse(date).getTime();
            long passedTime = System.currentTimeMillis() - timeMillisecond;
            if (passedTime > 0) {
                long passedHours = passedTime / (60 * 60 * 1000);
                ret = StringUtil.toString(passedHours);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * <br>功能简述:根据字符串获取时间到秒级
     *
     * @param time
     * @return
     */
    public static long getTimeSLByStr(String time) {
        long timeMillisecond = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            timeMillisecond = simpleDateFormat.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeMillisecond;
    }

    public static long getMillTimeByString(String time) {
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time));
            return c.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * <br>功能简述:将毫秒转换成秒
     *
     * @param ms
     */
    public static float getSByMs(int ms) {
        return ((float) ms) / 1000.0f;
    }

    /**
     * <br>功能简述:将毫秒转换成秒
     *
     * @param ms
     */
    public static long getSByMs(long ms) {
        return ms / 1000;
    }

    /**
     * 将时间戳转为代表"距现在多久之前"的字符串
     *
     * @param timeStr 时间戳
     * @return
     */
    public static String getDisStandardDate(String timeStr) {
        StringBuffer sb = new StringBuffer();

        long time = Long.parseLong(timeStr);
        long oldTime = System.currentTimeMillis() - time;
        Date date = Calendar.getInstance().getTime();
        String retYear = new SimpleDateFormat("yy-MM-dd").format(oldTime);
        String retTime = new SimpleDateFormat("HH:mm").format(oldTime);
        String retMonth = new SimpleDateFormat("MM-dd").format(oldTime);

        String curYear = new SimpleDateFormat("yyyy").format(date);
        String oldYear = new SimpleDateFormat("yyyy").format(oldTime);

        String curMonth = new SimpleDateFormat("MM").format(date);
        String oldMonth = new SimpleDateFormat("MM").format(oldTime);

        String curDay = new SimpleDateFormat("dd").format(date);
        String oldDay = new SimpleDateFormat("dd").format(oldTime);

        long timeGap = System.currentTimeMillis() - oldTime;
        long mill = (long) Math.ceil(timeGap / 1000);//秒前
        long minute = (long) Math.ceil(timeGap / 60 / 1000.0f);// 分钟前
        long hour = (long) Math.ceil(timeGap / 60 / 60 / 1000.0f);// 小时

        if (hour - 1 > 0) {
            if (hour <= 6) {
                sb.append(hour - 1 + "小时前");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时前");
            } else {
                sb.append(minute - 1 + "分钟前");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟前");
            } else {
                sb.append(mill + "秒前");
            }
        } else {
            sb.append("刚刚");
        }
        if (!"".equals(sb.toString())) {
            return sb.toString();
        }

        if (curYear.equals(oldYear)) {
            if (curMonth.equals(oldMonth)) {
                if (curDay.equals(oldDay)) {
                    sb.append("今天 " + retTime);
                } else if (Integer.valueOf(curDay) - Integer.valueOf(oldDay) == 1) {
                    sb.append("昨天" + retTime);
                } else {
                    sb.append(retMonth);
                }
                return sb.toString();
            } else {
                sb.append(retMonth);
                return sb.toString();
            }
        } else {
            sb.append(retYear);
            return sb.toString();
        }
    }

    public static String getDisTime(String timeStr) {
        try {
            if (timeStr == null || "".equals(timeStr)) {
                return "";
            }
            StringBuffer sb = new StringBuffer();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = Calendar.getInstance().getTime();
            Date oldDate = df.parse(timeStr);
            long oldTime = oldDate.getTime();
            String retYear = new SimpleDateFormat("yy-MM-dd").format(oldTime);
            String retTime = new SimpleDateFormat("HH:mm").format(oldTime);
            String retMonth = new SimpleDateFormat("MM-dd").format(oldTime);

            String curYear = new SimpleDateFormat("yyyy").format(date);
            String oldYear = new SimpleDateFormat("yyyy").format(oldTime);

            String curMonth = new SimpleDateFormat("MM").format(date);
            String oldMonth = new SimpleDateFormat("MM").format(oldTime);

            String curDay = new SimpleDateFormat("dd").format(date);
            String oldDay = new SimpleDateFormat("dd").format(oldTime);

            long timeGap = System.currentTimeMillis() - oldTime;
            long mill = (long) Math.ceil(timeGap / 1000);//秒前
            long minute = (long) Math.ceil(timeGap / 60 / 1000.0f);// 分钟前
            long hour = (long) Math.ceil(timeGap / 60 / 60 / 1000.0f);// 小时

            if (hour - 1 > 0) {
                if (hour <= 6) {
                    sb.append(hour - 1 + "小时前");
                }
            } else if (minute - 1 > 0) {
                if (minute == 60) {
                    sb.append("1小时前");
                } else {
                    sb.append(minute - 1 + "分钟前");
                }
            } else if (mill - 1 > 0) {
                if (mill == 60) {
                    sb.append("1分钟前");
                } else {
                    sb.append(mill + "秒前");
                }
            } else {
                sb.append("刚刚");
            }
            if (!"".equals(sb.toString())) {
                return sb.toString();
            }

            if (curYear.equals(oldYear)) {
                if (curMonth.equals(oldMonth)) {
                    if (curDay.equals(oldDay)) {
                        sb.append("今天 " + retTime);
                    } else if (Integer.valueOf(curDay) - Integer.valueOf(oldDay) == 1) {
                        sb.append("昨天" + retTime);
                    } else {
                        sb.append(retMonth);
                    }
                    return sb.toString();
                } else {
                    sb.append(retMonth);
                    return sb.toString();
                }
            } else {
                sb.append(retYear);
                return sb.toString();
            }

        } catch (ParseException e) {
            return "";
        }
    }

    public static String getNewsStandardDate(String timeStr) {

        StringBuffer sb = new StringBuffer();

        long time = Long.parseLong(timeStr);
//        long time = System.currentTimeMillis() - (t*1000);
        long mill = (long) Math.ceil(time / 1000);//秒前

        long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前

        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时

        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        long month = (long) Math.ceil(time / 30 / 24 / 60 / 60 / 1000.0f);//月前

        long year = (long) Math.ceil(month / 365 / 24 / 60 / 60 / 1000.0f);//年前

        if (year - 1 > 0) {
            sb.append(year - 1 + "年");
        } else if (month - 1 > 0) {
            sb.append(month - 1 + "个月");
        } else if (day - 1 > 0) {
            sb.append(day - 1 + "天");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");
            } else {
                sb.append(hour - 1 + "小时");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");
            } else {
                sb.append(minute - 1 + "分钟");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");
            } else {
                sb.append(mill + "秒");
            }
        } else {
            sb.append("刚刚");
        }
        if (!sb.toString().equals("刚刚")) {
            sb.append("前");
        }
        return sb.toString();
    }

    public static long getGuessTimeLong(String timeStr){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        long diff = 0;
        Date two = Calendar.getInstance().getTime();
        try {
            one = df.parse(timeStr);
            long time1 = one.getTime();
            long time2 = two.getTime();
            diff = time1 - time2;
            return diff;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static String getGuessTime(String timeStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two = Calendar.getInstance().getTime();
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(timeStr);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StringBuilder time = new StringBuilder();
        String hourTime;
        String minTime;
        String secTime;
        if (day < 1) {
            if (hour < 10) {
                hourTime = "0" + hour;
            } else {
                hourTime = "" + hour;
            }
        } else {
            hourTime = (day * 24 + hour) + "";
        }
        if (min < 10) {
            minTime = "0" + min;
        } else {
            minTime = "" + min;
        }
        if (sec < 10) {
            secTime = "0" + sec;
        } else {
            secTime = "" + sec;
        }
        time.append(hourTime).append(":").append(minTime).append(":").append(secTime);
        return time.toString();
    }

    //by xf_d
    public static int getTodayHour() {
        String currTime = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
        int curH = Integer.valueOf(currTime);
        return curH;
    }

    public static int getTodayMin() {
        String currTime = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
        int curMin = Integer.valueOf(currTime);
        return curMin;
    }

    public static int compareDate(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static String getTimeToStandardDate(long date) {
        long time = System.currentTimeMillis() - date;
        String ret = null;
        ret = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(time);
        return ret;
    }


}
