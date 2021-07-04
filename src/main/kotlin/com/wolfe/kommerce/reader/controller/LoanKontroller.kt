package com.wolfe.kommerce.reader.controller

import com.wolfe.kommerce.reader.model.LoanEntity
import com.wolfe.kommerce.reader.service.LoanService
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.RuntimeException
import java.time.Duration

@CrossOrigin
@RestController
class LoanKontroller(private val loanService: LoanService) {

    @GetMapping(value = ["/loan"])
    fun getLoan(): Mono<LoanEntity> = loanService.getLoan()

    @GetMapping(value = ["/loans"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getLoans(
        @RequestParam state: List<String>?,
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "(1990-10-01:2019-12-31)") dateRange: String
    ): Flux<LoanEntity> = loanService.getLoansByParams(state,dateRange, PageRequest.of(page, 5))
        .delayElements(Duration.ofSeconds(1))

}