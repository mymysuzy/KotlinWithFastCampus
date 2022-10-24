package org.techtown.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        findViewById<TextView>(R.id.text).setOnClickListener {
            (it as TextView).text = resources.getText(R.string.app_name)

            it.background = resources.getDrawable(R.drawable.calculator_bg, null)
            // 아래의 방법대로 해도 위와 같은 결과가 나온다
            // SDK버전에 따라 총 3가지 방법 중 안돼는 방법이 있기 때문에 되는 방법을 사용해주면 된다
//            it.background = ContextCompat.getDrawable(this, R.drawable.calculator_bg)
//            it.background = ResourcesCompat.getDrawable(resources, R.drawable.calculator_bg, null)

        }
    }
}