package binar.academy.chapter6_topik4.presenter

import binar.academy.chapter6_topik4.model.ResponseDataCarItem

interface CarsView {

    fun onSuccess(msg : String, car : List<ResponseDataCarItem>)
    fun onError(msg : String)
}