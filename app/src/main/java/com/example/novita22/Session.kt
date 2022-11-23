package com.example.novita22

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Session(context: Context) {
    private val USERNAME_KEY = "key_username"
    private val NAMA_LENGKAP_KEY = "key_nama_lengkap"

    private val preferences: SharedPreferences = context.getSharedPreferences("Login App", Context.MODE_PRIVATE)

    fun getUser(): String? {
        return preferences.getString(NAMA_LENGKAP_KEY, null)
    }

    fun setSession(username: String?, nama_lengkap: String?) {
        preferences.edit().putString(USERNAME_KEY, username)
            .apply()

        preferences.edit().putString(NAMA_LENGKAP_KEY, nama_lengkap)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        val username = preferences.getString(USERNAME_KEY, null)
        return username !=null
    }

    fun validate(username: String?, password: String): Boolean {
        val namalengkap = "Novita"
        if (username == "Admin" && password == "Admin123") {
            setSession(username, namalengkap)
            return true
        } else if (username == "Radiva" && password == "Radiva123") {
            setSession(username, namalengkap)
            return true
        } else if (username == "3022" && password == "3022") {
            setSession(username, namalengkap)
            return true
        }
        return true
    }
    fun logout() {
        preferences.edit().remove(USERNAME_KEY)
            .remove(NAMA_LENGKAP_KEY)
            .apply()
    }
}