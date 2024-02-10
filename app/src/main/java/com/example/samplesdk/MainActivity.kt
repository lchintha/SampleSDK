package com.example.samplesdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    val loading = viewModel.screenLoading.value

    Column {
        CustomButton(
            title = "Meal Categories"
        ) {
            viewModel.getMealCategories()
        }
        CustomButton(
            title = "Meal Information"
        ) {
            viewModel.getMealInformation("Arrabiata")
        }

        viewModel.observeMealCategories.observeAsState().value.let { mealCategories ->
            if(mealCategories != null) {
                CustomText(text = mealCategories.categories[0].toString())
            }
        }
        viewModel.observeMealInformation.observeAsState().value.let { mealInformation ->
            if(mealInformation != null) {
                mealInformation.meal?.get(0)?.let { CustomText(text = it.instructions) }
            }
        }
    }

    CustomCircularProgressBar(isDisplayed = loading)
}

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(10.dp)
    )
}

@Composable
fun CustomButton(title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title
        )
    }
}

@Composable
fun CustomCircularProgressBar(isDisplayed: Boolean) {
    if(isDisplayed) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(modifier = Modifier
                .padding(50.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}