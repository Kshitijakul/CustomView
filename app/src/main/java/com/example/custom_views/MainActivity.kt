package com.example.custom_views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Button
import android.widget.CompoundButton

class MainActivity : AppCompatActivity() {

    lateinit var mBtnExit    :Exit_btn
    lateinit var mChkExit :CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        init()

        mChkExit.setOnCheckedChangeListener(MyOnCheckedChangeListener())
    }


        private inner class MyOnCheckedChangeListener :CompoundButton.OnCheckedChangeListener
        {
            override fun onCheckedChanged(compoundButton: CompoundButton?, isChecked: Boolean)

            {
                mBtnExit.setExitable(isChecked)
            }
        }

        private fun init()
        {
            mBtnExit=findViewById(R.id.btn_exit)
            mChkExit=findViewById(R.id.chk_exit)
        }

    }
