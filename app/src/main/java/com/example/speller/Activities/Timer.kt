package com.example.speller.Activities

import android.os.CountDownTimer
import android.widget.TextView
import com.example.speller.R

class Timer(var b : Long) {

    fun timer() {

        val a = object : CountDownTimer (b,1000){
            /**
             * Callback fired when the time is up.
             */
            override fun onFinish() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            /**
             * Callback fired on regular interval.
             * @param millisUntilFinished The amount of time until finished.
             */
            override fun onTick(millisUntilFinished: Long) {

                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }


}

