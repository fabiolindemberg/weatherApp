package com.fabio.lab.whetherapp.features.preferences

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fabio.lab.whetherapp.R
import com.fabio.lab.whetherapp.features.Constants
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {

    val prefs by lazy {
        getSharedPreferences(Constants.pref_name, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        readPrefs()

        btnSave.setOnClickListener({writePrefs()})
    }

    private fun readPrefs(){
        prefs.apply {
            rbCelcio.isChecked = getBoolean(Constants.Temperature.tempC, true)
            rbFerenheight.isChecked = getBoolean(Constants.Temperature.tempF, false)
            rbEnglish.isChecked = getBoolean(Constants.Language.langEN, true)
            rbPortuguese.isChecked = getBoolean(Constants.Language.langPT, false)
        }
    }

    private fun writePrefs() {
        prefs.edit().apply {
            putBoolean(Constants.Temperature.tempC, rbCelcio.isChecked)
            putBoolean(Constants.Temperature.tempF, rbFerenheight.isChecked)
            putBoolean(Constants.Language.langEN, rbEnglish.isChecked)
            putBoolean(Constants.Language.langPT, rbPortuguese.isChecked)
            apply()
        }
    }
}
