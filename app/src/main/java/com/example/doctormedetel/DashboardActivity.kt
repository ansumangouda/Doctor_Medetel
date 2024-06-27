package com.example.doctormedetel

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.transition.FragmentTransitionSupport
import com.example.doctormedetel.shared_preferences.SharedPreferences

class DashboardActivity : AppCompatActivity() {
    lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        val sharedPreferences = SharedPreferences(this)
        text = findViewById(R.id.textt)
        val token:String = sharedPreferences.getAccessToken().toString()
        text.setText(token)

    }

    @SuppressLint("RestrictedApi", "CommitTransaction")
    private fun lodeFragment(fragment: Fragment, canAddBackStark : Boolean){
        var fragmentManager:FragmentManager = supportFragmentManager
        var fragmentTransition: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer,fragment)

        if (canAddBackStark){
            fragmentTransition.addToBackStack(fragment.tag)

        }
        fragmentTransition.commit()
    }

    private fun setFindViewIds(){

    }

}






