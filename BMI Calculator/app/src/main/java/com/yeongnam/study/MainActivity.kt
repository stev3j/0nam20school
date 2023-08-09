package com.yeongnam.study

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yeongnam.study.databinding.ActivityMainBinding
import com.yeongnam.study.ui.theme.StudyTheme

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCheckResult.setOnClickListener {
            if(binding.etHeight.text.isNotBlank() && binding.etWeight.text.isNotBlank()) {

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("height", binding.etHeight.text.toString().toFloat())
                intent.putExtra("weight", binding.etWeight.text.toString().toFloat())

                startActivity(intent)
            } else {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            }
        }

    }
}