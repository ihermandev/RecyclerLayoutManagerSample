package com.illiaherman.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.illiaherman.MainActivity
import com.illiaherman.R
import com.illiaherman.model.FootballClub
import com.illiaherman.viewholder.RecyclerViewHolder

/**
 * Created by illia.herman on 14.08.2019
 */
class RecyclerAdapter(
    private var dataList: List<FootballClub>,
    private var currentViewType: MainActivity.ViewType
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return when (viewType) {
            CellType.LIST.ordinal -> RecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_list,
                    parent,
                    false
                )
            )
            CellType.CARD.ordinal -> RecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_card,
                    parent,
                    false
                )
            )
            CellType.GRID.ordinal -> RecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_grid,
                    parent,
                    false
                )
            )
            CellType.FLEXBOX.ordinal -> RecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_flexbox,
                    parent,
                    false
                )
            )
            else -> {
                RecyclerViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.viewholder_list,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentDataItem = dataList[position]
        holder.apply {
            this.setTitle(currentDataItem.name)
            this.setLogo(currentDataItem.logo)
            if (currentViewType != MainActivity.ViewType.FLEXBOX) {
                this.setYear(currentDataItem.foundedYear)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (currentViewType) {
            MainActivity.ViewType.LIST -> CellType.LIST.ordinal
            MainActivity.ViewType.CARD -> CellType.CARD.ordinal
            MainActivity.ViewType.GRID -> CellType.GRID.ordinal
            MainActivity.ViewType.FLEXBOX -> CellType.FLEXBOX.ordinal
        }
    }

    /**
     * Enum class for recyclerview Cell type
     */
    enum class CellType(viewType: Int) {
        LIST(0),
        CARD(1),
        GRID(2),
        FLEXBOX(3)
    }
}