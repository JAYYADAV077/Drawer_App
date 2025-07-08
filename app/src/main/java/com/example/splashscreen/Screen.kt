package com.example.splashscreen

sealed class Screen(val screen: String){
    data object Home: Screen("home")
    data object Settings: Screen("settings")
    data object Profile: Screen("profile")



}