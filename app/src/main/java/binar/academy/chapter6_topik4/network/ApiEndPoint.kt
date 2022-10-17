package binar.academy.chapter6_topik4.network

import binar.academy.chapter6_topik4.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET("admin/car")
    fun getAllDataCar() : Call<List<ResponseDataCarItem>>

    @GET("admin/car/{id}")
    fun getDetailCar(@Path("id") id : Int) : Call<ResponseDataCarItem>
}