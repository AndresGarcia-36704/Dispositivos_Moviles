package com.example.calculadoraimc.ui.theme

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.viewmodel.IMCViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun IMCPantalla(viewModel: IMCViewModel) {
    var pesoTexto by remember { mutableStateOf("") }
    var alturaTexto by remember { mutableStateOf("") }

    val resultado = viewModel.resultado.observeAsState()

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = pesoTexto,
            onValueChange = { pesoTexto = it },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = alturaTexto,
            onValueChange = { alturaTexto = it },
            label = { Text("Altura (m)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val peso = pesoTexto.toDoubleOrNull()
                val altura = alturaTexto.toDoubleOrNull()
                if (peso != null && altura != null) {
                    viewModel.calcularIMC(peso, altura)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular IMC")
        }

        Spacer(modifier = Modifier.height(32.dp))

        resultado.value?.let {
            Text(
                text = "IMC: %.2f\nClasificación: %s".format(it.imc, it.clasificacion),
                style = MaterialTheme.typography.h6
            )
        }
    }
}
