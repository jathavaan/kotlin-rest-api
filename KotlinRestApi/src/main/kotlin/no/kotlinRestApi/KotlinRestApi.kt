package no.kotlinRestApi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinRestApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinRestApiApplication::class.java, *args)
}
