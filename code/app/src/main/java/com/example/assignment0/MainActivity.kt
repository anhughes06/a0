package com.example.assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment0.ui.theme.Assignment0Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainUI()
                }
            }
        }
    }
}

@Composable
fun MainUI(modifier: Modifier = Modifier) {

    var bgR by remember { mutableFloatStateOf(1f) }
    var bgG by remember { mutableFloatStateOf(1f) }
    var bgB by remember { mutableFloatStateOf(1f) }

    var responseText by remember { mutableStateOf("Idk") }

    LaunchedEffect(Unit) {
        while (true) {

            withFrameMillis {
                bgR = (bgR + 0.02f).coerceAtMost(1f)
                bgG = (bgG + 0.02f).coerceAtMost(1f)
                bgB = (bgB + 0.02f).coerceAtMost(1f)
            }
        }
    }

    Column(
        modifier = Modifier.background(Color(bgR, bgG, bgB))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center, // Centers children vertically
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {
                    if (flipCoin(0.5f)) {
                        bgR = 0f
                        bgB = 0f
                        responseText = "You should go!"
                    } else {
                        bgG = 0f
                        bgB = 0f
                        responseText = "Stay home."
                    }
                }
            ) {
                Text(text = "Absolutely", modifier = Modifier)
            }

            Button(
                onClick = {
                    if (flipCoin(0.25f)) {
                        bgR = 0f
                        bgB = 0f
                        responseText = "You should go!"
                    } else {
                        bgG = 0f
                        bgB = 0f
                        responseText = "Stay home."
                    }
                }
            ) {
                Text(text = "I guess", modifier = Modifier)
            }

            Button(
                onClick = {
                    if (flipCoin(0.1f)) {
                        bgR = 0f
                        bgB = 0f
                        responseText = "You should go!"
                    } else {
                        bgG = 0f
                        bgB = 0f
                        responseText = "Stay home."
                    }
                }
            ) {
                Text(text = "Idk man", modifier = Modifier)
            }

        }

        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = responseText,
            color = Color.White
        )

    }

}

fun flipCoin(prob: Float): Boolean {

    return Random.nextFloat() <= prob

}