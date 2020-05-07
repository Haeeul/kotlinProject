package com.example.kotlinproject

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WebView.setWebContentsDebuggingEnabled(true)
//        }
//        val settings = web_search.settings
//        settings.javaScriptEnabled = true
//        settings.domStorageEnabled = true
//        web_search.loadUrl("https://www.google.com/")
        web_view.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }

        web_view.loadUrl("https://www.naver.com")
    }
    override fun onBackPressed() {
        if (web_view.canGoBack()) { // 웹페이지에 뒤로 갈 수 있는 히스토리가 있는지 확인
            web_view.goBack()
        } else {
            super.onBackPressed() // 없으면 안드로이드 뒤로가기 실행.
        }
    }
}
