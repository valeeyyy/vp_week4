package com.valerie.vp_week4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.valerie.vp_week4.Soal1.ui.screen.CarApp
import com.valerie.vp_week4.ui.theme.Vp_week4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vp_week4Theme {
                CarApp()
            }
        }
    }
}
