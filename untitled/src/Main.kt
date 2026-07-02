open class Produto(
    var nome: String = "",
    precoInicial: Double = 0.0,
    var estoque: Int = 0
) {
    private var preco: Double = 0.0

    init {
        setPreco(precoInicial)
    }

    fun getPreco(): Double {
        return preco
    }

    fun setPreco(valor: Double) {
        if (valor >= 0.0) {
            preco = valor
        } else {
            println("Erro: O preço do $nome não pode ser negativo!")
        }
    }

    fun aplicarDesconto(percentual: Double) {
        // Usando if/else básico com "E" (&&) lógico
        if (percentual >= 0.0 && percentual <= 100.0) {
            val valorDoDesconto = getPreco() * (percentual / 100)
            val precoComDesconto = getPreco() - valorDoDesconto

            setPreco(precoComDesconto) // Salva o novo preço
            println("Desconto aplicado! O $nome agora custa R$ ${"%.2f".format(getPreco())}")
        } else {
            println("Erro no $nome: O desconto tem que ser entre 0 e 100.")
        }
    }
}

class ProdutoPerecivel(
    nome: String = "",
    precoInicial: Double = 0.0,
    estoque: Int = 0,
    var dataValidade: String = ""
) : Produto(nome, precoInicial, estoque) {

    fun estaVencido(dataHoje: String): Boolean {
        if (dataValidade < dataHoje) {
            return true
        } else {
            return false
        }
    }
}

fun main() {
    println("--- LISTAGEM BÁSICA ---")
    val produto1 = Produto("Arroz", 8.50, 100)
    val produto2 = Produto("Feijão", 7.00, 50)
    val produto3 = Produto("Macarrão", 4.50, 200)


    println("Produto: ${produto1.nome} | Preço: R$ ${"%.2f".format(produto1.getPreco())} | Estoque: ${produto1.estoque}")
    println("Produto: ${produto2.nome} | Preço: R$ ${"%.2f".format(produto2.getPreco())} | Estoque: ${produto2.estoque}")
    println("Produto: ${produto3.nome} | Preço: R$ ${"%.2f".format(produto3.getPreco())} | Estoque: ${produto3.estoque}")

    println("\n    TESTANDO DESCONTOS E ERROS    ")
    produto1.aplicarDesconto(10.0)
    produto2.aplicarDesconto(-5.0)

    produto3.setPreco(-10.0)

    println("\n    TESTANDO PRODUTO PERECÍVEL    ")
    val produto4 = ProdutoPerecivel("Leite", 5.00, 20, "2024/05/10")
    val dataAtual = "2024/10/25"

    println("Produto: ${produto4.nome} | Validade: ${produto4.dataValidade}")

    if (produto4.estaVencido(dataAtual)) {
        println("Atenção: O ${produto4.nome} está vencido!")
    } else {
        println("O ${produto4.nome} está dentro da validade.")
    }
