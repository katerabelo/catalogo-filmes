package br.com.catalogo.domain

import java.time.LocalDateTime

data class Store(
    val id: Int,
    val managerStaffId: Staff,
    val addressId: Address,
    val lastUpdate: LocalDateTime
)
