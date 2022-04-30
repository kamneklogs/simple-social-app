package com.kamneklogs.socialapp.context

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val sharedPreferencesName: String = "SocialAppPrefs"
    private val preferences: SharedPreferences =
        context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)

    var usernameLogged: String?
        get() = preferences.getString(sharedPreferencesName, "")
        set(value) = preferences.edit().putString(sharedPreferencesName, value).apply()
}