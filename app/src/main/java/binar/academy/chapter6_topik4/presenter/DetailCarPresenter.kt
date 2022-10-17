package binar.academy.chapter6_topik4.presenter

import binar.academy.chapter6_topik4.model.ResponseDataCarItem
import binar.academy.chapter6_topik4.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCarPresenter(val viewDetailCar : DetailCarView) {

    fun getDetailCar(id : Int){
        ApiService.instance.getDetailCar(id)
            .enqueue(object : Callback<ResponseDataCarItem> {
                override fun onResponse(
                    call: Call<ResponseDataCarItem>,
                    response: Response<ResponseDataCarItem>
                ) {
                    if (response.isSuccessful){
                        viewDetailCar.onSuccess(response.message(), response.body()!!)
                    }else{
                        viewDetailCar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<ResponseDataCarItem>, t: Throwable) {
                    viewDetailCar.onError(t.message!!)
                }

            })
    }
}