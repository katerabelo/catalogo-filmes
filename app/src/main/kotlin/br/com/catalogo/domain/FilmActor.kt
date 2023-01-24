package br.com.catalogo.domain

import java.time.LocalDateTime

data class FilmActor(
    val id: Int,
    val filmId: Film,
    val lastUpdate: LocalDateTime
)
