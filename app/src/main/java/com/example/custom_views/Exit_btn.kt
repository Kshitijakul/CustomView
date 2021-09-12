package com.example.custom_views

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.ViewPropertyAnimator
import android.widget.Button
import android.widget.Toast


@SuppressLint("AppCompatCustomView")
class Exit_btn : Button
{
   private lateinit var mContext: Context
   private var mIsExitable :Boolean

   constructor(context: Context):super(context)
   {
       mContext=context
       mIsExitable=true
       hookup()
   }

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)
    {
        mContext=context
        mIsExitable=true
      hookup()    //what is it?
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.e("tag","onDraw")

        var paint= Paint()
        paint.color= Color.RED
        canvas?.drawLine(80f,0f,80f,height.toFloat(),paint)
        canvas?.drawLine(110f,0f,110f,height.toFloat(),paint)
    }

        fun setExitable(exitable:Boolean)
        {
            mIsExitable=exitable
    }
fun isExitable()=mIsExitable

    private fun hookup()
    {
        setOnClickListener{
            if(mIsExitable==false)
            {
                Toast.makeText(mContext,"Button is not Exitable!",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var builder=AlertDialog.Builder(mContext)
            builder.setTitle("BitCode")
            builder.setMessage("Are you sure to exit app?")

            builder.setPositiveButton("Exit",DialogInterface.OnClickListener()
            { dialogInterface: DialogInterface, which: Int ->
                System.exit(0)
            })

            builder.setNegativeButton("No",DialogInterface.OnClickListener()
            { dialogInterface: DialogInterface, which: Int ->dialogInterface.dismiss()

            })

            builder.create().show()
        }



        }
    }



