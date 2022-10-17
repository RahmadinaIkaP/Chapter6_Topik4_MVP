package binar.academy.chapter6_topik4.presenter

import binar.academy.chapter6_topik4.model.ResponseDataCarItem

interface DetailCarView {

    fun onSuccess(msg : String, car : ResponseDataCarItem)
    fun onError(msg : String)
}