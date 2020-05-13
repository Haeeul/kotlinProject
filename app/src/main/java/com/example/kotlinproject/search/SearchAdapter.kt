package com.example.kotlinproject.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.data.searchResponseDataItem

class SearchAdapter (private val context: Context) : RecyclerView.Adapter<SearchViewHolder>(){

    var data: List<searchResponseDataItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_search, parent,false)

        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.onbind(data[position])
    }
}