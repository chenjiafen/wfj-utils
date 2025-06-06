package com.wfj.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class DataTime {
    private static Logger log = Logger.getLogger(String.valueOf(DataTime.class));
    /**
     * 获取当前时间
     * @return
     */
    public static String getDataTiem() {
        Date date = new Date();
        // 使用SimpleDateFormat，并指定匹配模板
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("当前时间：" + simpleDateFormat.format(date));
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static String getData() {
        // 获取当前日期时间并设置为0时0分0秒
        LocalDateTime todayMidnight = LocalDateTime.now()
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0); // 清除毫秒精度

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化日期时间
        String formattedDate = todayMidnight.format(formatter);
        log.info("当前日期的0点时间：" + formattedDate);

        return formattedDate;
    }
    public static String getTime(int daysToSubtract) {
        // 获取当前日期实例
        Calendar calendar = Calendar.getInstance();

        // 减去指定天数
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract);

        // 设置时间为当天的 23:59:59
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        // 获取处理后的日期
        Date date = calendar.getTime();

        // 使用 SimpleDateFormat 格式化日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = simpleDateFormat.format(date);

        // 输出日志（包含天数信息）
        log.info(daysToSubtract+"天前的23点时间：" + formattedDateTime);

        return formattedDateTime;
    }
    public static String getDataTiem(int daysToSubtract) {
        // 获取当前日期时间并减去指定天数
        LocalDateTime dateTime = LocalDateTime.now()
                .minusDays(daysToSubtract)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化日期时间
        String formattedDate = dateTime.format(formatter);
        log.info(daysToSubtract+"天前的0点时间：" + formattedDate);

        return formattedDate;
    }

    public static void main(String[] args) {
//        System.out.println(getDataTiem(7));
//        getTime();
        System.out.printf("----"+getTime(1));

    }
}
