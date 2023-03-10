package br.com.catalogo.services

import br.com.catalogo.datastore.staffDb
import br.com.catalogo.datastore.staffDbN
import br.com.catalogo.domain.Staff
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse


class StaffServices {
    fun save(staff: Staff){

        val staffData= staffDb.get(staff.id)
        val dbID = "${staffData?.id}"
        val dbNomeReq = "${staff.firstName} ${staff.lastName}"
        val staffDataN= staffDbN.get(staff.firstName)
        val dbNomeN = "${staffDataN?.firstName} ${staffDataN?.lastName}"
        val dbIDReq = "${staff.id}"

        println("staffData: $staffData")
        println("dbID: $dbID")
        println("dbNomeReq: $dbNomeReq")
        println("staffDataN: $staffDataN")
        println("dbNomeN: $dbNomeN")
        println("dbIDReq: $dbIDReq")



// verifica se nomesobrenome possui smente letras, não pode caracter expecial, numero e vazio e tem que ter no minimo 3 caracteres

            fun validaNome(nomeSobrenome: String): Boolean {
                val nomeRegex = Regex("[a-zA-ZÀ-ú ]{3,}")
                return nomeRegex.matches(nomeSobrenome)
            }
        println(validaNome("validaNome: $dbNomeReq"))
// verifica se id é maior que zero
        if (dbIDReq < 1.toString())
            throw Exception("ID deve ser maior que 0 - não pode ser gravado")

// verificar se o nome+sobrenome ja existe
        if ( staffData != null || dbNomeN == dbNomeReq)
           throw Exception("Pessoa já existe - não pode ser gravado")

        if (validaNome(dbNomeReq)){
            println("dbNomeReq é valido")
            println(validaNome("validaNome: $dbNomeReq"))
        }else{
            throw Exception("dbNomeReq é invalido")
        }




        //if ( dbNomeN == dbNomeReq)
         //throw Exception("Já existe uma pessoa com este nome - não pode ser gravada")

        staffDb.put(staff.id, staff)
        staffDbN.put(staff.firstName, staff)

    }

    fun getAll() = staffDb
}



