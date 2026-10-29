package br.unipar.gerenciadorcaixas.Controller

import br.unipar.gerenciadorcaixas.Service.RelatorioPessoaService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/relatorios")
class RelatorioPessoaController(
    private val pessoaService : RelatorioPessoaService,
) {
    @GetMapping("/pessoa", produces = [MediaType.APPLICATION_PDF_VALUE])
    fun baixarRelatorio() : ResponseEntity<ByteArray> {
        val pdf = pessoaService.gerarRelatorio()
        val headers = HttpHeaders().apply {
            set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename = nomedoarquivosemespaço.pdf")
        }

        return ResponseEntity.ok()
            .header(headers.toString())
            .contentType(MediaType.APPLICATION_PDF)
            .body(pdf)


    }
}