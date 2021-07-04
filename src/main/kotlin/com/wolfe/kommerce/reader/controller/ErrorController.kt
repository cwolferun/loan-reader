package com.wolfe.kommerce.reader.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorController {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(Exception::class)
    fun handleException(e:Exception):ResponseEntity<Map<String,String>>{
        logger.error(e.toString())
        return ResponseEntity.status(500).body(mapOf(Pair("Error",e.toString())))
    }

}