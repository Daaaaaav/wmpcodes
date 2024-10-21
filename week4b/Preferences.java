package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
    }

    public static void setUsername(Context context, String username) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("username", username);
        editor.apply();
    }

    public static String getUsername(Context context) {
        return getSharedPreferences(context).getString("username", null);
    }

    // Password
    public static void setPassword(Context context, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("password", password);
        editor.apply();
    }

    public static String getPassword(Context context) {
        return getSharedPreferences(context).getString("password", null);
    }

    public static void setEmail(Context context, String email) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("email", email);
        editor.apply();
    }

    public static String getEmail(Context context) {
        return getSharedPreferences(context).getString("email", null);
    }

    public static void setPhone(Context context, String phone) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("phone", phone);
        editor.apply();
    }

    public static String getPhone(Context context) {
        return getSharedPreferences(context).getString("phone", null);
    }

    public static void clearUserInfo(Context context) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
    }
}
