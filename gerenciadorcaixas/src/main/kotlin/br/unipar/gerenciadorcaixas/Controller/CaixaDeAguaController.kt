package br.unipar.gerenciadorcaixas.Controller

import br.unipar.gerenciadorcaixas.Model.CaixaDeAgua

import br.unipar.gerenciadorcaixas.Service.CaixaDeAguaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.server.ResponseStatusException


@RestController

class CaixaDeAguaController (
    private val service : CaixaDeAguaService ) {

    /*@GetMapping("/Ola")
    fun HelloWorld(): String {
        return "Hello World"
    }*/

    @GetMapping("/listar")
    fun listar(): ResponseEntity<List<CaixaDeAgua>> {
        return service.listar()
    }

    @GetMapping("/buscar/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<CaixaDeAgua> {
        return service.buscar(id)
    }

    @PostMapping("/salvar")
    fun salvar(@RequestBody caixa: CaixaDeAgua): ResponseEntity<String> {
        return service.salvar(caixa)
    }

    @GetMapping("/excluir/{id}")
    fun excluir(@PathVariable id: Long): ResponseEntity<Void> {
        return service.excluir(id)
    }

    @GetMapping("/marcas/{marca}")
    fun buscarMarcas(@PathVariable marca: String): List<CaixaDeAgua> {
        return service.buscarMarca(marca)
    }

}
