package com.valerie.vp_week4.Soal1.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.composed
import com.valerie.vp_week4.Soal1.ui.theme.CarTextMileage
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valerie.vp_week4.R
import com.valerie.vp_week4.Soal1.model.Car
import com.valerie.vp_week4.Soal1.model.CarDataSource
import com.valerie.vp_week4.Soal1.model.FuelType
import com.valerie.vp_week4.Soal1.ui.theme.CarBorder
import com.valerie.vp_week4.Soal1.ui.theme.CarChipBackground
import com.valerie.vp_week4.Soal1.ui.theme.CarChipBorder
import com.valerie.vp_week4.Soal1.ui.theme.CarImageBackground
import com.valerie.vp_week4.Soal1.ui.theme.CarOrange
import com.valerie.vp_week4.Soal1.ui.theme.CarSurface
import com.valerie.vp_week4.Soal1.ui.theme.CarTextMuted
import com.valerie.vp_week4.Soal1.ui.theme.CarTextPrimary
import com.valerie.vp_week4.Soal1.ui.theme.CarTextSecondary
import com.valerie.vp_week4.Soal1.ui.theme.badgeColors

@Composable
fun CarCard(
    car: Car,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable(onClick),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = CarSurface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, CarBorder)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 124.dp, height = 104.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(CarImageBackground)
            ) {
                Image(
                    painter = painterResource(car.imageRes),
                    contentDescription = car.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
                FuelBadge(
                    fuelType = car.fuelType,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                )
            }
            Spacer(Modifier.width(15.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(104.dp)
                    .padding(top = 7.dp)
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    Text(
                        text = car.name,
                        color = CarTextPrimary,
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    FavoriteIcon(
                        isFavorite = isFavorite,
                        onClick = onFavoriteClick,
                        iconSize = 22.dp,
                        touchPadding = 0.dp,
                        inactiveTint = CarTextMuted
                    )
                }
                Spacer(Modifier.height(6.dp))
                TransmissionChip(text = car.transmission.displayName)
                Spacer(Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OrangeDot()
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text = car.year.toString(),
                        color = CarTextPrimary,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = formatMileage(car.mileageKm),
                        color = CarTextMileage,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        onClick = onClick
    )
}

@Composable
fun FuelBadge(fuelType: FuelType, modifier: Modifier = Modifier) {
    val colors = fuelType.badgeColors()
    Text(
        text = fuelType.displayName.uppercase(),
        color = colors.content,
        fontSize = 10.sp,
        lineHeight = 13.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.6.sp,
        modifier = modifier
            .border(1.dp, CarSurface.copy(alpha = 0.7f), RoundedCornerShape(7.dp))
            .clip(RoundedCornerShape(7.dp))
            .background(colors.background)
            .padding(horizontal = 7.dp, vertical = 8.dp)
    )
}

@Composable
fun TransmissionChip(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = CarTextSecondary,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(CarChipBackground)
            .border(1.dp, CarChipBorder, RoundedCornerShape(8.dp))
            .padding(horizontal = 9.dp, vertical = 8.dp)
    )
}

@Composable
fun FavoriteIcon(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    touchPadding: Dp = 6.dp,
    inactiveTint: Color = CarTextMuted
) {
    Box(
        modifier = modifier
            .size(iconSize + touchPadding)
            .noRippleClickable(onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(
                if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
            ),
            contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
            tint = if (isFavorite) CarOrange else inactiveTint,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Composable
fun OrangeDot(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(5.dp)
            .clip(CircleShape)
            .background(CarOrange)
    )
}

@Composable
fun SectionLabel(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text.uppercase(),
        color = CarTextMuted,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.2.sp,
        modifier = modifier
    )
}

@Composable
fun SpecCard(label: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CarSurface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, CarBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 14.dp, vertical = 15.dp)
        ) {
            Text(
                text = label.uppercase(),
                color = CarTextMuted,
                fontSize = 11.sp,
                lineHeight = 13.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 1.sp
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = value,
                color = CarTextPrimary,
                fontSize = 16.sp,
                lineHeight = 19.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

fun formatMileage(km: Int): String = "%,d km".format(java.util.Locale.US, km)

fun formatRupiah(amount: Long): String =
    "Rp " + "%,d".format(java.util.Locale.US, amount).replace(',', '.')

@Preview(showBackground = true, backgroundColor = 0xFFF6F4F1)
@Composable
private fun CarCardPreview() {
    Box(Modifier.padding(16.dp)) {
        CarCard(
            car = CarDataSource.cars.first(),
            isFavorite = true,
            onFavoriteClick = {},
            onClick = {}
        )
    }
}