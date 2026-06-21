fun main() {

    var saldo = 150.0
    val senhaCorreta = 3589

    print("Digite seu nome: ")
    val nome = readln()

    println("Olá $nome, é um prazer ter você por aqui!")

    var opcao: Int

    do {
        println("\n===== MENU =====")
        println("1 - Saldo")
        println("2 - Extrato")
        println("3 - Saque")
        println("4 - Depósito")
        println("5 - Transferência")
        println("6 - Sair")
        print("Escolha uma opção: ")

        opcao = readln().toInt()

        when (opcao) {

            1 -> {
                if (pedirSenha(senhaCorreta)) {
                    println("Seu saldo é: R$ $saldo")
                }
            }

            2 -> {
                if (pedirSenha(senhaCorreta)) {
                    println("===== EXTRATO =====")
                    println("Depósito: +150")
                    println("Compra: -20")
                    println("Salário: +500")
                }
            }

            3 -> {
                if (pedirSenha(senhaCorreta)) {
                    print("Digite o valor do saque: ")
                    val saque = readln().toDouble()

                    if (saque <= 0 || saque > saldo) {
                        println("Operação não autorizada")
                    } else {
                        saldo -= saque
                        println("Saque realizado!")
                    }
                }
            }

            4 -> {
                print("Digite o valor do depósito: ")
                val deposito = readln().toDouble()

                if (deposito <= 0) {
                    println("Operação não autorizada")
                } else {
                    saldo += deposito
                    println("Depósito realizado!")
                }
            }

            5 -> {
                if (pedirSenha(senhaCorreta)) {

                    print("Digite o número da conta: ")
                    val conta = readln()

                    if (!conta.all { it.isDigit() }) {
                        println("Conta inválida!")
                    } else {

                        print("Digite o valor da transferência: ")
                        val valor = readln().toDouble()

                        if (valor <= 0 || valor > saldo) {
                            println("Operação não autorizada")
                        } else {
                            saldo -= valor
                            println("Transferência realizada!")
                        }
                    }
                }
            }

            6 -> {
                println("$nome, foi um prazer ter você por aqui!")
            }

            else -> {
                println("Por favor, informe um número entre 1 a 4")
            }
        }

    } while (opcao != 6)
}

// função simples de senha
fun pedirSenha(senhaCorreta: Int): Boolean {
    print("Digite a senha: ")
    val senha = readln().toInt()

    if (senha == senhaCorreta) {
        return true
    } else {
        println("Senha incorreta!")
        return pedirSenha(senhaCorreta)
    }
}