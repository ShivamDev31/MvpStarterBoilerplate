package com.shivamdev.mvpstarterboilerplate.utils;

/**
 * Created by shivam on 12/5/17.
 */

public class StringUtils {

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static boolean isNotEmpty(String text) {
        return text != null && !text.isEmpty();
    }

}