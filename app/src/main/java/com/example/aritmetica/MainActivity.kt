package com.example.aritmetica

import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aritmetica.ui.theme.AritmeticaTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AritmeticaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AritmericScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AritmericScreen(){
    var  numberOne:Int by remember {
        mutableStateOf(0)
    }
    var  numberTwo:Int by remember {
        mutableStateOf(0)
    }
    var resultado:String by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = numberOne.toString(), onValueChange= {
            /*if (it.toIntOrNull() != null) {
                numberOne = it.toInt()
            } else if (TextUtils.isEmpty(it)){
                numberOne = 0
            }*/
               numberOne = checkWroteNumer(it)
        }, label = {
            Text(text = "Primer número")
        }, placeholder = {
            Text(text = "Por favor escribe un número")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.Star,
                contentDescription = "Icono numero 1")
        },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = numberTwo.toString() , onValueChange = {
            numberTwo = checkWroteNumer(it)
        })
        Button(onClick = {
            resultado = (numberOne + numberTwo).toString()
        }, colors = ButtonDefaults.buttonColors(Color(0xFF748D5F)))  {
            Text(text = "+")
        }
        Button(onClick = {
            resultado = (numberOne - numberTwo).toString()
        }, colors = ButtonDefaults.buttonColors(Color(0xFFCE5F5F))) {
            Text(text = "-")
        }

        Button(onClick = {
            resultado = (numberOne * numberTwo).toString()
        } , colors = ButtonDefaults.buttonColors(Color(0xFF397196))) {
            Text(text = "*")
        }

        Button(onClick = {
            if (numberTwo != 0) {
                resultado = (numberOne / numberTwo).toString()
            } else {
                resultado = "Error: División por cero"
            }
        } , colors = ButtonDefaults.buttonColors(Color(0xFFC09A13))) {
            Text(text = "/")
        }
        Text(text = resultado)
    }
}
fun checkWroteNumer(text: String ):Int {
    if (text.toIntOrNull() != null) {
        return text.toInt()
    } else if (TextUtils.isEmpty(text) ){
        return 0
    }
    return 1
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AritmeticaTheme {
        AritmericScreen()
    }
}