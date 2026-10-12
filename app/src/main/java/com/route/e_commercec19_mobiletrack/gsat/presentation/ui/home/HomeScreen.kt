package com.route.e_commercec19_mobiletrack.gsat.presentation.ui.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.route.e_commercec19_mobiletrack.gsat.R
import com.route.e_commercec19_mobiletrack.gsat.data.api.utls.AppExceptions
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.entity.CategoryEntity
import com.route.e_commercec19_mobiletrack.gsat.presentation.ui.home.utils.SearchTextField

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val colorScheme = MaterialTheme.colorScheme
    var searchText by remember { mutableStateOf("") }
    val viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
    val productsState = viewModel.productsState.collectAsStateWithLifecycle()
    val categoriesState = viewModel.categoriesState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getCategories()
    }

    LaunchedEffect(productsState.value) {
        Log.e("ProductsState", "ProductsState = ${productsState.value} ")
    }
    LaunchedEffect(Unit) {
        viewModel.errorSharedFlow.collect {
            Log.e("TAG", "HomeScreen: $it")
            when (it) {
                is AppExceptions.ClientError -> {
                    Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
                }

                AppExceptions.NoDataException -> {}
                is AppExceptions.ServerException -> {}
                is AppExceptions.UnknownError -> {

                }
            }
        }
    }

    //   build()
    Column(modifier = modifier.fillMaxSize()) {
        AppSearchBar() { }
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
        CategoriesList(categories = categoriesState.value)

    }
}

@Composable
fun AppSearchBar(modifier: Modifier = Modifier, onValueChanged: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }
    Column(modifier = modifier) {
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
                    onValueChanged(it)
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
    }
}

@Composable
fun CategoriesList(modifier: Modifier = Modifier, categories: List<CategoryEntity>) {
    LazyHorizontalGrid(
        modifier = modifier.height(300.dp),
        rows = GridCells.Fixed(2)
    ) {
        items(categories) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable(true) {

                }
            ) {
                AsyncImage(
                    // https://route.ecommerce.com/imagekfghafkg.png
                    model = it.image,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp), contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    it.name ?: "", fontSize = 14.sp,

                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
// Part 1
// Kotlin Coroutines ( Future<List<Product >> getProduct() async {} )
// Flow
// API Calls -> DIO + Retrofit

// Part 2
// Dependency Injection using Dagger Hilt
// Clean architecture

