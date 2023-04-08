package br.com.catalogo.domain

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime

@Introspected
data class Store(
    val id: Int,
    val addressId: Int,
    val lastUpdate: LocalDateTime

)
