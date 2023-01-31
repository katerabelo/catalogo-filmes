package br.com.catalogo.domain

import java.time.LocalDateTime

data class Address(
    val id: Int,
    val name: String,
    val name2: String,
    val district: String,
    val cityId: City,
    val postalCode: Int,
    val phone: Int,
    val lastUpdate: LocalDateTime,
    val location: String
)
