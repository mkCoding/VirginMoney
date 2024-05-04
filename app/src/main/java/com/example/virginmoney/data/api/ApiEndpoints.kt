package com.example.virginmoney.data.api

import com.example.virginmoney.data.model.people.People
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.rooms.Rooms
import retrofit2.http.GET

interface ApiEndpoints{

    @GET(ApiDetail.PEOPLE_ENDPOINT)
    suspend fun getPeople(): ArrayList<PeopleItemModel>


    @GET(ApiDetail.ROOMS_ENDPOINT)
    suspend fun getRooms(): ArrayList<Rooms>
}