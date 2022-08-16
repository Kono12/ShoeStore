package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Data.Shoe

//TODO: list transfere and add button function and info function
//mistake in naming (this one is fore the shoe List not the hole App)
open class AppF_ActivityViewModel : ViewModel() {

      var nameET = MutableLiveData<String>()
      var sizeET = MutableLiveData<String>()
      var companyET = MutableLiveData<String>()
      var descriptionET = MutableLiveData<String>()
      var _list = MutableLiveData<ArrayList<Shoe>>()

init {
   _list.value = ArrayList()
    _list.value!!.add(Shoe("Black Shoe",41.0f,"adidas","Nice Shoe "))
    _list.value!!.add(Shoe("White Shoe",51.0f,"adidas","Nice Shoe "))
    _list.value!!.add(Shoe("Red Shoe",451.0f,"adidas","Nice Shoe "))
}

    fun reset(){
        nameET.value=""
        sizeET.value=""
        companyET.value=""
        descriptionET.value=""
    }
    fun addETshoe(){
        val sizee=sizeET.value.toString().toFloat()
        val namee=nameET.value.toString()
        val companyy=companyET.value.toString()
        val descriptionn=descriptionET.value.toString()
        _list.value?.add(Shoe(namee,sizee,companyy,descriptionn))
    }
    fun addShoe(name: String, size: String, company: String, description:String) {
        val sizee = size.toFloat()+0.0f
        _list.value!!.add(Shoe(name, sizee, company, description))
    }



}