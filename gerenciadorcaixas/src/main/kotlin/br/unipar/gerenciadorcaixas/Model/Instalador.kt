package br.unipar.gerenciadorcaixas.Model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GenerationType
import jakarta.persistence.GeneratedValue
import main.kotlin.br.unipar.gerenciadorcaixas.enumeradores.Habilidade
import main.kotlin.br.unipar.gerenciadorcaixas.enumeradores.Turno
import java.math.BigDecimal

@Entity
class Instalador (

    nome : String,
    cpf : String,
    idade : Int,
    val salario : BigDecimal,
    val turno : Turno,
    val habilidade : Habilidade
) : Pessoa(
    nome = nome,
    cpf = cpf,
    idade = idade
) {
    override fun receberConta(dinheiro : BigDecimal) : BigDecimal{
        return -dinheiro
    }//Uma função sobrescrita somente altera seu escopo
}