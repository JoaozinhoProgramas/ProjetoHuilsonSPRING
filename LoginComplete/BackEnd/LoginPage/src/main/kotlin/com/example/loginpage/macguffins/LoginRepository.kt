package com.example.loginpage.macguffins

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface LoginRepository : JpaRepository<LoginModel, Long> {
    fun findByUsername(username: String): LoginModel

    fun existsByUsername(username: String): Boolean
}