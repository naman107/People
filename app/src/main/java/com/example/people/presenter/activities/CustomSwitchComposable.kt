package com.revos.android.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import timber.log.Timber

@Composable
fun CustomThumb(){
    Card(shape = CircleShape, modifier = Modifier
        .size(18.dp)
        .padding(2.dp), elevation = 0.dp) {
        Box(modifier = Modifier.background(Color.White))
    }
}

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Card(modifier = Modifier
        .width(50.dp)
        .clickable {
            onCheckedChange(checked)
            Timber.d("Update function called!")
        },
        shape = RoundedCornerShape(18.dp), elevation = 0.dp) {
        Box(modifier = Modifier.background(
            if (checked) Color.Yellow else Color.Blue
        ), contentAlignment = if (checked) Alignment.TopEnd else Alignment.TopStart){
            CustomThumb()
        }
    }
}
