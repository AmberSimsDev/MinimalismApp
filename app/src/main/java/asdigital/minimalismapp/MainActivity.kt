package asdigital.minimalismapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import asdigital.minimalismapp.ui.theme.MinimalismAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinimalismAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    minimalistScreen()
                }
            }
        }
    }
}

@Composable
fun minimalistScreen(){

    var itemsInValue by remember{mutableStateOf(MyCounter.getIncreaseCounterOne())}
    var itemsOutValue by remember{mutableStateOf(MyCounter.getIncreaseCounterTwo())}


    
    Column(modifier = Modifier.fillMaxSize(), 
        horizontalAlignment = Alignment.CenterHorizontally, 
        verticalArrangement = Arrangement.Center) {

        Text(text = "Minimalism App")

        Spacer(modifier = Modifier.height(48.dp))
        Text(text = " $itemsInValue")
        Spacer(modifier = Modifier.height(16.dp))


        //BUTTON 1
        Button(onClick = {
            itemsInValue = MyCounter.increaseCounterOne()}) {
            Text(text = "Items In")
        }


        Spacer(modifier = Modifier.height(48.dp))
        Text(text = " $itemsOutValue")

        //BUTTON 2
        Button(onClick = {
            itemsOutValue = MyCounter.increaseCounterTwo()}) {
            Text(text= "Items Out")

        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MinimalismAppTheme {
      minimalistScreen()
    }
}