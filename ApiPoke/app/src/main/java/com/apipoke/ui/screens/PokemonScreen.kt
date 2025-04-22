package com.apipoke.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.apipoke.models.Pokemon
import com.apipoke.models.PokemonRespuesta
import com.apipoke.pokeapi.PokeapiService
import com.apipoke.ui.components.PokemonItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(pokeApi: PokeapiService, modifier: Modifier = Modifier) {
    var pokemonList by remember { mutableStateOf<List<Pokemon>>(emptyList()) }

    LaunchedEffect(Unit) {
        pokeApi.obtenerListaPokemon().enqueue(object : Callback<PokemonRespuesta> {
            override fun onResponse(call: Call<PokemonRespuesta>, response: Response<PokemonRespuesta>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        pokemonList = it.results
                    }
                } else {
                    Log.e("API", "Error en la respuesta: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {
                Log.e("API", "Fallo: ${t.message}")
            }
        })
    }

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFB2FF59), Color(0xFF69F0AE))
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pokédex") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF69F0AE),
                    titleContentColor = Color.Black
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(pokemonList) { pokemon ->
                    val index = pokemonList.indexOf(pokemon) + 1
                    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$index.png"
                    PokemonItem(name = pokemon.name, imageUrl = imageUrl)
                }
            }
        }
    }
}