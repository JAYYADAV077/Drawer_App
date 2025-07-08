package com.example.splashscreen

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.ui.theme.Greenj
import com.example.splashscreen.ui.theme.SplashScreenTheme
import kotlinx.coroutines.launch
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashScreenTheme {
Surface(color = MaterialTheme.colorScheme.background) {
    Learinnav()
}
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Learinnav() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Greenj)
                        .fillMaxSize()
                        .height(1500.dp)
                ) { Text("") }
                Divider()

                NavigationDrawerItem(
                    label = { Text("Home", color = Greenj) },
                    selected = false,
                    icon = { Icon(Icons.Default.Home, "", tint = Greenj) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navController.navigate(Screen.Home.screen) {
                            popUpTo(0)
                        }

                    }
                )
                NavigationDrawerItem(
                    label = { Text("Home", color = Greenj) },
                    selected = false,
                    icon = { Icon(Icons.Default.Home, "", tint = Greenj) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navController.navigate(Screen.Home.screen) {
                            popUpTo(0)
                        }

                    }
                )
                NavigationDrawerItem(
                    label = { Text("Settings", color = Greenj) },
                    selected = false,
                    icon = { Icon(Icons.Default.Settings, "", tint = Greenj) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navController.navigate(Screen.Settings.screen) {
                            popUpTo(0)
                        }

                    }
                )
                NavigationDrawerItem(
                    label = { Text("Profile", color = Greenj) },
                    selected = false,
                    icon = { Icon(Icons.Default.Person, "", tint = Greenj) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navController.navigate(Screen.Profile.screen) {
                            popUpTo(0)
                        }

                    }
                )
            }
        }
    ) {
        Scaffold (topBar = { val coroutineScope = rememberCoroutineScope()
            TopAppBar(
                title = { Text("WhatsApp") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Greenj, titleContentColor = Color.White, navigationIconContentColor = Color.White)
                , navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch { drawerState.open() }
                    }) {
                        Icon(Icons.Default.Menu,"")

                    }
                },
            )}){
            NavHost(navController = navController, startDestination = Screen.Home.screen){composable(Screen.Home.screen){ Home() }
                composable(Screen.Settings.screen){ Settings() }
                composable(Screen.Profile.screen){ Profile() }}
        }
    }
}


