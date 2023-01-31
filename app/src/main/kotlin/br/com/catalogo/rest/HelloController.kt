package br.com.catalogo.rest

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloController {
    @Get
    fun hello():String{
        return "Hello Word !!!"
    }


}