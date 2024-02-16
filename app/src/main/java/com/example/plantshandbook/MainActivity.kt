package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PlantAdapter.Listener {
    lateinit var binding: ActivityMainBinding
    private  val adapter = PlantAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU){
                    it.data?.getSerializableExtra("plant", Plant::class.java)
                        ?.let { it1 -> adapter.addPlant(it1)}
                }else {
                    adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
                }
            }
        }
    }

    private fun init(){
        binding.apply {
            recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recycler.adapter = adapter
            buttonAdd.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity2::class.java))
            }
        }
    }

    override fun onClick(plant: Plant) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item", plant)
        })
    }
}