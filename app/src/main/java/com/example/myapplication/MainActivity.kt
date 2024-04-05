package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val buttonState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CreateProfileImage(modifier = Modifier.size(250.dp))
            Divider()
            Column() {
                CreateUserInfo()
                Button(
                    onClick = {
                        buttonState.value = !buttonState.value
                    }
                ) {
                    Text(text = "Portfolio")
                }
            }
            if (buttonState.value) {
                CreatePortfolio()
            }
        }
    }
}

data class info(
    val name: String,
    val description: String,
    val imageResourceId: Int
)

@Composable
fun CreatePortfolio() {
    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Portfolio(
            data = listOf(
                info(
                    name = "dashbord",
                    description = "Description of dashbord",
                    imageResourceId = R.drawable.itachi
                ),
                info(
                    name = "dzs",
                    description = "Description of dzs",
                    imageResourceId = R.drawable.monta
                ),
                info(
                    name = "telia",
                    description = "Description of telia",
                    imageResourceId = R.drawable.testtest
                ),
            )
        )
    }
}

@Composable
fun Portfolio(data: List<info>) {
    LazyColumn() {
        items(data) { item ->
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                CreateImgProject(item.imageResourceId, modifier = Modifier.size(100.dp))
                //CreateImgProject1(modifier = Modifier.size(100.dp))
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .align(alignment = Alignment.CenterVertically)
                ) {
                    Text(
                        text = item.name,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun CreateUserInfo() {
    Text(
        text = "Montassar Themri",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(3.dp)
    )
    Text(
        text = "Junior Developer",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(3.dp)
    )
    Text(
        text = "This is my first licence",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(3.dp)
    )
}

@Composable
fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        modifier = modifier.padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.monta),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun CreateImgProject(imageResourceId: Int, modifier: Modifier = Modifier) {
    Surface(
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        modifier = modifier.padding(10.dp)
    ) {
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting()
    }
}
/*@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    MyApplicationTheme {
        CreatePortfolio()
    }
}*/
