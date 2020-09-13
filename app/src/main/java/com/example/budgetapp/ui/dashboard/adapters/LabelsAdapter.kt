package com.example.budgetapp.ui.dashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetapp.R
import com.example.budgetapp.repository.model.Label
import kotlinx.android.synthetic.main.label_element_view.view.*

class LabelsAdapter(private val labels: List<Label>?) :
    RecyclerView.Adapter<LabelsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LabelsAdapter.ViewHolder {
        val categoryView =
            LayoutInflater.from(parent.context).inflate(R.layout.label_element_view, parent, false)
        return ViewHolder(categoryView)
    }

    override fun onBindViewHolder(holder: LabelsAdapter.ViewHolder, position: Int) {
        labels?.let { labels ->
            val label = labels.get(position)
            holder.labelAmount.text = label.amount.toString()
            holder.labelTitle.text = label.name
        }
    }

    override fun getItemCount(): Int = if (labels.isNullOrEmpty()) 0 else labels.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labelTitle: TextView = itemView.titleView
        val labelAmount: TextView = itemView.amountView
    }
}