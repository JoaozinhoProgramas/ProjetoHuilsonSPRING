package com.example.loginpage.macguffins


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@CrossOrigin(origins = ["*"])

@RequestMapping("/login")
class LoginController(
    private val loginService: LoginService
) {
    @PostMapping("/save")
    fun saveLogin(@RequestBody login: LoginModel): ResponseEntity<String> {
        return loginService.saveUser(login)
    }
}

