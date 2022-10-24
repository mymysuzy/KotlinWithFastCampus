package org.techtown.kotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Intent_Two : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)

        // 4. 명시적 인텐트 + data의 연장선

        // Intent_one 엑티비티에서 넘어온 intent
        // 즉, Intent_two 엑티비티를 호출한 Activity의 intent이다
        val intent = intent
        // extras :  데이터를 꺼내는 메서드
        val data: String? = intent.extras?.getString("extra-data")
//        val data: Int? = intent.extras?.getInt("extra-data")

        // 넘어온 데이터를 활용해보자
        if (data != null) {
            Log.d("dataa", data)
        }

        // 5-1. 명시적 인텐트 + 결과 받기의 연장선
        (findViewById<TextView>(R.id.finish)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent().putExtra("result", "success")
                setResult(RESULT_OK, intent)
                // Intent_one -> Intent_two -> Intent_two 종료 -> Intent_one으로 되돌아감
                finish()
            }
        }

        // 인텐트 + 이미지의 연장선
        val imgView = findViewById<ImageView>(R.id.imgView)
        val uri = Uri.parse(intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString())

        imgView.setImageURI(uri)


    }


}