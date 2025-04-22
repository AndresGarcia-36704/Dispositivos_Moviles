package com.apipoke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.apipoke.pokeapi.PokeapiService
import com.apipoke.ui.screens.PokemonScreen
import com.apipoke.ui.theme.ApiPokeTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private lateinit var pokeApi: PokeapiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar Retrofit con base URL de la PokéAPI
        pokeApi = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeapiService::class.java)

        // Establecer la UI con Jetpack Compose y tu tema
        setContent {
            ApiPokeTheme {
                PokemonScreen(pokeApi = pokeApi)
            }
        }
    }
}
