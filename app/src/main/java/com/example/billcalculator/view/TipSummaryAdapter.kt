package com.example.billcalculator.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.billcalculator.R
import com.example.billcalculator.databinding.SavedTipCalculationListItemBinding
import com.example.billcalculator.viewmodel.TipCalculationSummaryItem

/**
 * Created by Festus Kiambi on 2/8/19.
 */
class TipSummaryAdapter(val onItemselected: (item: TipCalculationSummaryItem) -> Unit)
    : RecyclerView.Adapter<TipSummaryAdapter.TipSummaryViewHolder>() {

    private val tipCalculationsummaries = mutableListOf<TipCalculationSummaryItem>()

    fun updateList(updates: List<TipCalculationSummaryItem>){
        tipCalculationsummaries.clear()
        tipCalculationsummaries.addAll(updates)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipSummaryViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<SavedTipCalculationListItemBinding>(
            inflater, R.layout.saved_tip_calculation_list_item,parent, false)

        return TipSummaryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tipCalculationsummaries.size
    }

    override fun onBindViewHolder(holder: TipSummaryViewHolder, position: Int) {

        holder.bind(tipCalculationsummaries[position])
    }


    inner class TipSummaryViewHolder(val binding: SavedTipCalculationListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TipCalculationSummaryItem){
            binding.item = item
            binding.root.setOnClickListener { onItemselected(item) }
            binding.executePendingBindings()
        }

    }


}