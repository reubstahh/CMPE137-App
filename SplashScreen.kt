package com.example.test3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC2FF87))
            .padding(start = 56.dp, top = 309.dp, end = 56.dp, bottom = 308.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.image1), // replace with your actual image name
            contentDescription = "Splash Logo",
            modifier = Modifier
                .width(308.dp)
                .height(308.dp),
            contentScale = ContentScale.Crop
        )
    }
}
