package com.illiaherman

import android.content.Context
import com.google.android.flexbox.*

/**
 * Created by illia.herman on 14.08.2019
 */
fun getFlexBoxLayoutManager(context: Context) : FlexboxLayoutManager {
    return  FlexboxLayoutManager(context).apply {
        flexWrap = FlexWrap.WRAP
        flexDirection = FlexDirection.ROW
        alignItems = AlignItems.FLEX_START
        justifyContent = JustifyContent.FLEX_START
    }
}