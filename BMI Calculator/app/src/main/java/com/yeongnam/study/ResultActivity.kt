package com.yeongnam.study

import android.os.Bundle
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
import com.yeongnam.study.databinding.ActivityResultBinding
import com.yeongnam.study.ui.theme.StudyTheme
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val height = intent.getFloatExtra("height", 0f)
        val weight = intent.getFloatExtra("weight", 0f)

        val bmi = weight/ (height / 100.0f).pow(2.0f)

        when {
            bmi >= 35 -> {
                binding.ivFace.setImageResource(R.drawable.ic_bad)
                binding.tvYourState.text = "You are Soso fat"
            }
            bmi >= 30 -> {
                binding.ivFace.setImageResource(R.drawable.ic_bad)
                binding.tvYourState.text = "You are So fat"
            }
            bmi >= 25 -> {
                binding.ivFace.setImageResource(R.drawable.ic_bad)
                binding.tvYourState.text = "You are Fat"
            }
            bmi >= 23 -> {
                binding.ivFace.setImageResource(R.drawable.ic_sad)
                binding.tvYourState.text = "You are OverWeight"
                return
            }
            bmi >= 18.5 -> {
                binding.ivFace.setImageResource(R.drawable.ic_happy)
                binding.tvYourState.text = "You are Good"
                return
            }
            else -> {
                binding.ivFace.setImageResource(R.drawable.ic_sad)
                binding.tvYourState.text = "You are UnderWeight"
                return
            }


        }

    }
}