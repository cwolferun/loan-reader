package com.wolfe.kommerce.reader

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

//@SpringBootTest
class LoanReaderApplicationTests {

    @Test
    fun contextLoads() {
        val dateRange = "(:2010-3-4)"
        val split = dateRange.substring(1, dateRange.length - 1).split(":")

        println(split)
    }

}
