package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantshandbook.databinding.ActivityEditBinding

class EditActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.giacint
    private  val imageIdList = listOf(R.drawable.giacint, R.drawable.klever,
        R.drawable.landysh, R.drawable.lotos,
        R.drawable.romashka, R.drawable.suculent)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons()= with(binding){
        buttonNext.setOnClickListener{
            indexImage++
            if(indexImage > imageIdList.size-1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageViewChoose.setImageResource(imageId)
        }
        buttonDone.setOnClickListener {
            val plant = Plant(imageId, edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}