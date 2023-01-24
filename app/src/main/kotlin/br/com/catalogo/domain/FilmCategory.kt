package br.com.catalogo.domain

import java.time.LocalDateTime

data class FilmCategory(
    val id: Int,
    val categoryId: Category,
    val lastUpdate: LocalDateTime
)
