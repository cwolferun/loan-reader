package com.wolfe.kommerce.reader.repository

import com.wolfe.kommerce.reader.model.LoanEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.util.*

@Repository
interface LoanRepository : ReactiveCrudRepository<LoanEntity, Long> {
    fun findFirstById(id:Long): Mono<LoanEntity>

    fun findLoanEntitiesByApprovalDateBetween(begin: LocalDate, end: LocalDate, pageable: Pageable): Flux<LoanEntity>

    fun findLoanEntitiesByBankStateInAndApprovalDateBetween(
        bankState: List<String>,
        begin: LocalDate,
        end: LocalDate,
        pageable: Pageable
    ): Flux<LoanEntity>
}