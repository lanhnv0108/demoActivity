package com.example.androidtutorial.activityIntent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ss = intent.getStringExtra("VALUE")
        setttex.text = ss

        btn_Send.setOnClickListener {
            intent.putExtra("S" , 2020 )
            setResult(RESULT_OK , intent)
            println("Stop")
            finish()
        }

    }

    override fun onStop() {
        super.onStop()

    }
}