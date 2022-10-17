package binar.academy.chapter6_topik4.presenter

import binar.academy.chapter6_topik4.model.ResponseDataCarItem
import binar.academy.chapter6_topik4.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarsPresenter(val viewCar : CarsView) {

    fun getDataCar(){
        ApiService.instance.getAllDataCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        viewCar.onSuccess(response.message(), response.body()!!)
                    }else{
                        viewCar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    viewCar.onError(t.message!!)
                }

            })
    }
}