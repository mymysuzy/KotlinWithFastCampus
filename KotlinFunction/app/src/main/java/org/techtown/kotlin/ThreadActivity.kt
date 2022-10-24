package org.techtown.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val currentThread = Thread.currentThread()
        Log.d("tesddds", "" + currentThread)

        Thread {
            for (a in 1..1000) {
                Log.d("testt", "A" + a)
            }
        }.start()

        Thread {
            for (a in 1..1000) {
                Log.d("testt", "B" + a)
            }
        }.start()

    }
}