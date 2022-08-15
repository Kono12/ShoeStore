package com.udacity.shoestore


import android.os.Build.VERSION_CODES.S
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R.color
import com.udacity.shoestore.databinding.FragmentRVBinding
import com.udacity.shoestore.models.AppF_ActivityViewModel

 class RV_Fragment : Fragment() {

    val args: Add_ShoeDirections.ActionAddShoeToRVFragment by navArgs()
    var NewShoe = true
    lateinit var appF_ActivityViewModel: AppF_ActivityViewModel
    lateinit var linear: LinearLayout
    private lateinit var binding: FragmentRVBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRVBinding.inflate(layoutInflater)

        appF_ActivityViewModel = ViewModelProviders.of(this).get(AppF_ActivityViewModel::class.java)


        appF_ActivityViewModel._list.observe(viewLifecycleOwner) {
            binding.LinearLayout.removeAllViews()
           var sizee= (appF_ActivityViewModel._list.value?.size)?.minus(1)
            for (Shoe in 0..sizee!!){
                CreatTextView(appF_ActivityViewModel._list.value?.get(Shoe)!!.name,Shoe)
            }
        }

        if (NewShoe) {
            appF_ActivityViewModel.addShoe(args.name, args.size.toFloat(), args.company, args.description)
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        linear = binding.LinearLayout

        var btn: Button = binding.hbd

        btn.setOnClickListener {
            findNavController().navigate(RV_FragmentDirections.actionRVFragmentToAddShoe())
        }


    }


    fun CreatTextView(name: String,id:Int) {
        val shoeNamme = TextView(context)
        shoeNamme.text = name
        shoeNamme.setTextColor(color.purple_200)
        shoeNamme.textSize = 39.0f
        shoeNamme.id=id
        shoeNamme.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        (linear).addView(shoeNamme)
    }


}