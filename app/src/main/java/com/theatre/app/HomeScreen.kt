package com.theatre.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theatre.app.data.model.Category
import com.theatre.app.ui.theme.*

@Composable
fun HomeScreen() {
    Column() {
        HeaderUI()
        SearchUI()
        CategoriesUI()
        PopularUI();
    }
}

@Composable
fun HeaderUI() {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    ) {
        Text(
            text = "Hi, Rex!",
            style = MaterialTheme.typography.h1,
        )

        Box() {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = stringResource(id = R.string.profile_description)
            )
            Box(modifier = Modifier
                .size(16.dp)
                .clip(CircleShape)
                .background(RedOrange)
                .border(2.dp, DeepBlue, shape = CircleShape)
                .align(Alignment.TopEnd))
        }
    }
}

@Composable
fun SearchUI() {
    val text = remember { mutableStateOf(TextFieldValue()) }
    Box(modifier = Modifier
        .padding(top = 20.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
        .height(50.dp)) {

        OutlinedTextField(
            value = text.value,
            onValueChange = { text.value = it },
            placeholder = {
                Text(
                    stringResource(
                        id = R.string.search_movie),
                    style = Typography.body2)
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = stringResource(id = R.string.search_movie),
                        tint = SoftBlue
                    )
                }
            },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = SoftBlue),
            modifier = Modifier.fillMaxWidth())

    }
}

@Composable
fun CategoriesUI() {

    val categories = listOf(
        Category("Horror", "\uD83D\uDE31"),
        Category("Romance", "\uD83E\uDD70"),
        Category("Comedy", "\uD83E\uDD2A"),
        Category("Drama", "\uD83E\uDD29"),
    )

    Column(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.categories),
                style = Typography.h2)
            Text(text = stringResource(id = R.string.see_more),
            style = Typography.body2)
        }

        Row (modifier = Modifier.padding(top = 10.dp)) {
            categories.iterator().forEach {
                CategoryCard(it)
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Box(modifier = Modifier.padding(10.dp)
        .clip(RoundedCornerShape(20.dp))
        .clickable {  }) {
        Box(modifier = Modifier
            .alpha(0.08f)
            .background(TextWhite)
            .size(width = 70.dp, height = 85.dp)
            .padding(10.dp))
        Column(modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(bottom = 10.dp), text = category.emoji, fontSize = 18.sp)
            Text(text = category.name, fontSize = 12.sp)
        }
    }
}

@Composable
fun PopularUI() {
    Column(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.popular),
                style = Typography.h2)
            Text(text = stringResource(id = R.string.see_more),
                style = Typography.body2)
        }
    }
}