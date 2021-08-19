package com.aditya.artistassemble.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.aditya.artistassemble.R
import com.aditya.artistassemble.activity.OrderActivity
import com.aditya.artistassemble.model.Drawing
import kotlinx.android.synthetic.main.activity_order.*

class DashboardRecyclerAdapter(val Context: Context, val itemList: ArrayList<Drawing>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val resThumbnail = view.findViewById(R.id.imgArtworkThumbnail) as ImageView
        val artworkName: TextView = view.findViewById(R.id.txtArtworkName) as TextView
        val artistName = view.findViewById(R.id.txtArtistName) as TextView
        val rating = view.findViewById(R.id.txtRating) as TextView
        val price = view.findViewById(R.id.txtCost) as TextView
        val llContent: LinearLayout = view.findViewById(R.id.llContent)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_single_row, parent, false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val drawings = itemList.get(position)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.resThumbnail.clipToOutline = true
        }
        holder.artworkName.text = drawings.artTitle
        holder.rating.text = drawings.artRating
        holder.artistName.text = drawings.artist
        val cost = "${drawings.artCost.toString()}"
        holder.price.text = cost
        holder.resThumbnail.setImageResource(drawings.artworkImage)
        holder.llContent.setOnClickListener {
            val intent = Intent(Context, OrderActivity::class.java)
            val bundle = Bundle()
            bundle.putString("artTitle", drawings.artTitle.toString())
            bundle.putString("artistName", drawings.artist.toString())
            bundle.putString("artRating", drawings.artRating.toString())
            bundle.putString("artCost", drawings.artCost.toString())
            bundle.putInt("artImage", drawings.artworkImage)
            intent.putExtras(bundle)
            Context.startActivity(intent, bundle)

        }

    }

}

