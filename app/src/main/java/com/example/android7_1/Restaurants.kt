package com.example.android7_1

data class Restaurants(
    var name: String,
    var isOpen: Boolean,
    var rate: Double,
    var address: String,
    var distance: Double,
    var category: String,
    var pic: String?=null,
    var friends: List<String>

)