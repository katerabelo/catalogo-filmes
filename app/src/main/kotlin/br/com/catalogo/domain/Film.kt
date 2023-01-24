package br.com.catalogo.domain

import java.time.LocalDateTime

data class Film(
    val id: Int,
    val title: String,
    val description: String,
    val releaseYear: LocalDateTime,
    val languageId: Language,
    val originalLanguageId: Int,
    val rentalRate: Double,
    val length: Int,
    val replacementCost: Double,
    val rating: String,
    val specialFeatures: Int,
    val lastUpdate: LocalDateTime

)