package com.handen.cookassistant.presentation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.handen.cookassistant.R

class DishesListFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var dishesListViewModel: DishesListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dishesListViewModel = ViewModelProvider(this).get(DishesListViewModel::class.java)
    }
}