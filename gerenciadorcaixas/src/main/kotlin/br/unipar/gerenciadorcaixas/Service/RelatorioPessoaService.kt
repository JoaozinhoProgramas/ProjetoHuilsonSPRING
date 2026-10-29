package br.unipar.gerenciadorcaixas.Service

import br.unipar.gerenciadorcaixas.Repository.PessoaRepository
import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperExportManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class RelatorioPessoaService(
    private val repository: PessoaRepository,
) {
    fun gerarRelatorio() : ByteArray {
        val pessoa = repository.findAll()

        val arquivo : InputStream =
            this.javaClass.getResourceAsStream("/relatorios/pessoa_relatorio.jrxml")
            ?: throw RuntimeException("Arquivo não encontrado!")

        //Transforma dados
        val dados = JRBeanCollectionDataSource(pessoa)

        //Manipular dados
        val relatorio = JasperCompileManager.compileReport(arquivo)
        val parametros = HashMap<String, Any>()
        val preencherRelatorios = JasperFillManager.fillReport(relatorio, parametros, dados)

        return JasperExportManager.exportReportToPdf(preencherRelatorios)

    }
}