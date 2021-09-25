package com.vitassalvantes.composebasicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitassalvantes.composebasicscodelab.ui.theme.ComposeBasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

/**
 * Container function that sets theme and color for all elements on screen
 */
@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeBasicsCodelabTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

/**
 * Set content on this screen
 */
@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "Compose", "Vitas")) {
    Column {
        names.forEach { name ->
            Greeting(name = name)
            if (name != names.last()) Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter()
    }
}

/**
 * Some text that greets the person and prints name
 */
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text(text = "I've been clicked ${count.value} times")
    }
}

@Preview(
    name = "App",
    showBackground = true
)
@Composable
fun PreviewMyApp() {
    MyApp {
        MyScreenContent()
    }
}