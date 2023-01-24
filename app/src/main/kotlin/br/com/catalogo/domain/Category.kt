package br.com.catalogo.domain

import java.time.LocalDateTime

data class Category(
    val id: Int,
    val name: String,
    val lastUpdate: LocalDateTime
)
