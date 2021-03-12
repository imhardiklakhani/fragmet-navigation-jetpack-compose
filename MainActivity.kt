package com.example.myapplication

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") {
                    Splash(navController)
                }
                composable("home") {
                    Home(navController)
                }
            }
        }
    }
}

@Composable
fun Splash(navController: NavHostController) {
    Surface(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = colorResource(id = R.color.teal_200),
    ) {


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = CircleShape,
                backgroundColor = Color.White,
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.android),
                        modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),
                        contentDescription = ""
                    )
                }

            }
        }


        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    navController.navigate("home")
                },
                Modifier
                    .fillMaxWidth()
                    .requiredHeight(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_700))
            ) {
                Text(text = "Start", color = Color.White)
            }
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    Surface(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = colorResource(id = R.color.teal_200),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = CircleShape,
                backgroundColor = Color.White,
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_baseline_home_24),
                        modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),

                        contentDescription = ""
                    )
                }

            }
        }


        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                },
                Modifier
                    .fillMaxWidth()
                    .requiredHeight(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_700))
            ) {
                Text(text = "Go Back", color = Color.White)
            }
        }
    }
}
