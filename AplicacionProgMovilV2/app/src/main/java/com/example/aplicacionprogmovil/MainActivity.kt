package com.example.aplicacionprogmovil

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionprogmovil.ui.theme.AplicacionProgMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionProgMovilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
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
        Log.d("LifeCycle", "onResume: Entramos en el OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause: Entramos en el onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop: Entramos en el onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy: Entramos en el onDestroy")
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
fun RowAditional(name: String, surname: String) {
    Row {
        Text(name, fontSize = 10.sp)
        Spacer(modifier = Modifier.padding(3.dp))
        Text(surname)
    }
}

@Composable
fun DiceApp() {
    DiceButton()
}

@Composable
fun DiceButton(modifier: Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = "Dice Image")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}

@Composable
fun CalculadoraUI() {
    var input by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterEnd),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = input.ifEmpty { " " },
                        fontSize = 26.sp,
                        color = Color.LightGray,
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = resultado.ifEmpty { "0" },
                        fontSize = 40.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End
                    )
                }
            }

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
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    fila.forEach { label ->
                        if (label.isNotEmpty()) {
                            BotonCalculadora(label, input, resultado) { newInput, newResultado ->
                                input = newInput
                                resultado = newResultado
                            }
                        } else {
                            Spacer(modifier = Modifier.size(80.dp))
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
                "=" -> {
                    val operacion = if (input.isNotBlank()) input else resultado
                    if (operacion.isNotBlank()) {
                        try {
                            val result = evaluarExpresion(operacion)
                            onValueChange("", result)
                        } catch (e: Exception) {
                            onValueChange("", "Error")
                        }
                    }
                }
                else -> {
                    if (label == "." && input.takeLastWhile { it.isDigit() || it == '.' }.contains(".")) return@Button
                    val newInput = if (input.isEmpty() && resultado.isNotEmpty() && label in listOf("+", "-", "*", "/")) {
                        resultado + label
                    } else {
                        input + label
                    }
                    onValueChange(newInput, "")
                }
            }
        },
        modifier = Modifier
            .size(80.dp)
            .padding(1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = label, fontSize = 35.sp, fontWeight = FontWeight.Bold)
    }
}

fun evaluarExpresion(expr: String): String {
    return try {
        val result = parseExpression(expr.replace(",", "."))

        val formatted = if (result % 1 == 0.0) {
            result.toInt().toString()
        } else {
            "%.${4}f".format(result)
                .replace(',', '.') // Por si acaso el sistema pone coma
                .trimEnd('0')
                .trimEnd('.')
        }

        formatted
    } catch (e: Exception) {
        "Error"
    }
}

fun parseExpression(expr: String): Double {
    val tokens = tokenize(expr)
    return parseTokens(tokens)
}

fun tokenize(expr: String): List<String> {
    val regex = Regex("([0-9]+(\\.[0-9]+)?|[+\\-*/()])")
    return regex.findAll(expr.replace(" ", "")).map { it.value }.toList()
}

fun parseTokens(tokens: List<String>): Double {
    val output = mutableListOf<String>()
    val operators = mutableListOf<String>()
    val precedence = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2)

    for (token in tokens) {
        when {
            token.matches(Regex("\\d+(\\.\\d+)?")) -> output.add(token)
            token in precedence -> {
                while (operators.isNotEmpty() &&
                    precedence[operators.last()] ?: 0 >= precedence[token] ?: 0
                ) {
                    output.add(operators.removeAt(operators.size - 1))
                }
                operators.add(token)
            }
            token == "(" -> operators.add(token)
            token == ")" -> {
                while (operators.isNotEmpty() && operators.last() != "(") {
                    output.add(operators.removeAt(operators.size - 1))
                }
                if (operators.isNotEmpty() && operators.last() == "(") {
                    operators.removeAt(operators.size - 1)
                }
            }
        }
    }

    while (operators.isNotEmpty()) {
        output.add(operators.removeAt(operators.size - 1))
    }

    val stack = mutableListOf<Double>()
    for (token in output) {
        if (token.matches(Regex("\\d+(\\.\\d+)?"))) {
            stack.add(token.toDouble())
        } else {
            val b = stack.removeAt(stack.size - 1)
            val a = stack.removeAt(stack.size - 1)
            stack.add(
                when (token) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    else -> throw IllegalArgumentException("Operador inválido")
                }
            )
        }
    }

    return stack.first()
}
