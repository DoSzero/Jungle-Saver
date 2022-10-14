package com.pl.junglesaver.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pl.junglesaver.databinding.ActivityMenuBinding

class MenuActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private val btnToCatalog by lazy { binding.btnToCatalog }
    private val btnMore by lazy { binding.btnMore }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            this.supportActionBar?.hide()
        }

        btnToCatalog.setOnClickListener {
            val intent = Intent(this, CatalogWallActivity::class.java)
            startActivity(intent)
        }

        btnMore.setOnClickListener {
            val intent = Intent(this, MoreActivity::class.java)
            startActivity(intent)
        }
    }
}