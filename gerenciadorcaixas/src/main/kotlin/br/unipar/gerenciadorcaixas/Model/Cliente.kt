package br.unipar.gerenciadorcaixas.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
class Cliente(

    nomeCliente: String,
    cpfCliente: String,
    idadeCliente: Int,
    val dividasAbertas: Boolean,
    val parcelasAPagar : MutableList<BigDecimal>
) : Pessoa(
    nome = nomeCliente,
    cpf = cpfCliente,
    idade = idadeCliente
)