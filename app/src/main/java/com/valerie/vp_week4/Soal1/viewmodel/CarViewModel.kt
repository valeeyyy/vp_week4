package com.valerie.vp_week4.Soal1.viewmodel

import androidx.lifecycle.ViewModel
import com.valerie.vp_week4.Soal1.model.Car
import com.valerie.vp_week4.Soal1.model.CarDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CarUiState(
    val cars: List<Car> = emptyList(),
    val favoriteIds: Set<Int> = emptySet(),
    val selectedCarId: Int? = null
) {
    val savedCount: Int get() = favoriteIds.size
    val selectedCar: Car? get() = cars.firstOrNull { it.id == selectedCarId }

    fun isFavorite(carId: Int) = carId in favoriteIds
}

class CarViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        CarUiState(
            cars = CarDataSource.cars,
            favoriteIds = CarDataSource.initialFavoriteIds
        )
    )
    val uiState: StateFlow<CarUiState> = _uiState.asStateFlow()

    fun toggleFavorite(carId: Int) {
        _uiState.update { state ->
            val favorites = if (carId in state.favoriteIds) {
                state.favoriteIds - carId
            } else {
                state.favoriteIds + carId
            }
            state.copy(favoriteIds = favorites)
        }
    }

    fun openCarDetail(carId: Int) {
        _uiState.update { it.copy(selectedCarId = carId) }
    }

    fun closeCarDetail() {
        _uiState.update { it.copy(selectedCarId = null) }
    }
}