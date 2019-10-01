package com.illiaherman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.illiaherman.adapter.RecyclerAdapter
import com.illiaherman.model.Data
import com.illiaherman.model.FootballClub
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList: ArrayList<FootballClub> = Data.footballClubList
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_list -> {
                ViewType.valueOf(0).let {
                    if (it != null) {
                        initAdapter(it)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_card -> {
                ViewType.valueOf(1).let {
                    if (it != null) {
                        initAdapter(it)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_grid -> {
                ViewType.valueOf(2).let {
                    if (it != null) {
                        initAdapter(it)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_flexbox -> {
                ViewType.valueOf(3).let {
                    if (it != null) {
                        initAdapter(it)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        nav_view.selectedItemId = R.id.navigation_card
    }

    private fun initAdapter(currentFilter: ViewType) {
        val adapter = RecyclerAdapter(dataList, currentFilter)
        when (currentFilter) {
            ViewType.GRID -> {
                rv_base.layoutManager = GridLayoutManager(this, 2)
            }
            ViewType.FLEXBOX -> {
                rv_base.layoutManager = getFlexBoxLayoutManager(context = this)
            }
            else -> {
                rv_base.layoutManager = LinearLayoutManager(this)
            }
        }
        rv_base.adapter = adapter
    }

    enum class ViewType(val value: Int) {
        LIST(0),
        CARD(1),
        GRID(2),
        FLEXBOX(3);

        companion object {
            fun valueOf(value: Int): ViewType? = values().find { it.value == value }
        }
    }
}
