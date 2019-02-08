package com.example.billcalculator.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.billcalculator.R
import com.example.billcalculator.databinding.ActivityMainBinding
import com.example.billcalculator.viewmodel.RestuarantViewModel

class TipCalculatorActivity : AppCompatActivity(), SaveDialogFragment.Callback, LoadDialogFragment.Callback {

    lateinit var binding: ActivityMainBinding

    override fun onSaveTip(name: String) {
        binding.vm?.saveCurrentTip(name)
    }

    override fun onTipSelected(name: String) {
        binding.vm?.loadTipCalculation(name)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.vm = ViewModelProviders.of(this).get(RestuarantViewModel::class.java)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_tip_calculator, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_save -> {
                showSaveDialog()
                 true
            }

            R.id.action_load ->{
                showLoadDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showLoadDialog() {
        val loadDialogFragment = LoadDialogFragment()
        loadDialogFragment.show(supportFragmentManager,"LoadDialog")    }

    private fun showSaveDialog() {
        val saveDialogFragment = SaveDialogFragment()
        saveDialogFragment.show(supportFragmentManager,"SaveDialog")
    }
}
