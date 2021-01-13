package com.example.androidtutorial.activityIntent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_intent.*

class Intent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        btn_Send.setOnClickListener{
            val str= username.text.toString() // phai to string
            val intent = Intent(this , ActivityMain::class.java)
            intent.putExtra("VALUE" , str)
            startActivityForResult(intent , 1001)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            text2.text = data?.getIntExtra("S" , 0).toString()
        }
    }

}