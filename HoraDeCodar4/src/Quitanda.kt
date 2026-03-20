fun main() {

    val frutas = mutableListOf("Maçã", "Banana", "Laranja", "Abacaxi", "Uva")

    while (frutas.isNotEmpty()) {

        println("Frutas disponíveis: $frutas")

        print("Digite o nome de uma fruta para remover: ")

        val fruta_usuario = readln().trim()

        if (frutas.remove(fruta_usuario)) {

            println("Fruta removida!")

        } else {

            println("Fruta indisponível no nosso mercado.")

        }
        println("Lista de compras finalizadas!")
    }
}

