package com.example.mad_practical_5_21012021001

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonBrowse: Button = findViewById(R.id.button_browse)
        val editUrl: EditText =findViewById(R.id.editTextUrl)
        buttonBrowse.setOnClickListener { openBrowser(editUrl.text.toString()) }

        val buttoncall:Button=findViewById(R.id.button_Call)
        val editcall:EditText=findViewById(R.id.editTextNumber)
        buttoncall.setOnClickListener { openCall(editcall.text.toString()) }
    }
    fun openBrowser(URL: String ){
        Intent(Intent.ACTION_VIEW, Uri.parse(URL)).also { startActivity(it) }

    }
    fun openCall(number: String ){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also { startActivity(it) }

    }

    fun openCallLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun openGallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun openAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }

}