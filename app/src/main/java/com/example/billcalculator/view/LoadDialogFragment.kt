package com.example.billcalculator.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.billcalculator.R
import com.example.billcalculator.viewmodel.RestuarantViewModel
import kotlinx.android.synthetic.main.saved_tip_calculations_list.view.*

/**
 * Created by Festus Kiambi on 2/8/19.
 */

class LoadDialogFragment : DialogFragment() {
    interface Callback {
        fun onTipSelected(name: String)
    }

    private var loadTipCallback: LoadDialogFragment.Callback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        loadTipCallback = context as? Callback
    }

    override fun onDestroy() {
        super.onDestroy()
        loadTipCallback = null
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val loadDialog = context?.let { ctx ->
            AlertDialog.Builder(ctx)
                .setView(createView(ctx))
                .setNegativeButton(getString(R.string.action_cancel), null)
                .create()


        }
        return loadDialog!!
    }

    private fun createView(ctx: Context): View {

        val rv = LayoutInflater
            .from(ctx)
            .inflate(R.layout.saved_tip_calculations_list, null)
            .rv_saved_tips

        rv.setHasFixedSize(true)
        rv.addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL))

        val adapter = TipSummaryAdapter {
            loadTipCallback?.onTipSelected(it.locationName)
            dismiss()
        }

        rv.adapter = adapter

        val vm = ViewModelProviders.of(activity!!).get(RestuarantViewModel::class.java)
        vm.getSavedCalculationTips().observe(this, Observer {
            if(it !=null){
                adapter.updateList(it)
            }
        })

        return rv
    }


}