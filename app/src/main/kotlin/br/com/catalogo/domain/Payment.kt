package br.com.catalogo.domain

import java.time.LocalDateTime

data class Payment(
    val id: Int,
    val customerId: Customer,
    val staffId: Staff,
    val rentalId: Rental,
    val amount: Int,
    val paymentDate: LocalDateTime,
    val lastUpdate: LocalDateTime
)
