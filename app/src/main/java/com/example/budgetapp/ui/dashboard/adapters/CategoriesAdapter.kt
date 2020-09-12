package com.example.budgetapp.ui.dashboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetapp.R
import com.example.budgetapp.repository.model.Category
import kotlinx.android.synthetic.main.category_title_view.view.*
import kotlinx.android.synthetic.main.category_view.view.*
import kotlinx.android.synthetic.main.labels_add_item_view.view.*

class CategoryAdapter(private val categories: ArrayList<Category>?, private val context: Context?) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    fun updateCategories(newCategories: ArrayList<Category>) {
        categories?.clear()
        categories?.addAll(newCategories)
    }

    private fun addNewLabelToCategory() {
        // TODO -> Open dialog fragment to add new label
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        categories?.let { labels ->
            val category: Category = categories.get(position)
            holder.categoryTitle.text = category.name
            holder.labelsRecyclerView.layoutManager = LinearLayoutManager(context)
            holder.labelsRecyclerView.adapter = LabelsAdapter(category.labels)
            holder.categoryAddButton.setOnClickListener { addNewLabelToCategory() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val categoryView =
            LayoutInflater.from(parent.context).inflate(R.layout.category_view, parent, false)
        return ViewHolder(categoryView)
    }

    override fun getItemCount(): Int = if (categories.isNullOrEmpty()) 0 else categories.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val labelsRecyclerView = itemView.labelsRecyclerView
        val categoryTitle = itemView.categoryTitleText
        val categoryAddButton = itemView.addItemView
    }
}