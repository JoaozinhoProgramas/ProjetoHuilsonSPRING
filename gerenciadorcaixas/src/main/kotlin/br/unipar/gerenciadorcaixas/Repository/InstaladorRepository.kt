package br.unipar.gerenciadorcaixas.Repository

import br.unipar.gerenciadorcaixas.Model.Instalador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InstaladorRepository : JpaRepository<Instalador, Long>