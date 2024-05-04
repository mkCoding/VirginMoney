package com.example.virginmoney.ui.person_list

import android.provider.Contacts.People
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.api.RetrofitInstance
import com.example.virginmoney.data.model.people.PeopleItemModel
import kotlinx.coroutines.launch

class PersonListViewModel:ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dog breed fragment"
    }

    val text: LiveData<String> = _text

    init {
        getAllPeople()
    }

    private fun getAllPeople() {
        //People contains 1 array list. The Array list contains PeopleItemModelObjects
        //PeopleItemModelObject contains attribute variables

        //the people list holds PeopleItemModel objects
        viewModelScope.launch {

            val result = RetrofitInstance.apiClient.getPeople() //this actually makes the api call to the endpoint
            //this is the value that will be populated in the textView when .text.observe(viewLifecycleOwner) method is called

            //Create array list to only hold all firstnames extracted from tha API
            var firstNameList:MutableList<String> = mutableListOf()

            //iterate through the list of PeopleItemModelElements
            for(peopleItemModelElement in result){
                //Add only the firstname of each PeopleItemModel element to the firstName List
                firstNameList.add(peopleItemModelElement.firstName?: "Name not found")


            }
            _text.postValue(firstNameList.toString())
            Log.d("Name Returned from API","$firstNameList")

        }




    }

}