package com.example.offlineclinic

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.offlineclinic.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: PatientViewModel by viewModels {
        PatientViewModelFactory((application as OfflineClinicApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val note = binding.etNote.text.toString()

            lifecycleScope.launch {
                viewModel.insert(Patient(name = name, visitNote = note))
                Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}