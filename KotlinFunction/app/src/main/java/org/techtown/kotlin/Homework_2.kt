package org.techtown.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged

class Homework_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2)

        val webView = findViewById<WebView>(R.id.webView)
        val urlPrefix: String = "https://"
        var finalUrl:String = ""

        val address = findViewById<EditText>(R.id.address)

        // addTextChangedListener 사용법 -object사용
        address.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        })

        // addTextChangedListener 사용법 -람다 사용
        // object사용보다 효율적이다. 세가지 모든 함수를 구현하지 않아도 되기 때문에
//        address.doBeforeTextChanged { text, start, count, after ->  }
//        address.doOnTextChanged { text, start, before, count ->  }
        address.doAfterTextChanged {
            finalUrl = urlPrefix + it.toString()
        }

        val open = findViewById<TextView>(R.id.open)
        open.setOnClickListener {
//            val url = address.text
            webView.loadUrl(finalUrl)
        }

    }
}