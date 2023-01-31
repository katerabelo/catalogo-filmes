package br.com.catalogo.domain

import java.time.LocalDateTime

data class Customer(
    val id: Int,
    val storeId: Store,
    val firstName: String,
    val lastName: String,
    val email: String,
    val addressId: Address,
    val active: Boolean,
    val createDate: LocalDateTime,
    val lastUpdate: LocalDateTime
)
