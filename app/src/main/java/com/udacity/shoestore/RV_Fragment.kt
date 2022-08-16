package com.udacity.shoestore


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.*
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.udacity.shoestore.R.color
import com.udacity.shoestore.databinding.FragmentRVBinding
import com.udacity.shoestore.models.AppF_ActivityViewModel
import java.util.*
import kotlin.math.log

class RV_Fragment : Fragment() {

    val appF_ActivityViewModel: AppF_ActivityViewModel by activityViewModels()
    lateinit var linear: LinearLayout
    private lateinit var binding: FragmentRVBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRVBinding.inflate(layoutInflater)


        appF_ActivityViewModel._list.observe(viewLifecycleOwner) {
            binding.LinearLayout.removeAllViews()
           val sizee= (appF_ActivityViewModel._list.value?.size)?.minus(1)
            for (Shoe in 0..sizee!!){
                CreatTextView(appF_ActivityViewModel._list.value?.get(Shoe)!!.name,Shoe)
            }
        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linear = binding.LinearLayout
        val btn: Button = binding.hbd
        btn.setOnClickListener {
            findNavController().navigate(RV_FragmentDirections.actionRVFragmentToAddShoe())
        }

        setHasOptionsMenu(true)

    }
    fun CreatTextView(name: String,id:Int) {



        val shoeNamme = TextView(context)
        shoeNamme.text = name
        shoeNamme.setTextColor(color.purple_200)
        shoeNamme.textSize = 32.0f
        shoeNamme.id=id
        shoeNamme.gravity= Gravity.CENTER
        shoeNamme.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        (linear).addView(shoeNamme)
    }


     override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         super.onCreateOptionsMenu(menu, inflater)
         inflater?.inflate(R.menu.menu,menu)
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when(item.itemId){
             R.id.logout -> view?.let {

                 startActivity(Intent(context,Login::class.java).putExtra("Logout",true))
                 activity?.finish()
             }
         }
         return super.onOptionsItemSelected(item)
     }

}