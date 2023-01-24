package br.com.catalogo.domain

import java.time.LocalDateTime

data class Actor(
    val id: Int,
    val name: String,
    val lastName: String,
    val lastUpdate: LocalDateTime

)
