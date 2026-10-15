package br.unipar.gerenciadorcaixas.Repository

import br.unipar.gerenciadorcaixas.Model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long>