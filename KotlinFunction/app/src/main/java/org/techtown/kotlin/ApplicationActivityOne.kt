package org.techtown.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ApplicationActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_one)

        findViewById<TextView>(R.id.changeActivity).setOnClickListener {
            startActivity(
                Intent(this, ApplicationActivityTwo::class.java)
            )
        }
    }
}