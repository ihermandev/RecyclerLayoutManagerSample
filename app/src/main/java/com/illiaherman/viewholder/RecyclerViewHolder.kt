package com.illiaherman.viewholder

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.illiaherman.R
import com.squareup.picasso.Picasso

/**
 * Created by illia.herman on 14.08.2019
 */
class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemTitle = itemView.findViewById<AppCompatTextView>(R.id.tv_title)
    private val itemYear = itemView.findViewById<AppCompatTextView>(R.id.tv_year)
    private val itemLogo = itemView.findViewById<ImageView>(R.id.iv_logo)

    fun setTitle(title: String) {
        itemTitle.text = title
    }

    fun setYear(year: Int) {
        itemYear.text = itemYear.context.resources.getString(R.string.foundation_date, year)
    }

    fun setLogo(url: String) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_placeholder).into(itemLogo)
    }
}
