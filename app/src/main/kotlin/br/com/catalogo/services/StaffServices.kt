package br.com.catalogo.services

import br.com.catalogo.domain.Staff
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse


class StaffServices {

    fun save(staff: Staff){
        val mapSave = mutableMapOf(
            staff.id to staff
        )

        println("mapSave: $mapSave")

        val z= mapSave.getValue(staff.id) //pq está retornando o staff completo não somente o ID?
        println("z: $z")

        val dbId = z?.id
        val dbNome = z?.firstName+z?.lastName

        println("dbId: $dbId")
        println("dbNome: $dbNome")


        // GRAVAR
        if( dbId != null && (dbId == z.id || dbNome == z?.firstName+z?.lastName) ) {
            throw Exception("Pessoa já existe - não pode ser gravada")
        }

        println("passou no if")
        //map.put(p.id, p)




    }
}



