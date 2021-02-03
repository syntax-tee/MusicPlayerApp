package com.ogunladetaiye.udux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView


class UduxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_udux)
        initializeBottomNavigationView()
    }


    fun initializeBottomNavigationView(){
        //Initialize Bottom Navigation View.
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)


        //Pass the ID's of Different destinations
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.myUduxFragment,
            R.id.videoFragment,
            R.id.discoverFragment,
            R.id.connectFragment,
            R.id.searchFragment).build()

        //Initialize NavController.
        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        bottomNavView.selectedItemId = R.id.discoverFragment
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }
}
