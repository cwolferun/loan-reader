package com.wolfe.kommerce.reader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class LoanReaderApplication
fun main(args: Array<String>) {
    runApplication<LoanReaderApplication>(*args)
}
