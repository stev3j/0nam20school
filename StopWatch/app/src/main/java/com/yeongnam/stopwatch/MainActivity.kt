package com.yeongnam.stopwatch

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yeongnam.stopwatch.databinding.ActivityMainBinding
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask : Timer? = null
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var isRunning = false
    private var lab = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fabStart.setImageResource(R.drawable.ic_play)
        binding.fabRefresh.setImageResource(R.drawable.ic_refresh)
        binding.fabLab.setImageResource(R.drawable.ic_timer)

        binding.fabStart.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) start()
            else pause()
        }

        binding.fabLab.setOnClickListener {
            recordLabTime()
        }

        binding.fabRefresh.setOnClickListener {
            reset()
        }
    }

    private fun start() {
        binding.fabStart.setImageResource(R.drawable.ic_pause)
        timerTask = timer(period = 10L) {
            time++
            val sec = time/100
            val milli = time%100
            runOnUiThread {
                binding.tvSec.text = sec.toString()
                binding.tvSecMilli.text = milli.toString()
            }
        }
    }

    private fun pause() {
        binding.fabStart.setImageResource(R.drawable.ic_play)
        timerTask?.cancel()
    }

    private fun recordLabTime() {
        val labTime = this.time
        val tvLab = TextView(this)
        tvLab.text = "$lab. LAP : ${labTime / 100}.${labTime % 100}"

        binding.labLayout.addView(tvLab, 0)
        lab++
    }

    private fun reset() {
        timerTask?.cancel()
        time = 0
        isRunning = false
        binding.fabStart.setImageResource(R.drawable.ic_play)
        binding.tvSec.text = "0"
        binding.tvSecMilli.text = "00"
        binding.labLayout.removeAllViews()
        lab = 1
    }
}