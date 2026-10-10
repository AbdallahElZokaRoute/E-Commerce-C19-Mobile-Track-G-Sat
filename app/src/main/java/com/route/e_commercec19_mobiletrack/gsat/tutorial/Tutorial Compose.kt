package com.route.e_commercec19_mobiletrack.gsat.tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commercec19_mobiletrack.gsat.ui.ui.theme.ECommerceTheme


// Composable function is A Widget
// That can be render a UI Component
// and Could be called multiple times
// for loop a composable

@Composable
fun GreetingList(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(), contentAlignment = Alignment.CenterStart
    ) {
        _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.Greeting("Ahmed")
        _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.Greeting(
            "Mohamed", modifier = modifier
                .background(Color.Green)
                .padding(16.dp)
        )
        _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.Greeting(
            "Hassan", modifier = Modifier
                .background(Color.Black)
                .padding(32.dp)
        )

    }
}

@Composable
fun CartSample(modifier: Modifier = Modifier, onCounterChanged: (count: Int) -> Unit) {
    val colorScheme = MaterialTheme.colorScheme
    // Recomposition
    var counter by remember { mutableStateOf(0) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Button(modifier = Modifier, onClick = {
            counter--
            onCounterChanged(counter)
        }, colors = ButtonDefaults.buttonColors(containerColor = colorScheme.primary)) {
            Text("-", fontSize = 22.sp)
        }
        Text("$counter", modifier = Modifier.padding(16.dp))
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(containerColor = colorScheme.primary),
            onClick = {
                counter++
                onCounterChanged(counter)
            }) {
            Text("+", fontSize = 22.sp)
        }
    }
}

@Preview(
    showSystemUi = false, showBackground = true
)
@Composable
private fun CartPreview() {
    _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.CartSample {}
}

@Composable
fun GreetingLazyList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(2)) {
        items(1000) {
            _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.Greeting(
                "Mohamed $it",
                modifier = Modifier
            )
        }
    }
}

// ListView.Builder
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
            .width(100.dp)
            .height(80.dp)
            .background(Color.Red, RoundedCornerShape(topEnd = 8.dp))
            .padding(16.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.ui.ui.theme.ECommerceTheme {
        _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.Greeting("Android 123")
    }
}