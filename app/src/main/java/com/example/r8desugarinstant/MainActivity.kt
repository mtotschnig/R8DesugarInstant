package com.example.r8desugarinstant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Keep
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.r8desugarinstant.ui.theme.R8DesugarInstantTheme
import java.time.LocalDateTime
import java.time.ZoneId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val instant = Class.forName("com.example.dynamicfeature.InstantProviderImpl").newInstance() as InstantProvider
        setContent {
            R8DesugarInstantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(instant.provideInstant().toString())
                }
            }
        }
    }
}

@Keep
object Bogus {
    fun calculateInstant() = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()
}