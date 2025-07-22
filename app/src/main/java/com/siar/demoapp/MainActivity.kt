package com.siar.demoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.siar.demoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.qualifiedName

    private lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
    }

    private fun initComponents() {
        binding.lblHello.text = viewModel.textLabel.value
        binding.btnMain.text = getString(R.string.btn_text)
        binding.lblCount.text = viewModel.lblCount.value

        handleActions()
    }

    private fun handleActions() {
        binding.btnMain.setOnClickListener {
            viewModel.buttonPressed()
            binding.lblHello.text = viewModel.textLabel.value
            Log.d(TAG, "press button: ${viewModel.count}")
            binding.lblCount.text = viewModel.lblCount.value
        }
    }
}