package com.talhakara.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talhakara.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "profile image",
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.CenterHorizontally), // Ortalamak için hizalama ekledik
                    contentScale = ContentScale.Crop
                )
            }
            Divider()
            creatInfo()





        }


    }


}
//@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp,
                color = Color.LightGray)) {

            Portfolio(data = listOf("Project 1",
                "Project 2",
                "Project 3",
                "Project 3",
                "Project 3"))

        }

    }


}

@Composable
fun Portfolio(data: List<String>) {

    LazyColumn {
        items(data){item ->
            Card(modifier= Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Row (modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)){
                    Surface(modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp),
                        shape = CircleShape,
                        border = BorderStroke(0.5.dp, Color.LightGray),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    ) {

                        Image(painter = painterResource(id = R.drawable.profile),
                            contentDescription = "profile image",
                            modifier = Modifier.size(135.dp),
                            contentScale = ContentScale.Crop)
                    }
                    Column (modifier=Modifier.padding(8.dp)){
                        Text(
                            text = item,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )

                        Text(
                            text = "A great project",
                            style =MaterialTheme.typography.bodySmall
                        )

                    }


                }

            }
        }
    }


}


@Composable
private fun creatInfo() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Talha Kara",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Android programer",
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "talhaflow",
            modifier = Modifier.padding(3.dp)
        )

        Button(onClick = {

            buttonClickedState.value=!buttonClickedState.value

        }) {
            Text(text = "Portfolio")
        }
        if(buttonClickedState.value){
            Content()
        }else{
            Box {
            }
        }



    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}