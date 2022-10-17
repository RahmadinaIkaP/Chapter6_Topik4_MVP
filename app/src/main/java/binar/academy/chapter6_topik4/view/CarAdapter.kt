package binar.academy.chapter6_topik4.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.chapter6_topik4.databinding.ItemCarBinding
import binar.academy.chapter6_topik4.model.ResponseDataCarItem
import com.bumptech.glide.Glide

class CarAdapter(var listcar : List<ResponseDataCarItem>, val onClick : CarAdapterInterface) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    inner class ViewHolder(var binding : ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item : ResponseDataCarItem){
                binding.apply {
                    nameCar.text = item.name
                    categoryCar.text = item.category
                    priceCar.text = item.price.toString()

                    Glide.with(itemView)
                        .load(item.image)
                        .into(imgCar)

                    itemView.setOnClickListener {
                        onClick.onItemClick(item)
                    }
                }
            }
    }

    interface CarAdapterInterface {
        fun onItemClick(car : ResponseDataCarItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listcar[position])
    }

    override fun getItemCount(): Int = listcar.size
}