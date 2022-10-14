package com.pl.junglesaver.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pl.junglesaver.model.WallData
import com.pl.junglesaver.R.*
import com.pl.junglesaver.adapter.WallAdapter
import com.pl.junglesaver.databinding.ActivityWallCatalogBinding


class CatalogWallActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWallCatalogBinding
    private val wallPaperRec by lazy { binding.wallRec}

    private lateinit var wallAdapter: WallAdapter
    private lateinit var wallImgList: ArrayList<WallData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWallCatalogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wallImgList = ArrayList()
        wallAdapter = WallAdapter(this, wallImgList)

        val layoutM = GridLayoutManager(applicationContext, 2)
        layoutM.orientation = LinearLayoutManager.VERTICAL
        wallPaperRec.layoutManager = layoutM
        wallPaperRec.adapter = wallAdapter

        wallPaperList()

        binding.btnBackToMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun wallPaperList() {
        wallImgList.add(WallData(drawable.jungle1))
        wallImgList.add(WallData(drawable.jungle2))
        wallImgList.add(WallData(drawable.jungle3))
        wallImgList.add(WallData(drawable.jungle4))
        wallImgList.add(WallData(drawable.jungle5))
        wallImgList.add(WallData(drawable.jungle6))
        wallImgList.add(WallData(drawable.jungle7))
        wallImgList.add(WallData(drawable.jungle8))
        wallImgList.add(WallData(drawable.jungle9))
        wallImgList.add(WallData(drawable.jungle10))
        wallImgList.add(WallData(drawable.jungle11))
        wallImgList.add(WallData(drawable.jungle12))
        wallImgList.add(WallData(drawable.jungle13))
        wallImgList.add(WallData(drawable.jungle14))
        wallImgList.add(WallData(drawable.jungle15))
    }

}