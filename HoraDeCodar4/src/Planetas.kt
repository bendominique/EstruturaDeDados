fun main() {
    var listaPlanetas = listOf("Terra", "Marte", "Plutão", "Vênus", "Júpiter", "Saturno")
    println("Escreva o nome de um planeta: ")
    val planetaEntrada = readln().toString()
    if(planetaEntrada in listaPlanetas){
        println("O planeta: " + planetaEntrada + " está na lista de planetas!")
    }else{
        print("O planeta: "+ planetaEntrada + " não está na lista de planetas")
    }
}
/*
2 - Planetas
Crie uma array de planetas que inclua "Terra", "Marte", "Plutão", "Vênus", "Júpiter", "Saturno"
 e, em seguida, peça ao usuário para digitar o nome de um planeta.
Verifique se o planeta que o usuário informou está na array e informe ao usuário.

 */
