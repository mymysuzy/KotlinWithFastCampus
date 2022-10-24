package org.techtown.kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import java.lang.Exception

class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val address = findViewById<EditText>(R.id.address)
        var url = ""
        var prefixedUrl = "https://"

        val open = findViewById<Button>(R.id.open)
        val webView = findViewById<WebView>(R.id.webView)

        address.doAfterTextChanged { url = prefixedUrl + address.text.toString() }

        open.setOnClickListener {
//            webView.loadUrl(url)
//            Log.d("loggg",url )
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

        // 이제 내 앱에서 홈페이지 켜는 작업
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }

        // try-catch문 없어도 실행되어야 하는것 아닌가.?
        try {
            webView.loadUrl(intent.data!!.toString())
        } catch (exception: Exception) {

        }

    }
}