/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Chuyển đổi String sang Date
     *
     * @param date là String cần chuyển
     * @param pattern là định dạng thời gian
     * @return Date kết quả
     */
    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateHelper.now();
            }
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Chuyển đổi từ Date sang String
     *
     * @param date là Date cần chuyển đổi
     * @param pattern là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMATER.format(date);
    }

    /**
     * Lấy thời gian hiện tại
     *
     * @return Date kết quả
     */
    public static Date now() {
        return new Date();
    }

    /**
     * Bổ sung số ngày vào thời gian
     *
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung váo date
     * @return Date kết quả
     */
    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    /**
     * Bổ sung số ngày vào thời gian hiện hành
     *
     * @param days số ngày cần bổ sung vào thời gian hiện tại
     * @return Date kết quả
     */
    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }

    public static String DinhDangTien(float tien) {
        return NumberFormat.getNumberInstance().format(tien);
    }

    //Hàm chuyển từ chữ sang số để tính toán
    public static float ChuyenTien(String tien) {
        try {
            return NumberFormat.getNumberInstance().parse(tien).floatValue();
        } catch (ParseException ex) {

        }
        return 0;
    }
}
