package uz.unzosoft.maposmdroiddemo.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.unzosoft.maposmdroiddemo.R
import uz.unzosoft.maposmdroiddemo.databinding.ActivityMainBinding
import uz.unzosoft.maposmdroiddemo.databinding.ActivityMapsBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}