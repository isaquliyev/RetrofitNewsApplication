package com.example.newsapplication1905.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication1905.R
import com.example.newsapplication1905.model.News
import com.example.newsapplication1905.model.Results

class Adapter(list: Results) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list :Results

    init {
        this.list = list
    }

    inner class ViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {
        var titleOfNews = itemView.findViewById<TextView>(R.id.titleOfNews)
        var linkOfNews = itemView.findViewById<TextView>(R.id.linkOfNews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.recycler_view_item, parent , false))
    }

    override fun getItemCount(): Int {
        return list.results.size
    }

    override fun onBindViewHolder(holder : ViewHolder , position : Int ) {
        holder.titleOfNews.setText(list.results.get(position).title)
        holder.linkOfNews.setText(list.results.get(position).link)
    }
}