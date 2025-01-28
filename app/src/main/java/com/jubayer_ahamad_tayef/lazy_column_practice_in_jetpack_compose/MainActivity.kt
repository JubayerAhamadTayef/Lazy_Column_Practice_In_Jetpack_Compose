package com.jubayer_ahamad_tayef.lazy_column_practice_in_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jubayer_ahamad_tayef.lazy_column_practice_in_jetpack_compose.repository.PersonRepository
import com.jubayer_ahamad_tayef.lazy_column_practice_in_jetpack_compose.ui.theme.Lazy_Column_Practice_In_Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lazy_Column_Practice_In_Jetpack_ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyLazyColumn(padding = innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyLazyColumn(padding: PaddingValues) {
    val getAllData = PersonRepository().generatePersons()
    LazyColumn(
        modifier = Modifier.padding(paddingValues = padding),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = getAllData
        ) { person ->
            CustomItem(person = person)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyLazyColumnPreview() {
    MyLazyColumn(padding = PaddingValues())
}