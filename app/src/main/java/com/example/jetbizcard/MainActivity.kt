 package com.example.jetbizcard


import android.graphics.Color.rgb
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   createBizCard()
                }
            }
        }
    }
}

@Composable
fun createBizCard(){
    val buttonClickedstate = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        ) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp)
           ,
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 4.dp) {
            Column(modifier = Modifier
                .height(300.dp)
                .background(color = Color(rgb(151, 196, 184))),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
                createImageprofile()
                Divider(
                    color = Color.White,
                    thickness = 10.dp
                )
                createInfo()
                Button(
                    onClick = {
                       buttonClickedstate.value = !buttonClickedstate.value
                    }
                ) {
                    Text(text = "Portfolio",
                    style = MaterialTheme.typography.button)

                }
                if(buttonClickedstate.value){
                    Content
                }else{
                    Box() {
                        
                    }
                }
                
            }
        }
        
    }
}

 @Preview
 @Composable
 fun create(){

    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxHeight()
        .padding(5.dp)) {

        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(2.dp,color=Color.LightGray)) {

            Portfolio(values = listOf<String>("Project1",
                "Project2",
                "Project3",
                "Project1",
                "Project2",
                "Project3")
            )

        }

    }



 }

 @Composable
 fun Portfolio( values: List<String>) {
      LazyColumn{
          items(values) { item ->
                Text(item)

          }
      }
 }

 @Composable
 private fun createInfo() {
     Column(
         modifier = Modifier.padding(10.dp)
     ) {
         Text(
             text = "Tejas K",
             style = MaterialTheme.typography.h4,
             color = Color.White,
         )
         Text(
             text = "Android Compose Programmer",
             modifier = Modifier.padding(5.dp),
             style = MaterialTheme.typography.subtitle1
         )
         Text(
             text = "@tejaskHARTUDE",
             modifier = Modifier.padding(5.dp),
             style = MaterialTheme.typography.subtitle2
         )

     }
 }

 @Composable
 private fun createImageprofile(modifier: Modifier=Modifier) {
     Surface(
         modifier = Modifier
             .size(150.dp)
             .padding(5.dp),
         shape = CircleShape,
         border = BorderStroke(0.5.dp, androidx.compose.ui.graphics.Color.LightGray),
         elevation = 4.dp,
         color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
     ) {

         Image(
             painter = painterResource(id = R.drawable.user),
             contentDescription = "Profile Image",
             modifier = Modifier.size(135.dp)
         )

     }
 }

 //@Preview(showBackground = true)
 @Composable
 fun DefaultPreview() {
    JetBizCardTheme {
          createBizCard()
    }
}