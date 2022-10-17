package binar.academy.chapter6_topik4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.academy.chapter6_topik4.databinding.ActivityDetailCarBinding
import binar.academy.chapter6_topik4.model.ResponseDataCarItem
import binar.academy.chapter6_topik4.presenter.DetailCarPresenter
import binar.academy.chapter6_topik4.presenter.DetailCarView
import com.bumptech.glide.Glide

class DetailCarActivity : AppCompatActivity(), DetailCarView {
    private lateinit var binding : ActivityDetailCarBinding
    private lateinit var presenter: DetailCarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getId = intent.getIntExtra("idCar", 0)
        presenter = DetailCarPresenter(this)
        presenter.getDetailCar(getId)
    }

    override fun onSuccess(msg: String, car: ResponseDataCarItem) {
        binding.apply {
            Glide.with(applicationContext)
                .load(car.image)
                .into(imgCarDetail)

            nameCarDetail.text = car.name
            categoryCarDetail.text = car.category
            priceCarDetail.text = car.price.toString()
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}