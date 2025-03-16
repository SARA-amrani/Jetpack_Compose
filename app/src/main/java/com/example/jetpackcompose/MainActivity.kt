package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import feu3.ui.MainActivityFeu3View

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            JetpackComposeTheme {
                Surface(
                    modifier=Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ){
                    MainActivityFeu3View()
                }
            }
        }


    }

}

@Composable
fun AccueilMultipleSeulementJ(names: List<String>) {
    Column {
        for (name in names) {
            if (name.startsWith("j")) {
                Text(text = "Bonjour $name !",modifier=Modifier.padding(4.dp))
            }
        }
    }
}
@Preview
@Composable
fun AccueilMultipleSeulementJPreview() {
    AccueilMultipleSeulementJ(listOf("paul", "jean", "pierre", "jacques"))
}