package com.example.loginpage.macguffins

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class LoginService(
    val loginRepository: LoginRepository
) {
    fun saveUser(loginModel: LoginModel): ResponseEntity<String> {
        if (loginRepository.existsByUsername(loginModel.username)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe")
        }
        loginRepository.save(loginModel)
        return ResponseEntity.ok("Usuário salvo com sucesso")
    }
}