package com.wolfe.kommerce.reader.service

import com.wolfe.kommerce.reader.model.LoanEntity
import com.wolfe.kommerce.reader.repository.LoanRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.LocalDate
import kotlin.random.Random

@Service
class LoanService(private val loanRepository: LoanRepository) {

    fun getLoan() = loanRepository.findFirstById(Random.nextLong(1_500_000))

    fun getLoansByParams(state: List<String>?, dateRange: String, pageable: Pageable): Flux<LoanEntity> {

        val split = dateRange.substring(1, dateRange.length - 1).split(":")
        val begin = if (split[0].isEmpty()) "1990-10-01" else split[0]
        val end = if (split[1].isEmpty()) "2019-12-31" else split[1]

        return if (state == null) loanRepository.findLoanEntitiesByApprovalDateBetween(
            LocalDate.parse(begin),
            LocalDate.parse(end),
            pageable
        )
        else loanRepository.findLoanEntitiesByBankStateInAndApprovalDateBetween(
            state,
            LocalDate.parse(begin),
            LocalDate.parse(end),
            pageable
        )

    }

}