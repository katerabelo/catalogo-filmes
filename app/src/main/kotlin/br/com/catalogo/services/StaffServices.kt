package br.com.catalogo.services

//import br.com.catalogo.datastore.address
import br.com.catalogo.datastore.mapAddress
import br.com.catalogo.datastore.mapStaff
import br.com.catalogo.datastore.mapStore
//mport br.com.catalogo.datastore.staffDb
//import br.com.catalogo.datastore.staffDbN
import br.com.catalogo.domain.Staff
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse


class StaffServices {

    // verifica se nomesobrenome possui smente letras, não pode caracter especial, numero e vazio e tem que ter no minimo 3 caracteres

    fun validaNome(nomeSobrenome: String): Boolean {
        val nomeRegex = Regex("[a-zA-ZÀ-ú ]{3,}")
        return nomeRegex.matches(nomeSobrenome)
    }
    //println(validaNome("validaNome: $fullNameReq"))

    fun save(staff: Staff) {

        /*val staffData = staffDb.get(staff.id)
        val dbID = "${staffData?.id}"
        val dbNomeReq = "${staff.firstName} ${staff.lastName}"
        val dbPrimNomeReq = "${staff.firstName}"
        val dbSobreNomeReq = "${staff.lastName}"
        val staffDataN = staffDbN.get(staff.firstName)
        val dbNomeN = "${staffDataN?.firstName} ${staffDataN?.lastName}"
        val dbIDReq = "${staff.id}"*/
        var validaAddress = false
        var validaStore = false


        val idReq = staff.id
        val firstNameReq = staff.firstName
        val lastNameReq = staff.lastName
        val addressIdReq = staff.addressId
        val storeIdReq = staff.storeId
        val lastUpdateReq = staff.lastUpdate
        val fullNameReq = "${staff.firstName} ${staff.lastName}"


        println("idReq: $idReq")
        println("firstNameReq: $firstNameReq")
        println("lastNameReq: $lastNameReq")
        println("addressIdReq: $addressIdReq")
        println("storeIdReq: $storeIdReq")
        println("lastUpdateReq: $lastUpdateReq")




// verifica se id é maior que zero
        if (idReq < 1) {
            throw Exception("ID deve ser maior que 0 - não pode ser gravado")
        }
// verificar se o nome+sobrenome ja existe

        for (s in mapStaff) {
            if (s.value.firstName == firstNameReq && s.value.lastName == lastNameReq) {
                throw Exception("Pessoa já existe - não pode ser gravado")
            }
        }

        // verificar se Id ja existe

        for (s in mapStaff) {
            if (s.value.id == idReq) {
                throw Exception("ID já existe - não pode ser gravado")
            }
        }

        //if (idReq != null || dbNomeN == fullNameReq)
        //  throw Exception("Pessoa já existe - não pode ser gravado")

// verifica caracter especial, e tamanho maior que 3, e se está vazio
        if ((firstNameReq.length >= 3 && lastNameReq.length >= 3) && validaNome(fullNameReq)) {
            println("fullNameReq é valido")
            println("validaNome: $fullNameReq")
        } else {
            throw Exception("fullNameReq é invalido -> $fullNameReq")
        }

        for (a in mapAddress) {
            if (a.value.getId() == addressIdReq) {
                validaAddress = true
            }

        }
        if (!validaAddress) {
            throw Exception("AddressID é invalido -> $addressIdReq")
        }


        for (s in mapStore) {
            if (s.value.id == storeIdReq) {
                validaStore = true
            }

        }
        if (!validaStore) {
            throw Exception("StoreID é invalido -> $storeIdReq")
        }

        //if ( dbNomeN == fullNameReq)
        //throw Exception("Já existe uma pessoa com este nome - não pode ser gravada")

        //staffDb.put(staff.id, staff)
        //staffDbN.put(staff.firstName, staff)

        mapStaff.put(idReq, Staff(idReq, firstNameReq, lastNameReq, addressIdReq, storeIdReq, lastUpdateReq))

    }

    fun update(staff: Staff) {

        var validaAddress = false
        var validaStore = false


        val idReq = staff.id
        val firstNameReq = staff.firstName
        val lastNameReq = staff.lastName
        val addressIdReq = staff.addressId
        val storeIdReq = staff.storeId
        val lastUpdateReq = staff.lastUpdate
        val fullNameReq = "${staff.firstName} ${staff.lastName}"


        println("idReq: $idReq")
        println("firstNameReq: $firstNameReq")
        println("lastNameReq: $lastNameReq")
        println("addressIdReq: $addressIdReq")
        println("storeIdReq: $storeIdReq")
        println("lastUpdateReq: $lastUpdateReq")

        // verificar se o nome+sobrenome ja existe em um ID diferente

        for (s in mapStaff) {
            if (s.value.firstName == firstNameReq && s.value.lastName == lastNameReq
                && s.value.id != idReq
            ) {
                throw Exception("Pessoa já existe em um ID diferente - não pode ser gravado")
            }
        }

        // verifica caracter especial, e tamanho maior que 3, e se está vazio
        if ((firstNameReq.length >= 3 && lastNameReq.length >= 3) && validaNome(fullNameReq)) {
            println("fullNameReq é valido")
            println("validaNome: $fullNameReq")
        } else {
            throw Exception("fullNameReq é invalido -> $fullNameReq")
        }

        for (a in mapAddress) {
            if (a.value.getId() == addressIdReq) {
                validaAddress = true
            }

        }
        if (!validaAddress) {
            throw Exception("AddressID é invalido -> $addressIdReq")
        }


        for (s in mapStore) {
            if (s.value.id == storeIdReq) {
                validaStore = true
            }

        }
        if (!validaStore) {
            throw Exception("StoreID é invalido -> $storeIdReq")
        }

        //if ( dbNomeN == fullNameReq)
        //throw Exception("Já existe uma pessoa com este nome - não pode ser gravada")

        //staffDb.put(staff.id, staff)
        //staffDbN.put(staff.firstName, staff)

        mapStaff.put(idReq, Staff(idReq, firstNameReq, lastNameReq, addressIdReq, storeIdReq, lastUpdateReq))


    }

    fun delete(idReq: Int) {

        var validaDelete = false

        for (s in mapStaff) {
            if (idReq == s.value.id) {
                validaDelete = true
            }
        }

        if (validaDelete == true) {
            mapStaff.remove(idReq)
        } else {
            throw Exception("ID não encontrado - não é possível deletar")
        }
    }


    fun getId(idReq: Int): Staff? {

        for (s in mapStaff) {
            if (idReq == s.value.id) {
                return s.value
            }
        }
        return null
        //throw Exception("ID não encontrado - não é possível deletar")

    }


    fun getAll(): MutableMap<Int, Staff>? {
        if (mapStaff.size == 0) {
            return null

        }
        return mapStaff
    }
}



