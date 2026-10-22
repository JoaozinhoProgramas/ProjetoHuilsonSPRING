package br.unipar.gerenciadorcaixas.Service

import br.unipar.gerenciadorcaixas.Model.CaixaDeAgua
import br.unipar.gerenciadorcaixas.Repository.CaixaDeAguaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CaixaDeAguaService(
    val repository : CaixaDeAguaRepository
) {

    fun listar() : ResponseEntity <List<CaixaDeAgua>>{
        val caixas = repository.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(caixas)
    }

    fun buscar( id : Long) : ResponseEntity<CaixaDeAgua>{
        val resposta = repository.findById(id).orElseThrow(){
            NoSuchElementException("O $id digitado não é válido")
        }
        return ResponseEntity.status(HttpStatus.OK).body(resposta)
    }

    fun salvar(caixa: CaixaDeAgua) : ResponseEntity<String>{
        repository.save(caixa)
        return ResponseEntity.status(HttpStatus.CREATED).body("Caixa de Agua salva no banco")
    }

    fun excluir( id : Long) : ResponseEntity<Void>{
        repository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    fun buscarMarca (Marca : String) : List<CaixaDeAgua>{
        return repository.findByMarcaContainingIgnoreCase(Marca)
    }
}