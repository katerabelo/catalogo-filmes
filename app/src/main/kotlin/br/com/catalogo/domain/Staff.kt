package br.com.catalogo.domain

import io.micronaut.core.annotation.Introspected
import java.sql.Blob
import java.time.LocalDateTime

@Introspected
data class Staff(
    val id: Int,
    val firstName: String,
    val lastName: String,
    //val addressId: Address,
    val addressId: Int,
    //val storeId: Store,
    val storeId: Int,
    val lastUpdate: LocalDateTime
)
