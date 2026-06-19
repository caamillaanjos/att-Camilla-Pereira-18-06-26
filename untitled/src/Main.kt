class Produto(
    var nome: String = "",
    var preco: Double = 0.0,
    var estoque: Int = 0){
}

fun main() {
    val produto1 = Produto("arroz", 8.50, 100)
    val produto2 = Produto("Feijao ", 7.00, 50)
    val produto3 = Produto("Macarrão", 4.50, 200)

    println("Produto: ${produto1.nome} | Preço: R$ ${"%.2f".format(produto1.preco)} | Estoque: ${produto1.estoque}")
    println("Produto: ${produto2.nome} | Preço: R$ ${"%.2f".format(produto2.preco)} | Estoque: ${produto2.estoque}")
    println("Produto: ${produto3.nome} | Preço: R$ ${"%.2f".format(produto3.preco)} | Estoque: ${produto3.estoque}")


}

