package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//TODO: list transfere and add button function and info function
//mistake in naming (this one is fore the shoe List not the hole App)
open class AppF_ActivityViewModel : ViewModel() {
         lateinit var list : MutableLiveData<ArrayList<String>>
    init {

    }

    private fun add(name:String) {
        list.value?.add(name)
    }


}