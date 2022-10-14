package com.pl.junglesaver.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pl.junglesaver.view.SetActivity
import com.pl.junglesaver.model.WallData
import com.pl.junglesaver.R

class WallAdapter(private var c:Context, private var wallImgLis:ArrayList<WallData>)
    :RecyclerView.Adapter<WallAdapter.WallPaperViewHolder>() {

        inner class WallPaperViewHolder(v:View):RecyclerView.ViewHolder(v) {
            val wallImg = v.findViewById<ImageView>(R.id.wall_img)!!
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallPaperViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.wall_paper_item,parent,false)

        return WallPaperViewHolder(v)
    }

    override fun onBindViewHolder(holder: WallPaperViewHolder, position: Int) {
        val newListWall = wallImgLis[position]

        holder.wallImg.setImageResource(newListWall.wallImages)
        holder.wallImg.setOnClickListener {
            val wallInt = Intent(c, SetActivity::class.java)
            wallInt.putExtra("wallImg",newListWall.wallImages)
            c.startActivity(wallInt)
        }
    }

    override fun getItemCount(): Int = wallImgLis.size
}