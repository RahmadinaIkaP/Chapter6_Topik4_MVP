package binar.academy.chapter6_topik4.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.chapter6_topik4.databinding.ActivityMainBinding
import binar.academy.chapter6_topik4.model.ResponseDataCarItem
import binar.academy.chapter6_topik4.presenter.CarsPresenter
import binar.academy.chapter6_topik4.presenter.CarsView

class MainActivity : AppCompatActivity(), CarsView, CarAdapter.CarAdapterInterface {
    private lateinit var binding : ActivityMainBinding
    private lateinit var presenterCar : CarsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenterCar = CarsPresenter(this)
        presenterCar.getDataCar()
    }

    override fun onSuccess(msg: String, car: List<ResponseDataCarItem>) {
        binding.apply {
            rvCar.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCar.adapter = CarAdapter(car, this@MainActivity)
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(car: ResponseDataCarItem) {
        val intent = Intent(this, DetailCarActivity::class.java)
        intent.putExtra("idCar", car.id)
        startActivity(intent)
    }


}