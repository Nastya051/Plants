package com.example.plantshandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private  val adapter = PlantAdapter()
    private  val imageIdList = listOf(R.drawable.giacint, R.drawable.klever, R.drawable.landysh, R.drawable.lotos, R.drawable.romashka, R.drawable.suculent)

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recycler.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index>imageIdList.size-1) index = 0
                val plant = Plant(imageIdList[index], "Plant ${index+1}")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}