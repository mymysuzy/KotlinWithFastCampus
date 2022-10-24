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

        // xml에 있는 뷰 컴포넌트를 액티비티로 가져옴
        val textViewOne : TextView = findViewById(R.id.textViewOne)
        val buttonOne: Button = findViewById(R.id.buttonOne)

        Log.d("testt", textViewOne.text.toString())


        // Listener 사용방법
        buttonOne.setOnClickListener {
            // 버튼이 클릭되었을 때 넣고싶은 동작 구현
            Log.d("tagg", "버튼을 누르셨습니다.")
        }
        
        // Listener 풀버전
//        val clickListener = object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Log.d("tagg", "버튼을 누르셨습니다.")
//            }
//
//        }
//        buttonOne.setOnClickListener(clickListener)

        // Listener 축약버전
//        buttonOne.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                Log.d("tagg", "버튼을 누르셨습니다.")
//            }
//        })
    }


}