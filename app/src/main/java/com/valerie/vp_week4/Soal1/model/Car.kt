package com.valerie.vp_week4.Soal1.model

import androidx.annotation.DrawableRes

enum class FuelType(val displayName: String) {
    PETROL("Petrol"),
    PHEV("PHEV"),
    HYBRID("Hybrid"),
    ELECTRIC("Electric"),
    DIESEL("Diesel")
}

enum class Transmission(val displayName: String) {
    AUTO("Auto"),
    MANUAL("Manual")
}

data class Car(
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int,
    val fuelType: FuelType,
    val transmission: Transmission,
    val year: Int,
    val mileageKm: Int,
    val location: String,
    val price: Long,
    val description: String
)