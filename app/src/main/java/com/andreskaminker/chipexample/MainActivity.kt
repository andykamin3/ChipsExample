package com.andreskaminker.chipexample

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.children
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.andreskaminker.chipexample.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        binding.chipGroup.children.forEach { view->
            view.setOnClickListener {
            val checkedList = binding.chipGroup.checkedChipIds.map {
                return@map when(it){
                    R.id.chipArms ->{
                        BodyParts.ARMS.stringName
                    }
                    R.id.chipCore -> {
                        BodyParts.CORE.stringName
                    }
                    R.id.chipBack ->{
                        BodyParts.BACK.stringName
                    }
                    R.id.chipLegs ->{
                        BodyParts.LEGS.stringName
                    }
                    else -> throw IllegalArgumentException("The int required was not in the Enum")
                }
            }
                Log.d(TAG, checkedList.toString())
                binding.textView.text = checkedList.toString()
            }
        }
        super.onStart()
    }

    companion object{
        val TAG = "MainActivity"
    }
}