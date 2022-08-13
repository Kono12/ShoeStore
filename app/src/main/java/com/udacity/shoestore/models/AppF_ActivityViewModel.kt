package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Data.Shoe

//TODO: list transfere and add button function and info function
//mistake in naming (this one is fore the shoe List not the hole App)
open class AppF_ActivityViewModel : ViewModel() {

    private val _list = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _list

    var ShoeNAme = ""
    var ShoeSize = 0.0
    var Company = ""
    var Description = ""

    init {

    }



    private fun addShoe(name: String, size: Int , company : String, description:String) {
        _list.value!!.add(Shoe(name, size, company, description))
    }


}