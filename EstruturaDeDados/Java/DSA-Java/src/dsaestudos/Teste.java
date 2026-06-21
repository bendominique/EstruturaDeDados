package dsaestudos;

public class Teste {
	public static void main(String[] args) {
		//preenchendo os arrays
		CreditCard carteira[] = new CreditCard[10];
		carteira[0] = new CreditCard("5391 0375 9387 5309", "Jhonny Test", "Bervely Hills", 0.0, 2000);
		carteira[1] = new CreditCard("5391 1375 7938 5093", "Miles Morales", "Brooklin", 0.0, 2100);
		carteira[2] = new CreditCard("5391 3335 9317 2219", "Pantera Negra", "Wakanda", 0.0, 8990);
	
		for(int i=1; i<=16; i++){
			carteira[0].chargeIt((double)i);
			carteira[1].chargeIt(2.0 * i); //cast implícito
			carteira[2].chargeIt((double)3*i); //cast explícito
		}
		for(int i=0; i<3; i++) {
			CreditCard.printCard(carteira[i]);
			while(carteira[i].getBalance() > 100.0) {
				carteira[i].makePayment(100.0);
				System.out.println("Novo valor = " + carteira[i].getBalance());
			}
		}
	}
}
