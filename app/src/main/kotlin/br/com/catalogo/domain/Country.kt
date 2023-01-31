package br.com.catalogo.domain

import java.time.LocalDateTime

data class Country(
    val id: Int,
    val name: String,
    val lastUpdate: LocalDateTime
)
