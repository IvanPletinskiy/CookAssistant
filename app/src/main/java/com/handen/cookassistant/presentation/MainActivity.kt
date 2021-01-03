package com.handen.cookassistant.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.handen.cookassistant.R
import com.handen.cookassistant.presentation.ext.viewId
import com.handen.cookassistant.presentation.util.TabsAdapter
import com.handen.cookassistant.presentation.util.ViewPagerMediator

class MainActivity : AppCompatActivity() {

    private val viewPager by viewId<ViewPager2>(R.id.view_pager)
    private val bottomNavigationView by viewId<BottomNavigationView>(R.id.bottom_navigation_view)
    private lateinit var viewPagerMediator: ViewPagerMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = TabsAdapter(this)
        viewPagerMediator = ViewPagerMediator(viewPager, bottomNavigationView)
        viewPagerMediator.mediate()
    }
}