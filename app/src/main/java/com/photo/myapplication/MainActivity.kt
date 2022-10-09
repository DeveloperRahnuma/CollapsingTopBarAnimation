package com.photo.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.photo.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lazyListState = rememberLazyListState()
            Scaffold(content = {
                Column() {
                    TopBar(lazyListState)
                    MainItem(lazyListState)
                }
            })
        }
    }
}


@Composable
fun TopBar(lazyListState : LazyListState){
    TopAppBar(modifier = Modifier
        .fillMaxWidth()
        .height(if(lazyListState.isScrool()) 0.dp else 56.dp)
    ) {
        Text(text = "I am rahnuma sharib")
    }
}


@Composable
fun MainItem(lazyListState : LazyListState){
    LazyColumn(state = lazyListState){
        items(25){ index ->
            Text(text = index.toString(), style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))
        }
    }
}

fun LazyListState.isScrool() : Boolean{
    return firstVisibleItemScrollOffset > 0 || firstVisibleItemIndex > 0
}