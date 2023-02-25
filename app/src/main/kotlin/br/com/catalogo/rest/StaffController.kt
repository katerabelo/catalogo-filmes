package br.com.catalogo.rest

import br.com.catalogo.datastore.staffDb
import br.com.catalogo.domain.City
import br.com.catalogo.domain.Staff
import br.com.catalogo.services.StaffServices
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import java.net.http.HttpResponse
import java.time.LocalDateTime
import io.micronaut.http.MutableHttpResponse as HttpMutableHttpResponse

@Controller("/staff")
class StaffController {

    private val staffServices = StaffServices()
    //Pq me obrigou a colocar o private ?

    @Post
    fun create(staff: Staff): HttpMutableHttpResponse<Unit>? {
        try{
            staffServices.save(staff)

        } catch (ex: Exception){
            println(ex.message)
            return io.micronaut.http.HttpResponse.badRequest()
        }
        return io.micronaut.http.HttpResponse.ok()

    }

    @Put
    fun update(staff: Staff){
        println(staff)
    }

    @Delete("/{id}")
    fun delete(id:Int){
        println("Delete_by_Id: $id")
    }

    @Get("/{id}")
    fun getById(id:Int){
        println("Get_By_Id: $id")
    }

    @Get
    fun getAll(): MutableMap<Int, Staff> {
        return staffServices.getAll()

    }
}