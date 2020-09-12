package com.example.budgetapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetapp.databinding.DashboardFragmentBinding
import com.example.budgetapp.ui.dashboard.adapters.CategoryAdapter

class DashboardFragment : Fragment() {

    private lateinit var viewModel: DashboardViewModel
    private var binding: DashboardFragmentBinding? = null
    private val budgetAdapter = CategoryAdapter(null, context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }


    private fun setupUI() {
        binding?.categoriesRecyclerView?.let {
            it.adapter = budgetAdapter
            it.layoutManager = LinearLayoutManager(context)
        }
        binding?.categoriesRecyclerView?.adapter = budgetAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}