import java.io.*;

public class CheckPoint {

	public static String lerString(String msg) throws java.io.IOException {
		DataInputStream din = new DataInputStream(System.in);
		System.out.print(msg);
		return din.readLine();
	}

	public static int capturaNro(char c) throws java.io.IOException {
		int n;
		int indicador = 1;
		for (int i = 0; i < 1; i++) {
			String s = lerString("Digite um numero: ");
			try {
				n = Integer.parseInt(s);
				System.out.println("Numero valido: " + n);
			} catch (NumberFormatException nfe) {
				// nfe.printStackTrace();
				System.out.println("Errado.");
				indicador = 2;
			}
		}
		System.out.println("Fim.");
		return indicador;
	}
}