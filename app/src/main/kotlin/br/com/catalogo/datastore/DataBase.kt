package br.com.catalogo.datastore

import br.com.catalogo.domain.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//val staffDb = mutableMapOf<Int, Staff>()

//val staffDbN = mutableMapOf<String, Staff>()

var mapStaff = mutableMapOf<Int, Staff>()

val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

var mapAddress = mapOf( 1 to Address(1, "Av Paulista", null, "Cerqueira Cezar", 1, 12345333, "93333-0000",  LocalDateTime.parse("2023-01-01 09:00:00", formatter)),
2 to Address(2, "Av Brasil", null, "Lebron", 2, 12345444, "94444-0001",  LocalDateTime.parse("2023-01-01 10:00:00", formatter)),
3 to Address(3, "Av Brasil", null, "Sambaqui", 3, 12345555, "95555-0002",  LocalDateTime.parse("2023-01-01 11:00:00", formatter)),
) as MutableMap<Int, Address>

var mapStore = mapOf( 1 to Store(1, 1,  LocalDateTime.parse("2023-01-01 09:00:00", formatter)),
2 to Store(2, 2,  LocalDateTime.parse("2023-01-01 10:00:00", formatter)),
3 to Store(3, 3, LocalDateTime.parse("2023-01-01 11:00:00", formatter)),
) as MutableMap<Int, Store>


var map_Category = mapOf( 1 to Category(1, "Ação", LocalDateTime.parse("2023-01-01 09:00:00", formatter)),
2 to Category(2, "Comédia", LocalDateTime.parse("2023-01-01 10:00:00", formatter)),
3 to Category(3, "Ficção", LocalDateTime.parse("2023-01-01 11:00:00", formatter)),
) as MutableMap<Int, Category>


/*var map_Language = mapOf( 1 to Language(1, "Português", LocalDateTime.parse("2023-01-01 09:00:00", formatter)),
2 to Language(2, "Inglês", LocalDateTime.parse("2023-01-01 10:00:00", formatter)),
3 to Language(3, "Espanhol", LocalDateTime.parse("2023-01-01 11:00:00", formatter))
) as MutableMap<Int, Language>*/


var map_City = mapOf(1 to City(1, "São Paulo", 1, LocalDateTime.parse("2023-01-01 09:00:00", formatter)),
2 to City(2, "Rio de Janeiro", 1, LocalDateTime.parse("2023-01-01 10:00:00", formatter)),
3 to City(3, "Santa Catarina", 1, LocalDateTime.parse("2023-01-01 11:00:00", formatter)),
4 to City(4, "Minas Gerais", 1, LocalDateTime.parse("2023-01-01 12:00:00", formatter)),
) as MutableMap<Int, City>


var map_Country = mapOf(1 to Country(1, "Brasil", LocalDateTime.parse("2023-01-01 09:00:00", formatter)))
as MutableMap<Int, Country>
