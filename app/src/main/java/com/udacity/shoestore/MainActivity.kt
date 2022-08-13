package com.udacity.shoestore

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import timber.log.Timber

class MainActivity : Login() {

    var next:Int=0
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        txt1=findViewById(R.id.Txt1)
        txt2=findViewById(R.id.Txt2)
    }

    fun onNextClicked(view: View) {
        when(next){
            0 -> {
                next=1
                txt1.text="You can add more shoes by clicking on"
                txt1.textSize=28.0f
               // txt1.setTextColor(Color.parseColor("#fff"))

                txt2.text="The Plus button"
                txt2.textSize=28.0f
                //txt2.setTextColor(Color.parseColor("#fff"))
            }
            1->{
                Loged()
                val intent = Intent(this.applicationContext, AppFragmentsActivity::class.java)
                startActivity(intent)
                finish()

            }

        }
    }
}
