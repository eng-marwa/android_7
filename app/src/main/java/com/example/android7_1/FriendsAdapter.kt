package com.example.android7_1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.android7_1.databinding.FriendsRowBinding

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendVH>() {
    private val TAG = "FriendsAdapter"
    private var context: Context? = null
    val friendsList = arrayListOf<String>()

    inner class FriendVH(private val binding: FriendsRowBinding) : ViewHolder(binding.root) {
        fun bind(position: Int) {
            context?.let {
                Glide.with(it).asBitmap().load(friendsList[position]).into(binding.ivFriend)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendVH {
        context = parent.context
        return FriendVH(
            FriendsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = friendsList.size

    override fun onBindViewHolder(holder: FriendVH, position: Int) {
        holder.bind(position)
    }

    fun setData(friends: ArrayList<String>) {
        friendsList.clear()
        friendsList.addAll(friends)
        Log.d(TAG, "setData: $friends")
        notifyDataSetChanged()
    }
}