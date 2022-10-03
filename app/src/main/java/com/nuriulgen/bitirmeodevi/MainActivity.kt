package com.nuriulgen.bitirmeodevi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.core.view.isNotEmpty
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nuriulgen.bitirmeodevi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        showBottomNavigation()

       /* var bottomNavigationMenuView = (bottomNavigationView[0] as BottomNavigationMenuView)
        if (bottomNavigationMenuView.isNotEmpty()) {
            bottomNavigationMenuView[TAB_INDEX].setBackgroundResource(R.drawable.ic_nav_bar_background)
        }*/

    }

    private fun showBottomNavigation(){
        /**
         * Nav host Fragment ile Bottom Navigation Bar birbirine bağlandı.
         *
         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}