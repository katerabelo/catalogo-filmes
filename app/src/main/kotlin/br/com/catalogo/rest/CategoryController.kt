package br.com.catalogo.rest

import br.com.catalogo.services.CategoryServices
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/category")
class CategoryController {

    val categoryServices = CategoryServices()

    @Get("/consulta")
    fun getCategory() = categoryServices.getAll()
}