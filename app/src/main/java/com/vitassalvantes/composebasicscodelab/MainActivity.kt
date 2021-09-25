package com.vitassalvantes.composebasicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
fun MyScreenContent(names: List<String> = List(100) { "Hello Compose #$it" }) {
    val counterState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names = names, modifier = Modifier.weight(1f))
        Counter(
            count = counterState.value,
            updateCount = { newCount -> counterState.value = newCount }
        )
    }
}

/**
 * List of names
 */
@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

/**
 * Some animated text that greets the person and prints name
 */
@Composable
fun Greeting(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Text(
        text = "Hello $name!",
        modifier = Modifier
            .padding(24.dp)
            .background(color = backgroundColor)
            .clickable(onClick = { isSelected = !isSelected })
    )
}

/**
 * Button with clicks counter
 */
@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count % 2 == 0) Color.Green else Color.Red
        )
    ) {
        Text(text = "I've been clicked $count times")
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