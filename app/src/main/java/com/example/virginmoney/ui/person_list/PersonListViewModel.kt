package com.example.virginmoney.ui.person_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.api.RetrofitInstance
import com.example.virginmoney.data.model.people.PeopleItemModel
import kotlinx.coroutines.launch

class PersonListViewModel:ViewModel() {

    private val _personList = MutableLiveData<ArrayList<PeopleItemModel>>()
    val personList: LiveData<ArrayList<PeopleItemModel>> = _personList

    init {
        getAllPeople()
    }

    private fun getAllPeople() {
        //People contains 1 array list. The Array list contains PeopleItemModelObjects
        //PeopleItemModelObject contains attribute variables

        //the people list holds PeopleItemModel objects
        viewModelScope.launch {

            val result = RetrofitInstance.apiClient.getPeople() //this actually makes the api call to the endpoint

            if(result!=null){
                _personList.postValue(result)

            }

            Log.d("Name Returned from API",result.toString())

        }




    }

}