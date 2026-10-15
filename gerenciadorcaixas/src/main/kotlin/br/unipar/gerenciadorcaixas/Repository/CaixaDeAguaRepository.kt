package br.unipar.gerenciadorcaixas.Repository

import br.unipar.gerenciadorcaixas.Model.CaixaDeAgua
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CaixaDeAguaRepository : JpaRepository<CaixaDeAgua, Long>{
    fun findByMarcaContainingIgnoreCase(marca : String ) : List<CaixaDeAgua>
}