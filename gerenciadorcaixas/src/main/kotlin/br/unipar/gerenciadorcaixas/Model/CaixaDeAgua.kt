package br.unipar.gerenciadorcaixas.Model

import jakarta.persistence.Entity
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import main.kotlin.br.unipar.gerenciadorcaixas.enumeradores.Cor
import main.kotlin.br.unipar.gerenciadorcaixas.enumeradores.Material
import jakarta.persistence.GeneratedValue
import javax.annotation.processing.Generated

@Entity
class CaixaDeAgua(

    @Id
    @GeneratedValue(GenerationType.SEQUENCE)

    var id: Long? = null,
    val marca : String,
    val modelo : String,
    val dimensao : MutableList<Double> = mutableListOf(0.0, 0.0, 0.0),
    val cor : Cor,
    val material : Material,
    val formato : String,
    val preco : BigDecimal
)