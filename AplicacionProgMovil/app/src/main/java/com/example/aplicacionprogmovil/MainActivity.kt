package com.example.aplicacionprogmovil

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.aplicacionprogmovil.ui.theme.AplicacionProgMovilTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionProgMovilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting()
                        DiceApp()
                        CalculadoraUI()
                    }
                }
            }
        }
        Log.d("LifeCycle", "onCreate: Entramos en el OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart: Entramos en el OnStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "OnResume: Entramos en el OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "OnResume: Entramos en el onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStart: Entramos en el onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "OnResume: Entramos en el onDestroy")
    }
}

@Composable
fun Greeting() {
    Column {
        RowAditional("Diego", "Franco")
        RowAditional("Mauricio", "Cruz")
        RowAditional("Victor", "Osorio")
    }
}

@Composable
fun RowAditional(name : String, surname : String){
    Row {
        Text(name, fontSize = 10.sp)
        Spacer( modifier = Modifier.padding(3.dp))
        Text(surname)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AplicacionProgMovilTheme {
        Column {
            Greeting()
            CalculadoraUI()
        }
    }
}

@Composable
fun DiceApp() {
    DiceButton()
}

@Composable
fun DiceButton(modifier: Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)){
    var result by remember { mutableStateOf(1) }
    var imageResource = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally ) {
        Image(painter = painterResource(imageResource), contentDescription = "Dice Image" )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {result = (1..6).random()}) {
            Text(stringResource(R.string.roll))
        }
    }
}

@Composable
fun CalculadoraUI() {
    var input by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Pantalla de resultado
        Text(
            text = resultado.ifEmpty { input.ifEmpty { "0" } },
            fontSize = 48.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Botones
        Column {
            val botones = listOf(
                listOf("%", "C", "⌫", "/"),
                listOf("7", "8", "9", "*"),
                listOf("4", "5", "6", "-"),
                listOf("1", "2", "3", "+"),
                listOf("0", ".", " ", "=")
            )

            botones.forEach { fila ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    fila.forEach { label ->
                        if (label.isNotEmpty()) {
                            BotonCalculadora(label, input, resultado) { newInput, newResultado ->
                                input = newInput
                                resultado = newResultado
                            }
                        } else {
                            Spacer(modifier = Modifier.size(72.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BotonCalculadora(
    label: String,
    input: String,
    resultado: String,
    onValueChange: (String, String) -> Unit
) {
    Button(
        onClick = {
            when (label) {
                "C" -> onValueChange("", "")
                "⌫" -> onValueChange(input.dropLast(1), "")
                "=" -> onValueChange(input, resultado)
                else -> onValueChange(input + label, "")
            }
        },
        modifier = Modifier
            .size(72.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = label, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
} 