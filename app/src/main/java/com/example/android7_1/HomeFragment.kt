package com.example.android7_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android7_1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var friends: ArrayList<String> = arrayListOf()
    private lateinit var friendsAdapter: FriendsAdapter
    private lateinit var restaurantsAdapter: RestaurantsAdapter
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setupFriendsRV()
        setupCategoriesRV()
        setFriendsData()
        setRestaurantsData()
    }

    private fun setRestaurantsData() {
        val restaurants = arrayListOf<Restaurants>(
            Restaurants(
                "Happy Bounes",
                true,
                4.5,
                "394 Broome St, New York, NY 10013, USA",
                1.2,
                "Italian",null,
                friends
            ),      Restaurants(
                "Happy Bounes",
                true,
                4.5,
                "394 Broome St, New York, NY 10013, USA",
                1.2,
                "Italian",
                "https://toohotel.com/wp-content/uploads/2022/09/TOO_restaurant_Panoramique_vue_Paris_nuit_v2-scaled.jpg",
                friends
            ),

        )
        restaurantsAdapter.setData(restaurants)
    }

    private fun setFriendsData() {
        friends = arrayListOf<String>(
            "https://cdn-icons-png.flaticon.com/512/3135/3135715.png",
            "https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-PNG-Pic.png",
            "https://www.pngall.com/wp-content/uploads/5/Profile-Male-PNG.png",
            "https://img.freepik.com/vektoren-premium/gluecklich-laechelnder-junger-mann-avatar-3d-portraet-eines-mannes-zeichentrickfigur-menschen-vektor-illustration_653240-187.jpg",
            "https://static.vecteezy.com/system/resources/thumbnails/019/900/322/small/happy-young-cute-illustration-face-profile-png.png",
        )
        friendsAdapter.setData(friends)
    }

    private fun setupCategoriesRV() {
        context?.let {
            val layoutManager = LinearLayoutManager(it, LinearLayoutManager.HORIZONTAL, false)
            binding.rvRestaurants.layoutManager = layoutManager
            restaurantsAdapter = RestaurantsAdapter()
            binding.rvRestaurants.adapter = restaurantsAdapter
        }
    }

    private fun setupFriendsRV() {
        context?.let {
            val layoutManager = LinearLayoutManager(it, LinearLayoutManager.HORIZONTAL, false)
            binding.rvFriends.layoutManager = layoutManager
            friendsAdapter = FriendsAdapter()
            binding.rvFriends.adapter = friendsAdapter
        }
    }

}