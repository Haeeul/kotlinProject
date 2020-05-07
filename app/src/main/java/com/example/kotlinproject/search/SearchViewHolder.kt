package com.example.kotlinproject.search

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.WebView

class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val txtRvItemTitle: TextView = view.findViewById(R.id.list_item_title)
    val txtRvItemDesc: TextView = view.findViewById(R.id.list_item_desc)

    fun onbind(data: SearchItem){
        txtRvItemTitle.text = data.title
        txtRvItemDesc.text = data.desc

        itemView.setOnClickListener{
            val context = it.context
            val intent = Intent(context, WebView::class.java)

            context.startActivity(intent)
        }
    }
}