package br.com.catalogo.rest

//import br.com.catalogo.datastore.staffDb
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
        try {
            staffServices.save(staff)

        } catch (ex: Exception) {
            println(ex.message)
            return io.micronaut.http.HttpResponse.badRequest()
        }
        return io.micronaut.http.HttpResponse.ok()

    }

    @Put
    fun update(staff: Staff): HttpMutableHttpResponse<Unit>? {
        try {
            staffServices.update(staff)

        } catch (ex: Exception) {
            println(ex.message)
            return io.micronaut.http.HttpResponse.badRequest()
        }
        return io.micronaut.http.HttpResponse.ok()
    }

    @Delete("/{id}")
    fun delete(id: Int): HttpMutableHttpResponse<Any>? {
        try {
            staffServices.delete(id)

        } catch (ex: Exception) {
            println(ex.message)
            return io.micronaut.http.HttpResponse.notFound("ID_não_encontrado_não_é_possível_deletar")
        }
        return io.micronaut.http.HttpResponse.ok("Deletado_com_sucesso")
    }

    @Get("/{id}")
    fun getById(id: Int): HttpMutableHttpResponse<Any>? {
        val objetoEncontrado = staffServices.getId(id)

        // Se o objeto foi encontrado:
        if (objetoEncontrado != null) {
            return io.micronaut.http.HttpResponse.ok(objetoEncontrado)
        } else {
            // Se o objeto não foi encontrado, retorna um status 404
            return io.micronaut.http.HttpResponse.notFound("ID_não_encontrado.")
        }
    }


    @Get
    fun getAll(): HttpMutableHttpResponse<Any>? {
        val objetoEncontrado = staffServices.getAll()

        // Se o objeto foi encontrado:
        if (objetoEncontrado != null) {
            return io.micronaut.http.HttpResponse.ok(objetoEncontrado)
        } else {
            // Se o objeto não foi encontrado, retorna um status 404
            return io.micronaut.http.HttpResponse.notFound("Lista_de_Staff_vazia.")
        }

    }
}