package br.unipar.gerenciadorcaixas.Repository

import br.unipar.gerenciadorcaixas.Model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : JpaRepository<Pessoa, Long>