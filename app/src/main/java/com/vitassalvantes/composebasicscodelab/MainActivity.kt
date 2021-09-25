package com.vitassalvantes.composebasicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
                Greeting(name = "Android")
            }
        }
    }
}

@Composable
// Container function
fun MyApp(content: @Composable () -> Unit) {
    ComposeBasicsCodelabTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Preview(
    name = "App",
    showSystemUi = true
)
@Composable
fun PreviewMyApp() {
    MyApp {
        Greeting(name = "Compose")
    }
}

@Preview(
    name = "Greeting",
    showBackground = true
)
@Composable
fun DefaultPreview() {
    ComposeBasicsCodelabTheme {
        Greeting("Android")
    }
}