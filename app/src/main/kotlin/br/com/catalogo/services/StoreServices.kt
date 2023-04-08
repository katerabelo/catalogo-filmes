package br.com.catalogo.services

import br.com.catalogo.datastore.mapAddress
import br.com.catalogo.datastore.mapStaff
import br.com.catalogo.datastore.mapStore
import br.com.catalogo.domain.Staff
import br.com.catalogo.domain.Store

class StoreServices {

    // verifica se nomesobrenome possui smente letras, não pode caracter especial, numero e vazio e tem que ter no minimo 3 caracteres

    fun validaNome(nomeSobrenome: String): Boolean {
        val nomeRegex = Regex("[a-zA-ZÀ-ú ]{3,}")
        return nomeRegex.matches(nomeSobrenome)
    }
    //println(validaNome("validaNome: $fullNameReq"))

    fun save(store: Store) {


        var validaAddress = false


        val idReq = store.id
        val addressIdReq = store.addressId
        val lastUpdateReq = store.lastUpdate


        println("idReq: $idReq")
        println("addressIdReq: $addressIdReq")
        println("lastUpdateReq: $lastUpdateReq")


        // verifica se id é maior que zero
        if (idReq < 1)
            throw Exception("ID deve ser maior que 0 - não pode ser gravado")


        // verificar se Id ja existe

        for (s in mapStore) {
            if (s.value.id == idReq) {
                throw Exception("ID já existe - não pode ser gravado")
            }
        }


        for (a in mapAddress) {
            if (a.value.getId() == addressIdReq) {
                validaAddress = true
            }

        }
        if (!validaAddress) {
            throw Exception("AddressID é invalido -> $addressIdReq")
        }

        mapStore.put(idReq, Store(idReq, addressIdReq, lastUpdateReq))

    }

    fun update(store: Store) {

        var validaAddress = false
        var validaIdStore = false


        var idReq = store.id
        var addressIdReq = store.addressId
        var lastUpdateReq = store.lastUpdate


        for(s in mapStore){
            if (s.value.id == idReq){
                validaIdStore = true
            }
        }
        if (!validaIdStore) {
            throw Exception("StoreID é invalido -> $idReq")
        }


        // verifica se AdrressId da requisição ja existe no mapAdress em memória
        for (a in mapAddress) {
            if (a.value.getId() == addressIdReq) {
                validaAddress = true
            }

        }
        if (!validaAddress) {
            throw Exception("AddressID é invalido -> $addressIdReq")
        }

        mapStore.put(idReq, Store(idReq, addressIdReq, lastUpdateReq))


    }

    fun delete(idReq: Int) {

        var validaDelete = false

        for (s in mapStore) {
            if (idReq == s.value.id) {
                validaDelete = true
            }
        }

        if (validaDelete == true) {
            mapStore.remove(idReq)
        } else {
            throw Exception("ID não encontrado - não é possível deletar")
        }
    }


    fun getId(idReq: Int): Store? {
        for (s in mapStore) {
            if (idReq == s.value.id) {
                return s.value
            }
        }
        return null
        //throw Exception("ID não encontrado - não é possível deletar")
    }


    fun getAll(): MutableMap<Int, Store>? {
        if (mapStore.size == 0) {
            return null
        }
        return mapStore
    }

}
