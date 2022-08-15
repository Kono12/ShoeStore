package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.udacity.shoestore.Data.Shoe
import kotlinx.android.synthetic.main.fragment_add__shoe.*

class Add_Shoe : Fragment() {
    lateinit var button : Button
    lateinit var txt1 :TextView
    lateinit var txt2 :TextView
    lateinit var txt3 :TextView
    lateinit var txt4 :TextView

     var name =""
     var size =""
     var company =""
     var descriptionn =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add__shoe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt1=view.findViewById(R.id.nameET)
        txt2=view.findViewById(R.id.sizeET)
        txt3=view.findViewById(R.id.CompanyET)
        txt4=view.findViewById(R.id.descrET)
        button=view.findViewById(R.id.saveBTN)
        button.setOnClickListener {
            //todo:send the 4 variables to RV ViewModel and save them as a new shoe
            name=txt1.text.toString()
            size= txt2.text.toString()
            company=txt3.text.toString()
            descriptionn=txt4.text.toString()

            val action = Add_ShoeDirections.actionAddShoeToRVFragment(name,size,company,descriptionn)
            view.findNavController().navigate(action)


        }
    }

}