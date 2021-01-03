package com.handen.cookassistant.presentation.util

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.handen.cookassistant.R

class ViewPagerMediator(private val viewPager: ViewPager2, private val bottomNavigationView: BottomNavigationView) {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> viewPager.currentItem = 0
            R.id.navigation_dashboard -> viewPager.currentItem = 1
            R.id.navigation_notifications -> viewPager.currentItem = 2
        }

        true
    }

    private val onPageChangedCallback = object: ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            bottomNavigationView.selectedItemId = when (position) {
                0 -> R.id.navigation_home
                1 -> R.id.navigation_dashboard
                2 -> R.id.navigation_notifications
                else -> throw IllegalArgumentException()
            }
        }
    }

    fun mediate() {
        viewPager.registerOnPageChangeCallback(onPageChangedCallback)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}