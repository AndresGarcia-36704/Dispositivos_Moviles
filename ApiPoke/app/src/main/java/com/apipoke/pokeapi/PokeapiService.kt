package com.apipoke.pokeapi

import com.apipoke.models.PokemonRespuesta
import retrofit2.Call
import retrofit2.http.GET

interface PokeapiService {
    @GET("pokemon?limit=151")
    fun obtenerListaPokemon(): Call<PokemonRespuesta>
}