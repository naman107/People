package com.example.people.presenter.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.example.people.presenter.theme.PeopleTheme
import com.revos.android.ui.composables.SettingsRadioGroupView
import com.revos.android.ui.composables.SettingsSwitchView
import com.revos.android.ui.composables.SettingsThresholdViews
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeopleTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier
                        .wrapContentHeight()
                        .verticalScroll(rememberScrollState()))
                    {
                        for (i in 1..10){
                            if(i < 5){
                                val isToggle_1 = remember {
                                    mutableStateOf(true)
                                }
                                Timber.d("RECOMPOSITION when i < 5: ${isToggle_1}")
                                SettingsSwitchView(
                                    labelText = "Antitheft",
                                    checked = isToggle_1.value,
                                    isSpacerRequired = true,
                                    fontSize = 14.sp
                                ) {
                                    isToggle_1.value = !it
                                }
                            }
                            if(i == 5){
                                val isToggle = remember {
                                    mutableStateOf(false)
                                }
//                                isToggle.value = false
                                Timber.d("RECOMPOSITION when i == 5: ${isToggle}")
                                SettingsThresholdViews(
                                    labelText = "Overspeeding Alert",
                                    labelDescription = "Notify me if my vehicle drives over",
                                    checked = isToggle.value,
                                    isSpacerRequired = false,
                                    thresholdValue = TextFieldValue("60"),
                                    unit = "Kmph",
                                    onCheckedChange = {
                                        isToggle.value = !it
                                    },
                                )
                            }
                            if(i > 5){
                                val isToggle_2 = remember {
                                    mutableStateOf(true)
                                }
                                isToggle_2.value = false
                                Timber.d("RECOMPOSITION when i > 5: ${isToggle_2}")
                                SettingsRadioGroupView(
                                    labelText = "Battery Low",
                                    labelDescription = "Notify me if my vehicle drives over",
                                    checked = isToggle_2.value,
                                    isSpacerRequired = false,
                                    options = arrayListOf(5, 10, 15),
                                    optionSelected = 10,
                                    onCheckedChange = {
                                        isToggle_2.value = !it
                                    }
                                )
                            }
/*                            SettingsOptionsView(
                                labelText = "Idle Time",
                                labelDescription = "Notify me if my vehicle stops over",
                                checked = false,
                                thresholdValueForDays = 0,
                                thresholdValueForHours = 1,
                                thresholdValueForMinutes = 2,
                                onCheckedChange = {
                                    isToggle = !it
                                }
                            )*/



//                            Sample1()
//                            Sample2()
//                            Sample3()
                        }
                    }
                }
            }
        }
    }
}

/*    @Composable
    private fun Sample1() {
        Column(
            modifier = Modifier
                .background(getRandomColor())
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            var counter by remember { mutableStateOf(0) }

            Text("Sample1", color = getRandomColor())

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                onClick = {
                    counter++
                }) {
                Text("Counter: $counter", color = getRandomColor())
            }
        }
    }

    @Composable
    private fun Sample2() {
        Column(
            modifier = Modifier.background(getRandomColor())
        ) {

            var update1 by remember { mutableStateOf(0) }
            var update2 by remember { mutableStateOf(0) }

            println("ROOT")
            Text("Sample2", color = getRandomColor())

            Button(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                onClick = {
                    update1++
                },
                shape = RoundedCornerShape(5.dp)
            ) {

                println("🔥 Button1️")

                Text(
                    text = "Update1: $update1",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )

            }

            Button(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                onClick = { update2++ },
                shape = RoundedCornerShape(5.dp)
            ) {
                println("🍏 Button 2️")

                Text(
                    text = "Update2: $update2",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )
            }

            Column(
                modifier = Modifier.background(getRandomColor())
            ) {

                println("🚀 Inner Column")
                var update3 by remember { mutableStateOf(0) }

                Button(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                    onClick = { update3++ },
                    shape = RoundedCornerShape(5.dp)
                ) {

                    println("✅ Button 3️")
                    Text(
                        text = "Update2: $update2, Update3: $update3",
                        textAlign = TextAlign.Center,
                        color = getRandomColor()
                    )

                }
            }

            Column() {
                println("☕️ Bottom Column")
                Text(
                    text = "Sample2",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )
            }

        }
    }

    @Composable
    private fun Sample3() {
        Column(
            modifier = Modifier.background(getRandomColor())
        ) {


            var update1 by remember { mutableStateOf(0) }
            var update2 by remember { mutableStateOf(0) }


            println("ROOT")
            Text("Sample3", color = getRandomColor())

            Button(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                onClick = {
                    update1++
                },
                shape = RoundedCornerShape(5.dp)
            ) {

                println("🔥 Button1️")

                Text(
                    text = "Update1: $update1",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )

            }

            Button(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                onClick = { update2++ },
                shape = RoundedCornerShape(5.dp)
            ) {
                println("🍏 Button 2️")

                Text(
                    text = "Update2: $update2",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )
            }

            Column {

                println("🚀 Inner Column")
                var update3 by remember { mutableStateOf(0) }

                Button(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = getRandomColor()),
                    onClick = { update3++ },
                    shape = RoundedCornerShape(5.dp)
                ) {

                    println("✅ Button 3️")
                    Text(
                        text = "Update2: $update2, Update3: $update3",
                        textAlign = TextAlign.Center,
                        color = getRandomColor()
                    )

                }
            }
            // 🔥🔥 Reading update1 causes entire composable to recompose
            Column(
                modifier = Modifier.background(getRandomColor())
            ) {
                println("☕️ Bottom Column")
                Text(
                    text = "Update1: $update1",
                    textAlign = TextAlign.Center,
                    color = getRandomColor()
                )
            }
        }
    }*/

/*    private fun getRandomColor() : Color {
        val red = Random().nextInt(256)
        val green = Random().nextInt(256)
        val blue = Random().nextInt(256)
        return Color(red, green, blue)
    }*/

//@Preview(showBackground = true)
/*
@Composable
fun DefaultPreview() {
    PeopleTheme {
        var isToggle by remember {
            mutableStateOf(false)
        }
        var threshold by remember {
            mutableStateOf("120")
        }
        Surface(modifier = Modifier.fillMaxSize()){
            Column(modifier = Modifier.fillMaxSize()) {
                SettingsSwitchView(labelText = "Antitheft",
                    checked = isToggle,
                    isSpacerRequired = true,
                    fontFamily = FontFamily(Font(androidx.compose.runtime.R.font.nunito_regular)),
                    fontSize = 14.sp
                ){ isToggle = !it }
                SettingsThresholdViews(
                    labelText = "Overspeeding Alert",
                    labelDescription = "Notify me if my vehicle drives over",
                    checked = isToggle,
                    isSpacerRequired = false,
                    thresholdValue = TextFieldValue(threshold),
                    unit = "Kmph",
                    onCheckedChange = {
                        isToggle = !it
                    },
                    onValueChange = {
                        threshold = it.text
                    }
                )
                SettingsRadioGroupView(
                    labelText = "Battery Low",
                    labelDescription = "Notify me if my vehicle drives over",
                    checked = isToggle,
                    isSpacerRequired = false,
                    options = arrayListOf(5,10,15),
                    optionSelected = 10,
                    onCheckedChange = {
                        isToggle = !it
                    }
                )
                SettingsOptionsView(
                    labelText = "Idle Time",
                    labelDescription = "Notify me if my vehicle stops over",
                    checked = false,
                    thresholdValueForDays = 0,
                    thresholdValueForHours = 1,
                    thresholdValueForMinutes = 2,
                    onCheckedChange = {
                        isToggle = !it
                    },
                    onClickDownArrow = {
                        Timber.d("Down Arrow clicked")
                    },
                    onClickUpArrow = {
                        Timber.d("Up Arrow clicked")
                    }
                )
            }
        }
    }
}*/
