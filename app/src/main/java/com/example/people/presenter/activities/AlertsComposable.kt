package com.revos.android.ui.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.people.R
import timber.log.Timber

@Composable
fun SettingsSwitchView(
    labelText: String,
    checked: Boolean,
    isSpacerRequired: Boolean ?= true,
    fontSize: TextUnit,
    onCheckedChange: (Boolean) -> Unit,
) {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = labelText, fontSize = fontSize)
            CustomSwitch(checked = checked, onCheckedChange = onCheckedChange)
        }
        if(isSpacerRequired == true){
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(horizontal = 16.dp)
                .background(Color.LightGray))
        }
    }
}

@Composable
fun SettingsThresholdViews(
    labelText: String,
    labelDescription: String,
    checked: Boolean,
    isSpacerRequired: Boolean ?= true,
    thresholdValue: TextFieldValue,
    unit: String,
    onCheckedChange: (Boolean) -> Unit,
){
    Column(modifier = Modifier.fillMaxWidth()) {
        SettingsSwitchView(labelText = labelText, checked = checked, onCheckedChange = onCheckedChange, isSpacerRequired = isSpacerRequired, fontSize = 12.sp)
        Text(modifier = Modifier
            .padding(0.dp)
            .padding(horizontal = 16.dp), text = labelDescription, fontSize = 14.sp)
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .height(24.dp)
                .width(48.dp)
                .border(width = 1.dp, color = Color.Red), contentAlignment = Alignment.Center){
                BasicTextField(value = thresholdValue, onValueChange = {},
                    textStyle = TextStyle(color = Color.Red, fontSize = 12.sp, textAlign = TextAlign.Center),
                )
            }
            Text(modifier = Modifier
                .padding(0.dp)
                .padding(start = 8.dp, top = 4.dp), text = unit)

        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(0.dp)
            .padding(horizontal = 16.dp)
            .background(Color.Red))
    }
}


@Composable
fun SettingsOptionsView(
    labelText: String,
    labelDescription: String,
    checked: Boolean,
    isSpacerRequired: Boolean ?= true,
    thresholdValueForDays: Int,
    thresholdValueForHours: Int,
    thresholdValueForMinutes: Int,
    onCheckedChange: (Boolean) -> Unit,
){
    Column(modifier = Modifier.fillMaxWidth()) {
        SettingsSwitchView(
            labelText = labelText,
            checked = checked,
            onCheckedChange = onCheckedChange,
            isSpacerRequired = isSpacerRequired,
            fontSize = 12.sp
        )
        Text(
            modifier = Modifier
                .padding(0.dp)
                .padding(horizontal = 16.dp), text = labelDescription, fontSize = 14.sp
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            SettingsCounterView(
                timeLabel = "days",
                vectorUp = painterResource(R.drawable.ic_arrow_up_green),
                vectorDown = painterResource(R.drawable.ic_arrow_down_grey),
                counterValue = thresholdValueForDays
            )
            SettingsCounterView(
                timeLabel = "hours",
                vectorUp = painterResource(R.drawable.ic_arrow_up_green),
                vectorDown = painterResource(R.drawable.ic_arrow_down_grey),
                counterValue = thresholdValueForHours
            )
            SettingsCounterView(
                timeLabel = "minutes",
                vectorUp = painterResource(R.drawable.ic_arrow_up_green),
                vectorDown = painterResource(R.drawable.ic_arrow_down_grey),
                counterValue = thresholdValueForMinutes
            )
        }
    }
}

@Composable
fun SettingsCounterView(
    timeLabel: String,
    vectorUp: Painter,
    vectorDown: Painter,
    counterValue: Int
){
    Column(modifier = Modifier.width(36.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = timeLabel.uppercase(), fontSize = 8.sp, color = Color.Black)
        Image(modifier = Modifier
            .clickable {
            }
            .padding(0.dp)
            .padding(4.dp), painter = vectorUp, contentDescription = "Upper green arrow")
        Card(modifier = Modifier
            .width(32.dp)
            .height(32.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 2.dp,
            border = BorderStroke(width = 1.dp, color = Color.Green)) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = counterValue.toString(), fontSize = 16.sp, color = Color.Black)
            }
        }
        Image(modifier = Modifier
            .clickable {

            }
            .padding(0.dp)
            .padding(4.dp) ,painter = vectorDown, contentDescription = "Upper green arrow")
    }
}

@Composable
fun SettingsClockView(
    labelText: String,
    labelDescription: String,
    checked: Boolean,
    isSpacerRequired: Boolean ?= true,
    onCheckedChange: (Boolean) -> Unit,
    ){
    Column(modifier = Modifier.fillMaxWidth()){
        SettingsSwitchView(
            labelText = labelText,
            checked = checked,
            onCheckedChange = onCheckedChange,
            isSpacerRequired = isSpacerRequired,
            fontSize = 12.sp
        )
        Text(
            modifier = Modifier
                .padding(0.dp)
                .padding(horizontal = 16.dp), text = labelDescription, fontSize = 14.sp
        )
        Row(modifier = Modifier.fillMaxWidth().padding(0.dp).padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(0.dp)
                    .padding(start = 16.dp)
                    .border(1.dp, color = Color.Red)
                ,
                shape = RectangleShape,
                elevation = 0.dp,
            ) {
                Text(modifier = Modifier.padding(4.dp), text = "Start Time", fontSize = 12.sp, textAlign = TextAlign.Center)
            }
            Text(modifier = Modifier.padding(0.dp).padding(horizontal = 2.dp),  text = ":", fontSize = 12.sp, textAlign = TextAlign.Center)
            Card(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(0.dp)
                    .padding(end = 16.dp)
                    .border(1.dp, color = Color.Red),
                shape = RectangleShape,
                elevation = 0.dp
            ) {
                Text(modifier = Modifier.padding(4.dp),text = "End Time", fontSize = 12.sp, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun SettingsRadioGroupView(
    labelText: String,
    labelDescription: String,
    checked: Boolean,
    options: List<Int>,
    optionSelected: Int,
    isSpacerRequired: Boolean ?= true,
    onCheckedChange: (Boolean) -> Unit,
){
    Column(modifier = Modifier.fillMaxWidth()) {
        SettingsSwitchView(labelText = labelText, checked = checked, onCheckedChange = onCheckedChange, isSpacerRequired = isSpacerRequired, fontSize = 12.sp)
        Text(modifier = Modifier
            .padding(0.dp)
            .padding(horizontal = 16.dp), text = labelDescription, fontSize = 14.sp)
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            options.map { option ->
                Card(
                    modifier = Modifier
                        .height(42.dp)
                        .width(84.dp)
                        .border(width = 1.dp, color = Color.Magenta)
                        .clickable { Timber.d("Card is clicked") }
                ) {
                    Box(modifier = Modifier.background(
                        if (option == optionSelected) Color.Green else Color.White
                    ), contentAlignment = Alignment.Center){
                        Text(text = "$option%", color = if (option == optionSelected) Color.White else Color.Green, fontSize = 14.sp)
                    }
                }
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(0.dp)
            .padding(horizontal = 16.dp)
            .background(Color.DarkGray))
    }
}