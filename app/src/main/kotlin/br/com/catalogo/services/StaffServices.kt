package br.com.catalogo.services

import br.com.catalogo.datastore.staffDb
import br.com.catalogo.domain.Staff
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse


class StaffServices {

    fun save(staff: Staff){

        val staffData = staffDb.get(staff.id)
        val dbNome = "${staffData?.firstName} ${staffData?.lastName}"
        val dbNomeStaff = "${staff.firstName} ${staff.lastName}"

        if ( staffData != null)
            throw Exception("Pessoa já existe - não pode ser gravada")

        if ( dbNome == dbNomeStaff)
            throw Exception("Já existe uma pessoa com este nome - não pode ser gravada")

        staffDb.put(staff.id, staff)
    }

    fun getAll() = staffDb
}



