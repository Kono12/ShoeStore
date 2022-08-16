package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.models.AppF_ActivityViewModel
import java.lang.Exception

class Add_Shoe : Fragment() {

    lateinit var cancel: Button
    lateinit var button: Button
    lateinit var txt1: TextView
    lateinit var txt2: TextView
    lateinit var txt3: TextView
    lateinit var txt4: TextView

    var name = ""
    var size = ""
    var company = ""
    var descriptionn = ""

    val viewModel: AppF_ActivityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add__shoe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        txt1 = view.findViewById(R.id.nameET)
        txt2 = view.findViewById(R.id.sizeET)
        txt3 = view.findViewById(R.id.CompanyET)
        txt4 = view.findViewById(R.id.descrET)
        button = view.findViewById(R.id.saveBTN)
        cancel = view.findViewById(R.id.cancelBTN)
        button.setOnClickListener {

            //todo:send the 4 variables to RV ViewModel and save them as a new shoe
            name = txt1.text.toString()
            size = txt2.text.toString()
            company = txt3.text.toString()
            descriptionn = txt4.text.toString()

            val NameChecker: Boolean = name != "" && name != null && name is String
            val CompanyChecker: Boolean = company != "" && company != null && company is String
            val DescriptionChecker: Boolean =
                descriptionn != "" && descriptionn != null && descriptionn is String
            val SizeChecker: Boolean = size.toFloatOrNull() != null
            if (NameChecker && SizeChecker && CompanyChecker && DescriptionChecker) {

                viewModel.addShoe(name, size, company, descriptionn)

                val action = Add_ShoeDirections.actionAddShoeToRVFragment()
                view.findNavController().navigate(action)
            } else {
                Toast.makeText(context, "Try again", Toast.LENGTH_SHORT).show()
            }
        }
        cancel.setOnClickListener {
            val action = Add_ShoeDirections.actionAddShoeToRVFragment()
            view.findNavController().navigate(action)
        }
    }
}
