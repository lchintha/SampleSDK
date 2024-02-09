package com.example.samplesdk

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.samplesdk.ui.theme.SampleSDKTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MealsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MealsViewModel::class.java]
        viewModel.initSDK()

        setContent {
            SampleSDKTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DisplayScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun DisplayScreen(viewModel: MealsViewModel) {
    Column {
        CustomButton(
            title = "Meal Categories"
        ) {
            viewModel.getMealCategories()
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            title = "Meal Information"
        ) {
            viewModel.getMealInformation("Chintha")
        }
    }
}

@Composable
fun CustomButton(title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = title
        )
    }
}