package com.example.hicure.serveinfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hicure.R
import com.example.hicure.databinding.InfoDetailsBinding

class ActivityLungCapacityPrediction : AppCompatActivity() {

    val binding: InfoDetailsBinding by lazy { InfoDetailsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val infoSubTitle = intent.getStringExtra("subTitle")
        val infoTitle = intent.getStringExtra("title")

        "$infoTitle".also { binding.actionTitle.text = it }

        binding.actionTitle.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.actionTitle.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val actionTextWidth = binding.actionTitle.width
                binding.actionTitle.width = actionTextWidth + 10

                val layoutParams = binding.behindTitle.layoutParams
                layoutParams.width = actionTextWidth + 30
                binding.behindTitle.layoutParams = layoutParams
            }
        })

        binding.subTitle.text = infoSubTitle

        binding.content1.visibility = View.GONE
        binding.content2.visibility = View.GONE
        binding.content3.visibility = View.GONE
        binding.content4.visibility = View.GONE
        binding.content5.visibility = View.GONE

        binding.imageRes.setImageResource(R.drawable.image2)
        binding.imageRes.setOnClickListener {
            val intent = Intent(this, FullScreenImageActivity::class.java).apply {
                putExtra("imageResId", R.drawable.image2)
            }
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener{
            finish()
        }
    }
}