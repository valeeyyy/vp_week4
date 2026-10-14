package com.valerie.vp_week4.Soal1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valerie.vp_week4.R
import com.valerie.vp_week4.Soal1.model.Car
import com.valerie.vp_week4.Soal1.model.CarDataSource
import com.valerie.vp_week4.Soal1.ui.component.FavoriteIcon
import com.valerie.vp_week4.Soal1.ui.component.FuelBadge
import com.valerie.vp_week4.Soal1.ui.component.OrangeDot
import com.valerie.vp_week4.Soal1.ui.component.SectionLabel
import com.valerie.vp_week4.Soal1.ui.component.SpecCard
import com.valerie.vp_week4.Soal1.ui.component.formatMileage
import com.valerie.vp_week4.Soal1.ui.component.formatRupiah
import com.valerie.vp_week4.Soal1.ui.component.noRippleClickable
import com.valerie.vp_week4.Soal1.ui.theme.CarBackground
import com.valerie.vp_week4.Soal1.ui.theme.CarImageBackground
import com.valerie.vp_week4.Soal1.ui.theme.CarOrange
import com.valerie.vp_week4.Soal1.ui.theme.CarOrangeBorder
import com.valerie.vp_week4.Soal1.ui.theme.CarOrangeLight
import com.valerie.vp_week4.Soal1.ui.theme.CarSurface
import com.valerie.vp_week4.Soal1.ui.theme.CarTextPrimary
import com.valerie.vp_week4.Soal1.ui.theme.CarTextSecondary

private val HeroHeight = 305.dp
private val SheetOverlap = 26.dp

@Composable
fun CarDetailScreen(
    car: Car,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CarBackground)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(car.imageRes),
                contentDescription = car.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(HeroHeight)
                    .background(CarImageBackground)
            )
            BackButton(
                onClick = onBackClick,
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(start = 16.dp, top = 12.dp)
            )
            DetailContent(
                car = car,
                isFavorite = isFavorite,
                onToggleFavorite = onToggleFavorite,
                modifier = Modifier.padding(top = HeroHeight - SheetOverlap)
            )
            FuelBadge(
                fuelType = car.fuelType,
                modifier = Modifier.padding(start = 20.dp, top = HeroHeight - SheetOverlap - 15.dp)
            )
        }
        DetailBottomBar(isFavorite = isFavorite, onToggleFavorite = onToggleFavorite)
    }
}

@Composable
private fun DetailContent(
    car: Car,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            .background(CarBackground)
            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 24.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = car.name,
                color = CarTextPrimary,
                fontSize = 27.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.3).sp,
                modifier = Modifier.weight(1f)
            )
            FavoriteIcon(
                isFavorite = isFavorite,
                onClick = onToggleFavorite,
                iconSize = 26.dp,
                inactiveTint = CarOrange
            )
        }
        Spacer(Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            OrangeDot()
            Spacer(Modifier.width(6.dp))
            Text(text = car.location, color = CarTextSecondary, fontSize = 14.sp)
        }
        Spacer(Modifier.height(14.dp))
        Text(
            text = formatRupiah(car.price),
            color = CarOrange,
            fontSize = 18.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(CarOrangeLight)
                .border(1.dp, CarOrangeBorder, RoundedCornerShape(10.dp))
                .padding(horizontal = 14.dp, vertical = 9.dp)
        )

        Spacer(Modifier.height(26.dp))
        SectionLabel("Specifications")
        Spacer(Modifier.height(12.dp))
        SpecRow(
            firstLabel = "Year", firstValue = car.year.toString(),
            secondLabel = "Mileage", secondValue = formatMileage(car.mileageKm)
        )
        Spacer(Modifier.height(12.dp))
        SpecRow(
            firstLabel = "Transmission", firstValue = car.transmission.displayName,
            secondLabel = "Fuel Type", secondValue = car.fuelType.displayName
        )

        Spacer(Modifier.height(26.dp))
        SectionLabel("About this car")
        Spacer(Modifier.height(12.dp))
        Text(
            text = car.description,
            color = CarTextSecondary,
            fontSize = 14.sp,
            lineHeight = 23.sp
        )
    }
}

@Composable
private fun SpecRow(
    firstLabel: String,
    firstValue: String,
    secondLabel: String,
    secondValue: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SpecCard(firstLabel, firstValue, Modifier.weight(1f).fillMaxHeight())
        SpecCard(secondLabel, secondValue, Modifier.weight(1f).fillMaxHeight())
    }
}

@Composable
private fun BackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(40.dp)
            .shadow(4.dp, CircleShape)
            .clip(CircleShape)
            .background(CarSurface.copy(alpha = 0.92f))
            .noRippleClickable(onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = "Back",
            tint = CarTextPrimary,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
private fun DetailBottomBar(isFavorite: Boolean, onToggleFavorite: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(CarBackground)
            .navigationBarsPadding()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(CarOrangeLight)
                .border(1.dp, CarOrangeBorder, RoundedCornerShape(14.dp))
                .noRippleClickable(onToggleFavorite),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(
                    if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
                ),
                contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                tint = CarOrange,
                modifier = Modifier.size(22.dp)
            )
        }
        Spacer(Modifier.width(12.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(CarOrange)
                .noRippleClickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Contact Seller",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 860)
@Composable
private fun CarDetailScreenPreview() {
    CarDetailScreen(
        car = CarDataSource.cars.first { it.name == "Toyota Yaris" },
        isFavorite = true,
        onToggleFavorite = {},
        onBackClick = {}
    )
}