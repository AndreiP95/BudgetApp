package com.example.budgetapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetapp.databinding.DashboardFragmentBinding
import com.example.budgetapp.repository.model.Category
import com.example.budgetapp.repository.model.Label
import com.example.budgetapp.ui.dashboard.adapters.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val viewModel: DashboardViewModel by viewModels()
    private var binding: DashboardFragmentBinding? = null
    private val budgetAdapter = CategoryAdapter(ArrayList(), context)

    private val categories: Array<Category> =
        Array(5, { i -> Category(i.toLong(), "Money", 123.0, "Planned") })

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
        randomLabel.add(Label(0, 0, "Random", 123.0))
        randomLabel.add(Label(1, 1, "Random", 123.0))
        randomLabel.add(Label(2, 2, "Random", 123.0))
        randomLabel.add(Label(3, 3, "Random", 123.0))


        return randomLabel
    }

    private fun mockCategories() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mockCategories()
        viewModel.initData(categories)
        setupUI()
    }


    private fun setupUI() {

        binding?.categoriesRecyclerView?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = budgetAdapter
            budgetAdapter.updateCategories(categories.toCollection(ArrayList()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}