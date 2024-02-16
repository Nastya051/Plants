package com.example.plantshandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantshandbook.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("item") as Plant

        binding.apply {
            imMain.setImageResource(item.imageId)
            textViewTitle.text = item.title
            textViewContent.text = item.desc
        }
    }
}