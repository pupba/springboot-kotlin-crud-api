package com.springboot.kotlinexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinexampleApplication

fun main(args: Array<String>) {
	runApplication<KotlinexampleApplication>(*args)
}