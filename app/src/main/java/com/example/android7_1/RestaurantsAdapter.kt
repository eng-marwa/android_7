package com.example.android7_1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android7_1.databinding.RestaurantsRowBinding

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsAdapter.RestaurantsVH>() {
    private var context: Context? = null
    val restaurantsList = arrayListOf<Restaurants>()

    inner class RestaurantsVH(private val binding: RestaurantsRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            context?.let {
                if(restaurantsList[position].pic!= null) Glide.with(it).asBitmap().load(restaurantsList[position].pic).into(binding.ivFood) else binding.ivFood.setImageResource(R.mipmap.food)
                if (restaurantsList[position].isOpen) binding.lbOpenClose.setTextColor(
                    it.resources.getColor(
                        R.color.green
                    )
                ) else binding.lbOpenClose.setTextColor(
                    it.resources.getColor(R.color.red)
                )
                binding.lbRestaurantCategory.background = when {
                    restaurantsList[position].category == "Italian" -> it.getDrawable(R.drawable.text_gradient_1)
                    restaurantsList[position].category == "Chinese" -> it.getDrawable(R.drawable.text_gradient_2)
                    else -> it.getDrawable(R.drawable.text_gradient_3)

                }
                Glide.with(it).asBitmap().load(restaurantsList[position].friends[0])
                    .into(binding.ivFriend1)
                Glide.with(it).asBitmap().load(restaurantsList[position].friends[1])
                    .into(binding.ivFriend2)
                Glide.with(it).asBitmap().load(restaurantsList[position].friends[2])
                    .into(binding.ivFriend3)
                Glide.with(it).asBitmap().load(restaurantsList[position].friends[3])
                    .into(binding.ivFriend4)

            }
            binding.lbOpenClose.text = if (restaurantsList[position].isOpen) "open" else "close"
            binding.lbRate.text = "${restaurantsList[position].rate}"
            binding.lbRestaurantCategory.text = restaurantsList[position].category
            binding.lbDistance.text = "${restaurantsList[position].distance} Km"
            binding.lbAddress.text = restaurantsList[position].address


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsVH {
        context = parent.context
        return RestaurantsVH(
            RestaurantsRowBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = restaurantsList.size

    override fun onBindViewHolder(holder: RestaurantsVH, position: Int) {
        holder.bind(position)
    }

    fun setData(restaurants: ArrayList<Restaurants>) {
        restaurantsList.clear()
        restaurantsList.addAll(restaurants)
        notifyDataSetChanged()
    }
}