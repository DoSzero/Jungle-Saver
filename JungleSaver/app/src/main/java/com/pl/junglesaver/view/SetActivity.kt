package com.pl.junglesaver.view

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pl.junglesaver.R
import com.pl.junglesaver.databinding.ActivityMenuBinding
import com.pl.junglesaver.databinding.ActivitySetBinding
import com.pl.junglesaver.utils.DialogsUtils

class SetActivity : AppCompatActivity() , DialogsUtils.ExampleDialogListener {

    private lateinit var binding: ActivitySetBinding
    private val bSetWallPaper by lazy { binding.setWallpaperButton }
    private val wallImg by lazy { binding.wallpaperImage }
    private val btnBack by lazy { binding.btnBack }

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newWallImg = intent.extras?.getInt("wallImg")
        if (newWallImg != null) {
            wallImg.setImageResource(newWallImg)
        }

        bSetWallPaper!!.setOnClickListener {
            openDialog()
            try {
                if (newWallImg != null) {
                    WallpaperManager.getInstance(applicationContext).setResource(newWallImg)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, CatalogWallActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openDialog() {
        DialogsUtils().show(supportFragmentManager,"Dialog")
    }

    override fun onYesClicked() {

    }
}