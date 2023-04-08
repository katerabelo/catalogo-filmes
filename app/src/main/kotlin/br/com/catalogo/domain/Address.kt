package br.com.catalogo.domain

import java.time.LocalDateTime

class Address {
    private var id: Int
    private var name: String
    private var name2: String?
    private var district: String
    private var cityId: Int
    private var postalCode: Int
    private var phone: String
    private var lastUpdate: LocalDateTime

    constructor(
        id: Int, name: String, name2: String?, district: String, cityId: Int,
        postalCode: Int, phone: String, lastUpdate: LocalDateTime
    ) {

        this.id = id
        this.name = name
        this.name2 = name2
        this.district = district
        this.cityId = cityId
        this.postalCode = postalCode
        this.phone = phone
        this.lastUpdate = lastUpdate

    }

    fun getId(): Int {
        return this.id
    }

}