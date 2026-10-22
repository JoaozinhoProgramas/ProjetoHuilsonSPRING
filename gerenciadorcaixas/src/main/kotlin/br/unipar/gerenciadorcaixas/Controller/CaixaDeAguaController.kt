package br.unipar.gerenciadorcaixas.Controller

import br.unipar.gerenciadorcaixas.Model.CaixaDeAgua

import br.unipar.gerenciadorcaixas.Service.CaixaDeAguaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.CrossOrigin


@RestController
@CrossOrigin(origins = ["*"])

class CaixaDeAguaController (
    private val service : CaixaDeAguaService ) {

    @GetMapping("/listarCaixa")
    fun listar(): ResponseEntity<List<CaixaDeAgua>> {
        return service.listar()
    }

    @GetMapping("/buscarCaixa/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<CaixaDeAgua> {
        return service.buscar(id)
    }

    @PostMapping("/salvarCaixa")
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
