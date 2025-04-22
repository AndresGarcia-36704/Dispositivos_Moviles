package com.apipoke.models

import com.google.gson.annotations.SerializedName

data class PokemonRespuesta(
    @SerializedName("results") val results: List<Pokemon>
)