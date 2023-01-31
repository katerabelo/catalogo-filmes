package br.com.catalogo.domain

import java.time.LocalDateTime

data class Inventory(
    val id: Int,
    val filmId: Film,
    val storeId: Store,
    val lastUpdate: LocalDateTime
)
