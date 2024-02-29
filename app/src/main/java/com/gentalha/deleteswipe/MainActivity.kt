package com.gentalha.deleteswipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gentalha.deleteswipe.ui.components.SwipeDeleteContainer
import com.gentalha.deleteswipe.ui.theme.Dark
import com.gentalha.deleteswipe.ui.theme.DeleteSwipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeleteSwipeTheme {
                val programmingLanguages = remember {
                    mutableStateListOf(
                        "Kotlin",
                        "Java",
                        "Python",
                        "PHP",
                        "Dart",
                        "Go",
                        "C++",
                        "C#"
                    )
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Dark)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(items = programmingLanguages, key = { it }) { language ->
                        SwipeDeleteContainer(
                            item = language,
                            onDelete = {
                                programmingLanguages -= language
                            }
                        ) {
                            Text(
                                text = it,
                                color = Color.White,
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Dark)
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}