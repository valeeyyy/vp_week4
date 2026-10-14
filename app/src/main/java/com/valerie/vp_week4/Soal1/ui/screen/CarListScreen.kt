package com.valerie.vp_week4.Soal1.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valerie.vp_week4.R
import com.valerie.vp_week4.Soal1.model.Car
import com.valerie.vp_week4.Soal1.model.CarDataSource
import com.valerie.vp_week4.Soal1.ui.component.CarCard
import com.valerie.vp_week4.Soal1.ui.theme.CarBackground
import com.valerie.vp_week4.Soal1.ui.theme.CarBorder
import com.valerie.vp_week4.Soal1.ui.theme.CarOrange
import com.valerie.vp_week4.Soal1.ui.theme.CarOrangeBorder
import com.valerie.vp_week4.Soal1.ui.theme.CarOrangeLight
import com.valerie.vp_week4.Soal1.ui.theme.CarTextPrimary
import com.valerie.vp_week4.Soal1.ui.theme.CarTextSecondary

@Composable
fun CarListScreen(
    cars: List<Car>,
    favoriteIds: Set<Int>,
    onToggleFavorite: (Int) -> Unit,
    onCarClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CarBackground)
    ) {
        OnSaleHeader(savedCount = favoriteIds.size)
        HorizontalDivider(color = CarBorder, thickness = 1.dp)
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 16.dp + WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(cars, key = { it.id }) { car ->
                CarCard(
                    car = car,
                    isFavorite = car.id in favoriteIds,
                    onFavoriteClick = { onToggleFavorite(car.id) },
                    onClick = { onCarClick(car.id) }
                )
            }
        }
    }
}

@Composable
private fun OnSaleHeader(savedCount: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 18.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 40.dp, height = 4.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(CarOrange)
        )
        Spacer(Modifier.height(14.dp))
        Row(verticalAlignment = Alignment.Bottom) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "On Sale",
                    color = CarTextPrimary,
                    fontSize = 33.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = (-0.5).sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Find your perfect ride",
                    color = CarTextSecondary,
                    fontSize = 15.sp
                )
            }
            SavedPill(count = savedCount)
        }
    }
}

@Composable
private fun SavedPill(count: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(CarOrangeLight)
            .border(1.dp, CarOrangeBorder, RoundedCornerShape(50))
            .padding(horizontal = 18.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_favorite),
            contentDescription = null,
            tint = CarOrange,
            modifier = Modifier.size(15.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "$count saved",
            color = CarOrange,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
private fun CarListScreenPreview() {
    CarListScreen(
        cars = CarDataSource.cars,
        favoriteIds = CarDataSource.initialFavoriteIds,
        onToggleFavorite = {},
        onCarClick = {}
    )
}
