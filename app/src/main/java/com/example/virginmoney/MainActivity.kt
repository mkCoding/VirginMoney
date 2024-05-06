package com.example.virginmoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.virginmoney.databinding.ActivityMainBinding
import com.example.virginmoney.ui.person_list.PersonListFragment
import com.example.virginmoney.ui.room_list.RoomListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //When the app initially loads always show the PersonListFragment 1st
        replaceFragment(PersonListFragment())


        //This will handle the Bottom navigation. Switches between People and Rooms Fragment
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.people -> replaceFragment(PersonListFragment())
                R.id.allRooms -> replaceFragment(RoomListFragment())
                else ->{}
            }
             true
        }


    }
  private fun replaceFragment (fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

    }
}