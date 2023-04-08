package br.com.catalogo.rest

import br.com.catalogo.domain.Store
import br.com.catalogo.services.StoreServices
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*


@Controller("/store")
class StoreController {


    private val storeServices = StoreServices()
    //Pq me obrigou a colocar o private ?

    @Post
    fun create(store: Store): MutableHttpResponse<Unit>? {
        try {
            storeServices.save(store)

        } catch (ex: Exception) {
            println(ex.message)
            return io.micronaut.http.HttpResponse.badRequest()
        }
        return io.micronaut.http.HttpResponse.ok()

    }

    @Put
    fun update(store: Store): MutableHttpResponse<Unit>? {
        try {
            storeServices.update(store)

        } catch (ex: Exception) {
            println(ex.message)
            return io.micronaut.http.HttpResponse.badRequest()
        }
        return io.micronaut.http.HttpResponse.ok()
    }

    @Delete("/{id}")
    fun delete(id: Int): MutableHttpResponse<Unit>? {
        try {
            storeServices.delete(id)

        } catch (ex: Exception) {
            println(ex.message)
            return io.micronaut.http.HttpResponse.badRequest()
        }
        return io.micronaut.http.HttpResponse.ok()
    }

    @Get("/{id}")
    fun getById(id: Int): MutableHttpResponse<Any>? {
        val objetoEncontrado = storeServices.getId(id)

        // Se o objeto foi encontrado:
        if (objetoEncontrado != null) {
            return io.micronaut.http.HttpResponse.ok(objetoEncontrado)
        } else {
            // Se o objeto não foi encontrado, retorna um status 404
            return io.micronaut.http.HttpResponse.notFound("ID_não_encontrado.")
        }
    }


    @Get
    fun getAll(): MutableHttpResponse<Any>? {
        val objetoEncontrado = storeServices.getAll()

        // Se o objeto foi encontrado:
        if (objetoEncontrado != null) {
            return io.micronaut.http.HttpResponse.ok(objetoEncontrado)
        } else {
            // Se o objeto não foi encontrado, retorna um status 404
            return io.micronaut.http.HttpResponse.notFound("Lista_de_Staff_vazia.")
        }

    }

}