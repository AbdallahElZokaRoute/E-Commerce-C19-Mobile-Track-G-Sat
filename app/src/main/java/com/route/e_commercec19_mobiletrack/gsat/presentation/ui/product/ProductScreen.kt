package com.route.e_commercec19_mobiletrack.gsat.presentation.ui.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.ProductEntity
import com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial.extensions.toEGP
import com.route.e_commercec19_mobiletrack.gsat.presentation.ui.home.AppSearchBar

@Composable
fun ProductsScreen(modifier: Modifier = Modifier, categoryId: String?) {
    val viewModel: ProductsViewModel = hiltViewModel()
    val productsListState = viewModel.productsListState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.getProductsList(categoryId)
    }
    Column(modifier = modifier.fillMaxSize()) {
        AppSearchBar() {}
        ProductsLazyVerticalGrid(productsList = productsListState.value)

    }
}

@Composable
fun ProductsLazyVerticalGrid(modifier: Modifier = Modifier, productsList: List<ProductEntity>) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(2)) {
        items(productsList) {
            ProductCard(productEntity = it)
        }
    }
}

@Composable
fun ProductCard(modifier: Modifier = Modifier, productEntity: ProductEntity) {
    val colorScheme = MaterialTheme.colorScheme
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.secondary,
            contentColor = colorScheme.primary
        )
    ) {
        AsyncImage(
            model = productEntity.imageCover,
            contentDescription = productEntity.description,
            modifier = Modifier.height(128.dp)
        )
        Text(
            text = productEntity.title ?: "", fontSize = 14.sp,
            minLines = 2,
            maxLines = 2,
            fontWeight = FontWeight.Normal
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                productEntity.priceAfterDiscount?.toDouble()?.toEGP() ?: "",
                textDecoration = TextDecoration.LineThrough
            )
            Text(productEntity.price?.toDouble()?.toEGP() ?: "")
        }
    }
}

@Preview
@Composable
private fun ProductsScreenPreview() {
    ProductsScreen(categoryId = "")
}
