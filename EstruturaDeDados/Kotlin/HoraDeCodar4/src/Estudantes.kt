enum class EnsinoAluno(val descricao: String){
    ENSINO_MEDIO("Ensino Médio"),
    ENSINO_FUNDAMENTAL("Ensino Fundamental")
}

data class Aluno(
    val nomeAluno: String,
    val ensinoAluno: EnsinoAluno,
    val serieAluno: Int,
    val turmaAluno: Char
)

var menuAtivo = true

val listaDeAlunos = mutableListOf<Aluno>()

fun main(){

    println("=================================================================================================================================================================================================")
    println("=================================================================================================================================================================================================")
    println("                                                                     SEJA BEM VINDO A E.M.E.F MENINOS DO SÃO PEDRO                                                                                     ")
    println("=================================================================================================================================================================================================")
    println("=================================================================================================================================================================================================")
    while(menuAtivo){

        println("1.Cadastrar Aluno 2.Remover Aluno 3.Listar Alunos 4.Sair")
        val opcaoUsuario = readln().toInt()
        when(opcaoUsuario){
            1 -> cadastrarAluno()
            2 -> removerAluno()
            3 -> exibirAlunos()
            4 -> sairPrograma()
        }
    }
}

fun visitarSala(){

}
//cadastrarAluno(), est un promesse de retourner la class Aluno, je te donne un objet de type Aluno, mais tu vas pas creér une chose, je jusque a passer mon parametre de construction
fun cadastrarAluno() : Aluno? {

    println("Digite o nome do aluno: ")
    val nome = readln().toString()
    println("Digite a série do aluno: ")
    var serie = readln().toInt()
    println("Digite a turma do aluno: EX 'A, B, C OU D'") //Quand je passe le point d'interrogation (?), je oblige de passer un valeur par default
    //avec ?: nous dison au program qui si un valeur pour le classé est pas passe, il vas adopter la classe A.
    val turma = readln().firstOrNull() ?: 'A'
    val ensino = if(serie <= 9) EnsinoAluno.ENSINO_FUNDAMENTAL else EnsinoAluno.ENSINO_MEDIO
    while(serie <= 0 || serie >= 14){
        println("Por favor digite uma série válida. 1-9 Fundamental e 10-13 Médio")
        serie = readln().toInt()
    }

    //creation de notre objet éleve, c'est ça que acess le dataClass Aluno, et tous les paramatres qui ai éte creér dans fonctionalite cadastrarAluno() seront ajoute a dataClass Aluno
    val novoAluno = Aluno(
        nomeAluno = nome,
        ensinoAluno = ensino,
        serieAluno = serie,
        turmaAluno = turma

    )
    listaDeAlunos.add(novoAluno)
    return novoAluno
}

fun exibirAlunos() {
    var buscandoAluno = true

    while(buscandoAluno) {
        println("Qual é a série que deseja buscar? EX: 1-13")
        var serieDesejada = readln().toIntOrNull()
        while(serieDesejada !in 1..13 || serieDesejada == null){ //si le serie est different de 1-13
            println("Por favor, digite uma série entre 1 e 13.")
            serieDesejada = readln().toIntOrNull()
        }
        println("De qual sala deseja exibir a Lista de Alunos? EX 'A, B, C, D'")
        val salaDesejada = readln().firstOrNull() ?: 'B' //Si le classe est vide, il va redirectionner a B
        println("                   ------------ LISTA DE ALUNOS $serieDesejada° - $salaDesejada ------------                               ")

        var encontrouAluno = false //nous avons fait cette logique boolean pour afficher l'éleve trouve, nous parle ça comme un drapeau
        //nous commencent avec false pourquoi nous ne savons pas si a un éleve
        for (aluno in listaDeAlunos) {
            if (aluno.turmaAluno == salaDesejada && aluno.serieAluno == serieDesejada ){
                println("-${aluno.nomeAluno}")
                encontrouAluno = true
            }
        }

        if(!encontrouAluno){ //! avec if == pas trouvér
            //mainteinant si nous a pas trouvér un éleve vais parle que cette classe est vidé
            println("Me desculpe, essa sala está vazia. Pressione qualquer outra tecla para buscar outra sala ou 9 para voltar ao menu principal")
            val escolha = readln().toInt()
            if(escolha == 9){
                buscandoAluno = false
            }else {
                println("Continuando busca...")
            }

        }
    }

}

fun removerAluno(){
    println("Digite a série do aluno: ")
    val serieDesejada = readln().toIntOrNull()
    println("Digite a sala do aluno: ")
    val salaDesejada = readln().firstOrNull()
    println("Digite o nome do aluno que deseja remover: ")
    val removerAluno = readln().trim()

    var alunoRemovido = listaDeAlunos.removeIf { aluno ->
        aluno.nomeAluno.equals(removerAluno, ignoreCase = true) &&
                aluno.serieAluno == serieDesejada &&
                aluno.turmaAluno == salaDesejada
    }

    if (alunoRemovido) {
        println("O aluno $removerAluno foi removido com sucesso!")
    } else println("Não encontramos o aluno $removerAluno no $serieDesejada º $salaDesejada")

}

fun sairPrograma(){
    println("Muito obrigado por usar. Até a próxima!\n")
    println(" I Love You!       I Love You!       I Love You!       I Love You!\n" +
            " You          I Love You         I Love You         I Love You         I\n" +
            "Y,d88b.d88b,I Love ,d88b.d88b, I Love,d88b.d88b,u I Lov,d88b.d88b,ou I Lo\n" +
            "L88888888888 You I 88888888888e You I88888888888ve You 88888888888ove You\n" +
            "u`Y8888888Y'Love Yo`Y8888888Y' Love Y`Y8888888Y'I Love `Y8888888Y' I Love\n" +
            "e I`Y888Y'You I Love `Y888Y' You I Love`Y888Y'e You I Lov`Y888Y've You I\n" +
            "I Lov`Y'I Love You I Lo`Y' I Love You I L`Y'u I Love You I `Y'ou I Love Y\n" +
            "    I Love You         I Love You         I Love You         I Love You\n" +
            " You          I Love You         I Love You         I Love You         I\n")
    menuAtivo = false
}


/*
1 - Estudantes.
Crie um programa onde o usuário possa cadastrar estudantes sem limites, e, em seguida,
 Se o usuário digitar "PARE" o programa deve exibir a quantidade de estudantes cadastrados e a lista com cada um deles.


 */