package com.example.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.state.ui.theme.StateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWorkSpace()
                }
            }
        }
    }

@Composable
fun ArtWorkSpace(

){
    var count by remember {
        mutableStateOf(1)
    }

    var imageId by remember {
        mutableStateOf(1)
    }

    var textHeading by remember {
        mutableStateOf("")
    }

    var headDesc by remember {
        mutableStateOf("")
    }


    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .background(color = Color.Transparent)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(

            modifier = Modifier
                .width(500.dp)
                .height(500.dp) ,
                    painter = painterResource(id = imageId),
            contentDescription = "school structure",

        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = textHeading,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally
                    ),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = headDesc,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally
                    ),

            )
        }

        Spacer(modifier = Modifier.height(10.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = "Previous",

                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = {
                          count++;

                 when(count){
                        1 -> {imageId = R.drawable.icons8_school_64; textHeading = R.string.school_icon.toString(); headDesc = R.string.school_icon_desc.toString()}
                        2 -> {imageId = R.drawable.icons8_student_80; textHeading = R.string.student_icon.toString();headDesc = R.string.school_icon_desc.toString()}
                        3 -> {imageId = R.drawable.icons8_teacher_100;textHeading = R.string.teacher_icon.toString();headDesc = R.string.teacher_icon_desc.toString()}
                        4 -> {imageId = R.drawable.icons8_school_64__1_;textHeading = R.string.book_icon.toString();headDesc = R.string.book_icon_desc.toString()}


                     else -> {1}
                 }
                },
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "Next",

                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 20.sp

                )
            }
        }
    }
}



    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        StateTheme {
            ArtWorkSpace()
        }
    }
}