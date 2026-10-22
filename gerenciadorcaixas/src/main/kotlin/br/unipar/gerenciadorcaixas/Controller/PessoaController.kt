package br.unipar.gerenciadorcaixas.Controller

import br.unipar.gerenciadorcaixas.Model.Pessoa
import br.unipar.gerenciadorcaixas.Service.PessoaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])

class PessoaController (
    private val service : PessoaService ) {

    @GetMapping("/listarPessoa")
    fun listar(): ResponseEntity<List<Pessoa>> {
        return service.listar()
    }

    @GetMapping("/buscarPessoa/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<Pessoa> {
        return service.buscar(id)
    }

    @PostMapping("/salvarPessoa")
    fun salvar(@RequestBody pessoa: Pessoa): ResponseEntity<String> {
        return service.salvar(pessoa)
    }
}