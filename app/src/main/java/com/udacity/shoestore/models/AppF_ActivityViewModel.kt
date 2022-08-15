package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Data.Shoe

//TODO: list transfere and add button function and info function
//mistake in naming (this one is fore the shoe List not the hole App)
open class AppF_ActivityViewModel : ViewModel() {

     var _list = MutableLiveData<ArrayList<Shoe>>()

init {
   _list.value = ArrayList()
    _list.value!!.add(Shoe("Black Shoe",41.0f,"adidas","Nice Shoe "))
    _list.value!!.add(Shoe("White Shoe",51.0f,"adidas","Nice Shoe "))
    _list.value!!.add(Shoe("Red Shoe",451.0f,"adidas","Nice Shoe "))
}



    fun addShoe(name: String, size: Float , company : String, description:String) {
        _list.value!!.add(Shoe(name, size, company, description))
    }



}