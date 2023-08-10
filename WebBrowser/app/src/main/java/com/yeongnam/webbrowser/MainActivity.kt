package com.yeongnam.webbrowser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import com.yeongnam.webbrowser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                }
            }
        }
        binding.webView.loadUrl("https://www.google.com")

        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.webView.loadUrl(binding.etSearch.text.toString())
                true
            } else {
                false
            }
        }
        registerForContextMenu(binding.webView)
    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)  {
            R.id.action_google, R.id.action_home -> {
                binding.webView.loadUrl("https://www.google.com")
                return true
            }
            R.id.action_naver -> {
                binding.webView.loadUrl("https://www.naver.com")
                return true
            }
            R.id.action_yahoo -> {
                binding.webView.loadUrl("https://www.yahoo.com")
                return true
            }
            R.id.action_call -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:053-615-1233")
                if(intent.resolveActivity(packageManager) != null) startActivity(intent)
                return true
            }
            R.id.action_send_message -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:053-615-1233")
                if(intent.resolveActivity(packageManager) != null) startActivity(intent)
                return true
            }
            R.id.action_send_email -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:053-615-1233")
                if(intent.resolveActivity(packageManager) != null) startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_share -> {
                binding.webView.url?.let { url ->

                }
                return true
            }
            R.id.action_browser -> {
                binding.webView.url?.let { url ->

                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}