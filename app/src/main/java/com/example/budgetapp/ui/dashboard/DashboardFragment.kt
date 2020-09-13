package com.example.budgetapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetapp.databinding.DashboardFragmentBinding
import com.example.budgetapp.repository.model.Category
import com.example.budgetapp.repository.model.Label
import com.example.budgetapp.ui.dashboard.adapters.CategoryAdapter

class DashboardFragment : Fragment() {

    private lateinit var viewModel: DashboardViewModel
    private var binding: DashboardFragmentBinding? = null
    private val budgetAdapter = CategoryAdapter(ArrayList(), context)

    private val categories: ArrayList<Category> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    private fun randomLabels(): List<Label> {
        val randomLabel = ArrayList<Label>()
        randomLabel.add(Label("Random", 123.0))
        randomLabel.add(Label("Random", 123.0))
        randomLabel.add(Label("Random", 123.0))
        randomLabel.add(Label("Random", 123.0))


        return randomLabel
    }

    private fun mockCategories() {
        categories.add(Category("Money", 123.0, "Planned", randomLabels()))
        categories.add(Category("Money", 123.0, "Planned", randomLabels()))
        categories.add(Category("Money", 123.0, "Planned", randomLabels()))
        categories.add(Category("Money", 123.0, "Planned", randomLabels()))
        categories.add(Category("Money", 123.0, "Planned", randomLabels()))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mockCategories()
        setupUI()
    }


    private fun setupUI() {
        binding?.categoriesRecyclerView?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = budgetAdapter
            budgetAdapter.updateCategories(categories)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}