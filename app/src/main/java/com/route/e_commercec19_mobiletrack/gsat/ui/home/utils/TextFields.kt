package com.route.e_commercec19_mobiletrack.gsat.ui.home.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.e_commercec19_mobiletrack.gsat.R

@Composable
fun SearchTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    @DrawableRes leadingIcon: Int?,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    TextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier.border(1.dp, colorScheme.primary, CircleShape),
        leadingIcon = {
            leadingIcon?.let {
                Image(
                    painter = painterResource(leadingIcon),
                    contentDescription = stringResource(R.string.search_bar)
                )
            }
        },
        placeholder = {
            Text(
                stringResource(R.string.what_do_you_search_for)
            )
        },
        shape = CircleShape,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = colorScheme.onSecondary,
            unfocusedTextColor = colorScheme.onSecondary,
            errorTextColor = colorScheme.onSecondary,
            disabledTextColor = colorScheme.onSecondary,
            errorLeadingIconColor = colorScheme.primary,
            disabledLeadingIconColor = colorScheme.primary,
            focusedLeadingIconColor = colorScheme.primary,
            unfocusedLeadingIconColor = colorScheme.primary,
            focusedContainerColor = colorScheme.secondary,
            unfocusedContainerColor = colorScheme.secondary,
            disabledContainerColor = colorScheme.secondary,
            errorContainerColor = colorScheme.secondary,

            )
    )
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    SearchTextField("Ahmed", {}, R.drawable.search)
}
