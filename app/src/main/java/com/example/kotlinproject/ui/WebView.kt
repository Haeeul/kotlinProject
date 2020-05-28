package com.example.kotlinproject.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinproject.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        web_view.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }

        val intent = getIntent()
        web_view.loadUrl(intent.getStringExtra("link"))
    }
    override fun onBackPressed() {
        if (web_view.canGoBack()) { // 웹페이지에 뒤로 갈 수 있는 히스토리가 있는지 확인
            web_view.goBack()
        } else {
            super.onBackPressed() // 없으면 안드로이드 뒤로가기 실행.
        }
    }
}
