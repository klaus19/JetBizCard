 package com.example.jetbizcard

import android.graphics.Color
import android.graphics.Color.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor =androidx.compose.ui.graphics.Color.White,
        elevation = 4.dp) {
            Column(modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
                createImageprofile()
                Divider(
                    modifier = Modifier,
                    androidx.compose.ui.graphics.Color.Cyan,
                    thickness = 1.dp,
                )
            }

        }
        
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

 @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
          createBizCard()
    }
}