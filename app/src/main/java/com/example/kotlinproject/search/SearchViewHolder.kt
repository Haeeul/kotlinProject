package com.example.kotlinproject.search

import android.content.Intent
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.WebView
import com.example.kotlinproject.data.searchResponseDataItem

class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val txtRvItemTitle: TextView = view.findViewById(R.id.list_item_title)
    val txtRvItemDesc: TextView = view.findViewById(R.id.list_item_desc)

    fun onbind(data: searchResponseDataItem){
        txtRvItemTitle.text = Html.fromHtml(data.title)
        txtRvItemDesc.text = Html.fromHtml(data.description)

        itemView.setOnClickListener{
            val context = it.context
            val intent = Intent(context, WebView::class.java)
            intent.putExtra("link",data.link)

            context.startActivity(intent)
        }
    }
}