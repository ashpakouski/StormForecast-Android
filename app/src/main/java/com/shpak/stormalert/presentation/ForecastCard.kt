package com.shpak.stormalert.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shpak.stormalert.domain.model.GeomagneticData
import com.shpak.stormalert.presentation.util.formatUtcDate
import com.shpak.stormalert.presentation.util.formatUtcTime

@Composable
fun ForecastCard(
    geomagneticData: GeomagneticData,
    isFirst: Boolean = false,
    isLast: Boolean = false
) {
    val defaultCornerRadius = 5.dp
    val maxCornerRadius = 12.dp

    val shape =
        if (isFirst && isLast) RoundedCornerShape(maxCornerRadius)
        else if (isFirst) RoundedCornerShape(
            maxCornerRadius,
            maxCornerRadius,
            defaultCornerRadius,
            defaultCornerRadius
        )
        else if (isLast) RoundedCornerShape(
            defaultCornerRadius,
            defaultCornerRadius,
            maxCornerRadius,
            maxCornerRadius
        )
        else RoundedCornerShape(defaultCornerRadius)

    Card(
        shape = shape,
        colors = CardDefaults.cardColors(),
        modifier = Modifier
            .padding(vertical = 2.dp)
            .fillMaxWidth(),

        ) {
        Box(contentAlignment = Alignment.CenterStart) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = geomagneticData.date.formatUtcTime(),
                    modifier = Modifier.padding(12.dp),
                    fontWeight = FontWeight(500)
                )
                Text(
                    text = geomagneticData.kpValue.toString(),
                    modifier = Modifier.padding(12.dp),
                    fontWeight = FontWeight(500)
                )
            }
        }
    }
}