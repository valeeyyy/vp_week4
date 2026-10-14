package com.valerie.vp_week4.Soal1.model

import com.valerie.vp_week4.R

object CarDataSource {

    val cars = listOf(
        Car(
            id = 1,
            name = "Tiggo 9 CSH",
            imageRes = R.drawable.tiggo,
            fuelType = FuelType.PHEV,
            transmission = Transmission.AUTO,
            year = 2024,
            mileageKm = 5_000,
            location = "Jakarta Selatan",
            price = 699_000_000,
            description = "The Chery Tiggo 9 CSH is a flagship 7-seater plug-in hybrid SUV. " +
                    "It pairs a 1.5L turbo engine with an electric motor for over 1,000 km of combined range, " +
                    "wrapped in a premium cabin with ventilated seats and a panoramic sunroof."
        ),
        Car(
            id = 2,
            name = "Honda CRV",
            imageRes = R.drawable.crv,
            fuelType = FuelType.PETROL,
            transmission = Transmission.AUTO,
            year = 2013,
            mileageKm = 15_200,
            location = "Surabaya",
            price = 185_000_000,
            description = "A well-kept Honda CR-V 2.4 Prestige with low mileage for its age. " +
                    "Spacious, reliable and comfortable, it is a proven family SUV with full service records " +
                    "and a clean interior."
        ),
        Car(
            id = 3,
            name = "Toyota Yaris Cross",
            imageRes = R.drawable.yariscross,
            fuelType = FuelType.HYBRID,
            transmission = Transmission.AUTO,
            year = 2024,
            mileageKm = 30_500,
            location = "Bandung",
            price = 389_000_000,
            description = "The Toyota Yaris Cross Hybrid combines compact SUV practicality with " +
                    "excellent fuel economy. It comes with Toyota Safety Sense, a 360° camera and " +
                    "a smooth e-CVT transmission for effortless city driving."
        ),
        Car(
            id = 4,
            name = "Daihatsu Xenia",
            imageRes = R.drawable.xenia,
            fuelType = FuelType.PETROL,
            transmission = Transmission.MANUAL,
            year = 2022,
            mileageKm = 28_000,
            location = "Malang",
            price = 215_000_000,
            description = "The all-new Daihatsu Xenia R 1.5 offers seating for seven on the modern " +
                    "DNGA platform. Economical, easy to maintain and roomy, it is an ideal everyday MPV " +
                    "for growing families."
        ),
        Car(
            id = 5,
            name = "Toyota Yaris",
            imageRes = R.drawable.yaris,
            fuelType = FuelType.PETROL,
            transmission = Transmission.AUTO,
            year = 2021,
            mileageKm = 52_400,
            location = "Semarang",
            price = 245_000_000,
            description = "The Toyota Yaris G AT is a sporty compact hatchback that punches above its " +
                    "weight class. Equipped with a 1.5L dual VVT-i engine, 7 airbags, pre-collision system, " +
                    "and a floating head unit, it offers premium features at a very accessible price point."
        ),
        Car(
            id = 6,
            name = "Honda HRV",
            imageRes = R.drawable.hrv,
            fuelType = FuelType.PETROL,
            transmission = Transmission.AUTO,
            year = 2022,
            mileageKm = 18_900,
            location = "Jakarta Barat",
            price = 365_000_000,
            description = "The all-new Honda HR-V SE CVT brings a sleek coupe-like profile to the compact " +
                    "SUV segment. It features Honda SENSING driver assistance, a spacious Magic Seat cabin and " +
                    "a refined 1.5L i-VTEC engine tuned for comfortable daily driving."
        ),
        Car(
            id = 7,
            name = "Daihatsu Ayla",
            imageRes = R.drawable.ayla,
            fuelType = FuelType.PETROL,
            transmission = Transmission.MANUAL,
            year = 2020,
            mileageKm = 45_000,
            location = "Solo",
            price = 105_000_000,
            description = "The Daihatsu Ayla is an affordable and fuel-efficient city car. Light steering, " +
                    "a compact footprint and low maintenance costs make it a practical choice for first-time " +
                    "owners and daily commuting through busy streets."
        ),
        Car(
            id = 8,
            name = "Jaecoo J5",
            imageRes = R.drawable.j5,
            fuelType = FuelType.ELECTRIC,
            transmission = Transmission.AUTO,
            year = 2025,
            mileageKm = 1_200,
            location = "Tangerang",
            price = 299_000_000,
            description = "The Jaecoo J5 EV is a rugged-looking electric compact SUV with a long-range " +
                    "battery, a large floating touchscreen and a full suite of ADAS features. Nearly new, it " +
                    "is still covered by the manufacturer battery warranty."
        ),
        Car(
            id = 9,
            name = "MG 4 EV",
            imageRes = R.drawable.mg4,
            fuelType = FuelType.ELECTRIC,
            transmission = Transmission.AUTO,
            year = 2023,
            mileageKm = 9_800,
            location = "Bekasi",
            price = 455_000_000,
            description = "The MG 4 EV is a rear-wheel-drive electric hatchback built on a dedicated EV " +
                    "platform. It delivers quick acceleration, balanced handling and up to 425 km of range, " +
                    "with fast-charging support for longer journeys."
        ),
        Car(
            id = 10,
            name = "Toyota Innova Reborn",
            imageRes = R.drawable.reborn,
            fuelType = FuelType.DIESEL,
            transmission = Transmission.AUTO,
            year = 2021,
            mileageKm = 68_000,
            location = "Surabaya",
            price = 395_000_000,
            description = "The Toyota Innova Reborn 2.4 V Diesel is a dependable seven-seater MPV known for " +
                    "its torquey 2GD-FTV engine, captain seats and comfortable ride. Perfect for family trips " +
                    "and long-distance travel with low running costs."
        )
    )

    val initialFavoriteIds = setOf(1, 3, 5, 8, 10)
}