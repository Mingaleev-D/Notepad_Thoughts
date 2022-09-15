package com.example.notepadthoughts.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.notepadthoughts.R
import com.example.notepadthoughts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

      setupNavigationComponent()

   }

   private fun setupNavigationComponent() {
      val navHostFragment =
         supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
      val navController = navHostFragment.navController

      val popupMenu = PopupMenu(this, null)
      popupMenu.inflate(R.menu.menu_bottom)
      val menu = popupMenu.menu
      binding.bottomBar.setupWithNavController(menu, navController)

      val appbarConfiguration = AppBarConfiguration.Builder(
         setOf(
            R.id.homeFragment,
            R.id.planFragment
         )).setOpenableLayout(binding.drawerLayout).build()

      binding.navView.setupWithNavController(navController)
   }
}