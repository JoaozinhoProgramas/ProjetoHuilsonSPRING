package br.unipar.gerenciadorcaixas.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import java.math.BigDecimal

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Pessoa (
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open var id: Long? = null,

    open val nome: String,
    open val cpf: String,
    open val idade: Int
)//Criação da classe-mãe via Construtor
{
    open fun receberConta(dinheiro : BigDecimal) : BigDecimal{
        return dinheiro
    }
}