package com.shivamdev.mvpstarterboilerplate.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.shivamdev.mvpstarterboilerplate.common.MvpApp;

/**
 * Created by shivam on 12/5/17.
 */

public class Toaster {

    public static void toast(@StringRes int message) {
        Toast.makeText(MvpApp.getInstance(), message, Toast.LENGTH_SHORT).show();
    }

    public static void toast(String message) {
        Toast.makeText(MvpApp.getInstance(), message, Toast.LENGTH_SHORT).show();
    }

}