package com.handen.cookassistant.presentation.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.handen.cookassistant.presentation.ui.dashboard.DishesListFragment
import com.handen.cookassistant.presentation.ui.home.HomeFragment
import com.handen.cookassistant.presentation.ui.notifications.NotificationsFragment

class TabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DishesListFragment()
            1 -> HomeFragment()
            2 -> NotificationsFragment()
            else -> throw IllegalArgumentException("TabsAdapter position > fragmentsCount")
        }
    }
}