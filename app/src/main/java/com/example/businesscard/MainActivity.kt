package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    InfoCard(
                        name = stringResource(R.string.darshana_das_k),
                        description = stringResource(R.string.android_develepor),
                        contact = stringResource(R.string.phone),
                        email = stringResource(R.string.email_id)
                    )
                }
            }
        }
    }
}

@Composable
fun InfoCard(
    name: String,
    description: String,
    contact: String,
    email: String
) {
    val fontFamily = FontFamily(
        Font(R.font.lexend_thin, FontWeight.Thin),
        Font(R.font.lexend_light, FontWeight.Light),
    )
    val myFont = FontFamily(
        Font(R.font.playfairdisplay_regular)
    )

    val image = painterResource(R.drawable.android_logo)

    // The whole layout
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFF003b4e))
    ) {
        //The name and designation part
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 124.dp),

            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.padding(start = 110.dp, end = 110.dp, top = 100.dp)
            )
            Text(
                text = name,
                fontSize = 40.sp,
                color = Color.White,
                fontFamily = myFont,

                fontWeight = FontWeight.Bold


            )
            Text(
                text = description,
                color = Color(0xFF3ddc84),
                fontSize = 24.sp,
                fontFamily = fontFamily
            )

            //The contact part
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Bottom


            ) {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier


                )
                Spacer(modifier = Modifier.height(10.dp))
                ContactInfo(
                    icon = painterResource(R.drawable.ic_phone),
                    contact = contact
                )
                Spacer(modifier = Modifier.height(10.dp))


                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier


                )
                Spacer(modifier = Modifier.height(10.dp))
                ContactInfo(
                    icon = painterResource(R.drawable.ic_email),
                    contact = email
                )


            }
        }


    }

}

@Composable
fun ContactInfo(
    icon: Painter,
    contact: String
) {
    val fontFamily = FontFamily(
        Font(R.font.lexend_thin, FontWeight.Thin),
        Font(R.font.lexend_light, FontWeight.Light),
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.weight(1f)


        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = contact,
            fontSize = 18.sp,
            color = Color.White,
            fontFamily = fontFamily,
            modifier = Modifier.weight(1f)


        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        InfoCard(
            name = stringResource(R.string.darshana_das_k),
            description = stringResource(R.string.android_develepor),
            contact = stringResource(R.string.phone),
            email = stringResource(R.string.email_id)
        )
    }
}