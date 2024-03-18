package com.example.androidproject1.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidproject1.R
import com.example.androidproject1.fragments.HomeFragment
import com.example.androidproject1.fragments.UploadFragment
import com.example.androidproject1.fragments.UsersFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Bottomtabas : AppCompatActivity() {


    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomtabas)
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.message -> {
                    loadFragment(UsersFragment())
                    true
                }
                R.id.upload -> {
                    loadFragment(UploadFragment())
                    true
                }

                else ->false
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}