package dsaestudos;

public class CreditCard {
	//Primeiro instânciamos as variáveis
	private String number;
	private String name;
	private String bank;
	private double balance;
	private int limit;
	
	//construtores
	CreditCard(String nbr, String nm, String bk, double bl, int lm){
		number = nbr;
		name = nm;
		bank =  bk;
		balance = bl;
		limit = lm;
		//o padrão this não está sendo utilizado pois não existe nenhuma ambiguidade entre as variáveis que estão
		//nos parâmetros do construtor em relação aos atributos da classe.
	}
	//métodos de acesso, mantendo a segurança para o código fonte, com isso independente de onde seja utilizado só é possível acessar 
	// as propriedades dessa classe sem que seja possível altera-lá
	public String getNumber() {return number;}
	public String getName() {return name;}
	public String getBank() {return bank;}
	public double getBalance () {return balance;}
	public int getLimit() {return limit ;}
	//métodos de ação
	public boolean chargeIt(double price) {
		if (price + balance > (double)limit) { //um casting foi realizado para que o valor de limit pudesse ser transformado em um double, o que seria impossível sem que o casting fosse realizado, pois limit se trata de um inteiro em seu atributo orignal
			return false;
		}

		balance += price;
		return true;
		
		}
	public void makePayment(double payment) {
		if (balance >= payment) {
		    balance -= payment;				
		} else {
			System.out.println("Não é possível realizar o pagamento, saldo insuficiente.");
		}
	}
	
	public static void printCard(CreditCard c) { //mostrando as informações do cartão
		System.out.println("Número = " + c.getNumber());
		System.out.println("Nome = " + c.getName());
		System.out.println("Banco =" + c.getBank());
		System.out.println("Saldo =" + c.getBalance());
		System.out.println("Limite =" + c.getLimit());
	}
	

}
