package br.com.catalogo.domain

import java.time.LocalDateTime

data class Rental(
    val id: Int,
    val rentalDate: LocalDateTime,
    val inventoryId: Inventory,
    val customerId: Customer,
    val returnDate: LocalDateTime,
    val staffId: Staff,
    val lastUpdate: LocalDateTime
)
