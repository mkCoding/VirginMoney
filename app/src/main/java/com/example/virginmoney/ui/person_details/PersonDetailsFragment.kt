package com.example.virginmoney.ui.person_details

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPersonDetailsBinding
import com.example.virginmoney.databinding.FragmentPersonListBinding
import com.example.virginmoney.ui.person_list.PersonListFragment

/**
 * A simple [Fragment] subclass.
 * Use the [PersonDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPersonDetailsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        val id = arguments?.getString("id")
        val firstname = arguments?.getString("firstname")
        val lastname = arguments?.getString("lastname")
        val email = arguments?.getString("email")
        val jobtitle = arguments?.getString("jobtitle")
        val favouriteColor = arguments?.getString("favouriteColor")
        val avatar = arguments?.getString("avatar")

        binding.apply {
            tvId.text = "Id: $id"
            tvFirstname.text = "Firstname: $firstname"
            tvLastname.text = "Lastname: $lastname"
            tvEmail.text = "Email: $email"
            tvJobTitle.text = "Job Title: $jobtitle"
            tvFavouriteColor.text = "Favorite Color: $favouriteColor"
            Glide.with(requireContext()).load(avatar).into(tvAvatar)

            ivBackArrow.setOnClickListener {
                val intent = Intent(requireContext(),PersonListFragment::class.java)
//                requireActivity().supportFragmentManager.popBackStack()
            }
        }


        return binding.root
    }

}