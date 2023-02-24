package br.com.catalogo

import br.com.catalogo.domain.City
import io.micronaut.runtime.Micronaut.run
import java.time.LocalDateTime

fun main(args: Array<String>) {
	run(*args)

	//Carregando dados

	val saoPaulo = City(
		id = 1,
		name = "São Paulo",
		countryId = 1,
		lastUpdate = LocalDateTime.of(2023,1,1,9,0,0)

	)

	val rioDeJaneiro = City(
		id = 2,
		name = "Rio de Janeiro",
		countryId = 1,
		lastUpdate = LocalDateTime.of(2023,1,1,10,0,0)

	)

	val santaCatarina = City(
		id = 3,
		name = "Santa Catarina",
		countryId = 1,
		lastUpdate = LocalDateTime.of(2023,1,1,11,0,0)

	)

	val minasGerais = City(
		id = 4,
		name = "Minas Gerais",
		countryId = 1,
		lastUpdate = LocalDateTime.of(2023,1,1,12,0,0)

	)

	/* Testando outra forma de fazer o Map em memoria
        val mapCities = mapOf(
            saoPaulo.id to City(1,"São Paulo",1,LocalDateTime.of(2023,1,1,9,0,0)),
            rioDeJaneiro.id to City(2,"Rio de Janeiro",1,LocalDateTime.of(2023,1,1,10,0,0)),
            santaCatarina.id to City(3,"Santa Catarina",1,LocalDateTime.of(2023,1,1,11,0,0)),
            minasGerais.id to City(4,"Minas Gerais",1,LocalDateTime.of(2023,1,1,12,0,0))

        )

	 */


        val mapCities2 = mapOf(
            saoPaulo.id to saoPaulo,
            rioDeJaneiro.id to rioDeJaneiro,
            santaCatarina.id to santaCatarina,
            minasGerais.id	to minasGerais
        )
    /* Testando outra forma de fazer o Map em memoria
        val mapCities3 = mapOf(
            City.id to City(1,"São Paulo",1,LocalDateTime.of(2023,1,1,9,0,0)),
            rioDeJaneiro.id to City(2,"Rio de Janeiro",1,LocalDateTime.of(2023,1,1,10,0,0)),
            santaCatarina.id to City(3,"Santa Catarina",1,LocalDateTime.of(2023,1,1,11,0,0)),
            minasGerais.id to City(4,"Minas Gerais",1,LocalDateTime.of(2023,1,1,12,0,0))

        )
    */

	//println(saoPaulo)
	//println(rioDeJaneiro)
	println(mapCities2)
}

