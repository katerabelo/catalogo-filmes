package br.com.catalogo.domain

import java.time.LocalDateTime

data class City(
    val id: Int,
    val name: String,
    val countryId: Int,
    val lastUpdate: LocalDateTime
)
