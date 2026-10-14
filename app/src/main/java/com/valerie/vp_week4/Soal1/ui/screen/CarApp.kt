package com.valerie.vp_week4.Soal1.ui.screen

import android.app.Activity
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valerie.vp_week4.Soal1.viewmodel.CarViewModel

@Composable
fun CarApp(
    modifier: Modifier = Modifier,
    viewModel: CarViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val listState = rememberLazyListState()
    val selectedCar = uiState.selectedCar

    NoSystemBarScrim()

    BackHandler(enabled = selectedCar != null) {
        viewModel.closeCarDetail()
    }

    AnimatedContent(
        targetState = selectedCar,
        transitionSpec = { fadeIn() togetherWith fadeOut() },
        modifier = modifier,
        label = "CarScreen"
    ) { car ->
        if (car == null) {
            CarListScreen(
                cars = uiState.cars,
                favoriteIds = uiState.favoriteIds,
                onToggleFavorite = viewModel::toggleFavorite,
                onCarClick = viewModel::openCarDetail,
                listState = listState
            )
        } else {
            CarDetailScreen(
                car = car,
                isFavorite = uiState.isFavorite(car.id),
                onToggleFavorite = { viewModel.toggleFavorite(car.id) },
                onBackClick = viewModel::closeCarDetail
            )
        }
    }
}

@Composable
private fun NoSystemBarScrim() {
    if (LocalInspectionMode.current) return
    val view = LocalView.current
    DisposableEffect(view) {
        val window = (view.context as? Activity)?.window
        if (window != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
            window.isStatusBarContrastEnforced = false
        }
        onDispose { }
    }
}

@Preview(name = "Soal 1 - Jualan Mobil", showSystemUi = true, device = "id:pixel_7")
@Composable
private fun CarAppPreview() {
    CarApp(viewModel = remember { CarViewModel() })
}