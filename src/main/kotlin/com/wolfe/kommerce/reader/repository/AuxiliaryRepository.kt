package com.wolfe.kommerce.reader.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class AuxiliaryRepository(private val jdbcThing: JdbcTemplate) {

    fun idk() = jdbcThing.queryForList("select state from state", String)

}