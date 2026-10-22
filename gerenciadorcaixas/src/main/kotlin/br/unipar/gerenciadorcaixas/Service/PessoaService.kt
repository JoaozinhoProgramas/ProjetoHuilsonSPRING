package br.unipar.gerenciadorcaixas.Service

import br.unipar.gerenciadorcaixas.Model.Pessoa
import br.unipar.gerenciadorcaixas.Repository.PessoaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PessoaService(
    val repository : PessoaRepository

) {
    fun listar() : ResponseEntity<List<Pessoa>> {
        val pessoa = repository.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(pessoa)
    }

    fun buscar( id : Long) : ResponseEntity<Pessoa> {
        val resposta = repository.findById(id).orElseThrow(){
            NoSuchElementException("O $id digitado não é válido")
        }
        return ResponseEntity.status(HttpStatus.OK).body(resposta)
    }

    fun salvar( pessoa : Pessoa) : ResponseEntity<String>{
        repository.save(pessoa)
        return ResponseEntity.status(HttpStatus.CREATED).body("Caixa de Agua salva no banco")
    }

}
