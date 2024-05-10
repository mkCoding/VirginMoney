package com.example.virginmoney

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.virginmoney.databinding.ActivityMainBinding
import com.example.virginmoney.ui.person_list.PersonListFragment
import com.example.virginmoney.ui.room_list.RoomListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_people_list) as NavHostFragment
        val navController = navHostFragment.navController
//        navController.navigate(R.id.action_personListFragment_to_personDetailsFragment)


        //navHostFragment.findNavController().navigate(R.id.personDetailsFragment)
        //When the app initially loads always show the PersonListFragment 1st
//        replaceFragment(PersonListFragment())

//        navController.navigate(R.id.per)

        //This will handle the Bottom navigation. Switches between People and Rooms Fragment
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_people_list -> navController.navigate(R.id.nav_people_list)//replaceFragment(PersonListFragment())
                R.id.nav_rooms -> navController.navigate(R.id.nav_rooms)//replaceFragment(RoomListFragment())
                else ->{}
            }
             true
        }

        //hide bottom nav
        navController.addOnDestinationChangedListener{_,destination, _ ->
            if(destination.id == R.id.personDetailsFragment){
                binding.bottomNavigationView.visibility = View.GONE
            }else{
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }


    }





//  private fun replaceFragment (fragment: Fragment){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frameLayout,fragment)
//        fragmentTransaction.commit()
//
//    }
}