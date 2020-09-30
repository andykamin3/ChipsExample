package com.andreskaminker.chipexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        binding.buttonChecker.setOnClickListener {
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
        }
        super.onStart()
    }

    companion object{
        val TAG = "MainActivity"
    }
}