package com.example.boxlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalConfiguration

import com.example.boxlayout.ui.theme.BoxLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxLayoutTheme {
                Scaffold { innerPadding ->
                    AlignmentInBox(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AlignmentInBox(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Box(
        modifier = modifier
            .background(Color.LightGray)
            .size(width = screenWidth, height = screenHeight/3),
//        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Top Start",
            modifier.align(Alignment.TopStart)
        )
        Text(
            text = "Top Center",
            modifier.align(Alignment.TopCenter)
        )
        Text(
            text = "Top End",
            modifier.align(Alignment.TopEnd)
        )
        Text(
            text = "Center Start",
            modifier.align(Alignment.CenterStart)
        )
        Text(
            text = "Center",
            modifier.align(Alignment.Center)
        )
        Text(
            text = "Center End",
            modifier.align(Alignment.CenterEnd)
        )
        Text(
            text = "Bottom Start",
            modifier.align(Alignment.BottomStart)
        )
        Text(
            text = "Bottom Center",
            modifier.align(Alignment.BottomCenter)
        )
        Text(
            text = "Bottom End",
            modifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier,  fontSize: Int = 150 ) {

    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 5.dp, color = Color.Black)

    Surface {
        Text(
            text = text, cellModifier.then(modifier),
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoxLayoutTheme {
        AlignmentInBox()
    }
}