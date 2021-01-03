package com.handen.cookassistant.presentation.ui.dishesList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.handen.cookassistant.R
import com.handen.cookassistant.presentation.ext.viewId

class DishesListFragment : Fragment(R.layout.fragment_dishes_list) {

    private lateinit var dishesListViewModel: DishesListViewModel
    private val recyclerView by viewId<RecyclerView>(R.id.dishes_recycler_view)
    private val adapter = DishesListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dishesListViewModel = ViewModelProvider(this).get(DishesListViewModel::class.java)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        dishesListViewModel.dishes.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
    }
}