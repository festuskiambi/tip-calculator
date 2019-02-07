package com.example.billcalculator.viewmodel

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import com.example.billcalculator.BR

/**
 * Created by Festus Kiambi on 2/7/19.
 */
abstract class ObservableViewModel(app: Application) : AndroidViewModel(app), Observable{

    @delegate:Transient
    private val mCallbacks: PropertyChangeRegistry by lazy {PropertyChangeRegistry()}

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    fun notifyChange (){
        mCallbacks.notifyChange(this, BR._all)
    }
}