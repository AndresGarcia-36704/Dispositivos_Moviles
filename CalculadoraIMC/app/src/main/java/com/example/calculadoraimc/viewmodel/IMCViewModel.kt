package com.example.calculadoraimc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoraimc.model.IMCResult

class IMCViewModel : ViewModel() {

    private val _resultado = MutableLiveData<IMCResult>()
    val resultado: LiveData<IMCResult> = _resultado

    fun calcularIMC(peso: Double, altura: Double) {
        if (altura <= 0.0 || peso <= 0.0) return

        val imc = peso / (altura * altura)
        val clasificacion = when {
            imc < 16.0 -> "Delgadez severa"
            imc < 17.0 -> "Delgadez moderada"
            imc < 18.5 -> "Delgadez leve"
            imc < 25.0 -> "Normal"
            imc < 30.0 -> "Sobrepeso"
            imc < 35.0 -> "Obesidad tipo I"
            imc < 40.0 -> "Obesidad tipo II"
            else -> "Obesidad tipo III (mórbida)"
        }
        _resultado.value = IMCResult(imc, clasificacion)
    }
}
