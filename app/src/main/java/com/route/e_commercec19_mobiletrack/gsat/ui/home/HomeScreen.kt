package com.route.e_commercec19_mobiletrack.gsat.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commercec19_mobiletrack.gsat.R
import com.route.e_commercec19_mobiletrack.gsat.ui.home.utils.SearchTextField

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val colorScheme = MaterialTheme.colorScheme
    var searchText by remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.logo),
            modifier = Modifier.padding(horizontal = 16.dp),
            contentDescription = stringResource(R.string.app_development_logo)
        )
        Row(
            modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchTextField(
                searchText,
                onValueChanged = {
                    searchText = it
                },
                leadingIcon = R.drawable.search,
                modifier = Modifier
                    .padding(start = 18.dp, end = 24.dp)
                    .fillMaxWidth(0.9F)
            )
            Image(
                painter = painterResource(R.drawable.cart),
                contentDescription = stringResource(R.string.cart_button),
                modifier = Modifier.padding(end = 16.dp)
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Image(
            painter = painterResource(R.drawable.pager_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        )
        // Categories
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                stringResource(R.string.categories),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = colorScheme.primary
            )
            Text(
                stringResource(R.string.view_all),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = colorScheme.primary
            )
        }
        LazyHorizontalGrid(
            modifier = Modifier.height(300.dp),
            rows = GridCells.Fixed(2)
        ) {
            items(80) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.dummy_category),
                        modifier = Modifier.size(100.dp), contentDescription = null
                    )
                    Text(
                        stringResource(R.string.headphones), fontSize = 14.sp,

                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}
