package org.techtown.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ViewControl_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_control02)

        // 뷰를 액티비티로 가져오는 방법
        val textViewOne : TextView = findViewById(R.id.textViewOne)
        val buttonOne: Button = findViewById(R.id.buttonOne)

        Log.d("testt", textViewOne .text.toString())

        // Listener 사용방법
        buttonOne.setOnClickListener {
            Log.d("tagg", "this is message")
        }
        
        // 풀버전
//        val clickListener = object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//
//        }
//        buttonOne.setOnClickListener(clickListener)
    }
}