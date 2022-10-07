package Ejercicios;

import java.util.Scanner;

public class DLGCalculadora2 {
	
	final static int SUMA = 1;
	final static int RESTA = 2;
	final static int MULT = 3;
	final static int DIV = 4;
	final static int ABS = 5;
	final static int PI = 6;
	
	public static String calculo(int num1, int numsig, int num2) {
		
		String resultado = "";
		
		switch (numsig) {
			case SUMA: resultado = (num1+"+"+num2+" = "+Math.addExact(num1, num2)); break;
			case RESTA: resultado = (num1+"-"+num2+" = "+Math.subtractExact(num1, num2)); break;
			case MULT: resultado = (num1+"x"+num2+" = "+Math.multiplyExact(num1, num2)); break;
			case DIV: resultado = (num1+"/"+num2+" = "+Math.floorDiv(num1, num2)); break;
			case ABS: resultado = ("Valor absoluto de "+num1+" = "+Math.abs(num1)); break;
		}
		return resultado;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numsig = 0;
		do {
			System.out.println(
					"CALCULADORA\r\n"
					+ "1 –Sumar\r\n"
					+ "2 –Restar\r\n"
					+ "3 –Multiplicar\r\n"
					+ "4 –Dividir\r\n"
					+ "5 –Valor Absoluto\r\n"
					+ "6 –Mostrar PI\r\n"
					+ "Elige una opción:");
			numsig = sc.nextInt();
			String res = "";
				
			if (numsig < 1 || numsig > 6) {
				System.out.println("Inserte un numero valido.");
			}else if(numsig == 5){
				System.out.println("Inserte un numero: ");
				int num1 = sc.nextInt();
				
				res = calculo(num1,numsig,0);
				
			}else if(numsig == 6){
				res = ("El valor de PI es: "+Math.PI);
				
			}else {
				System.out.println("Inserte el primer numero: ");
				int num1 = sc.nextInt();
				
				System.out.println("Inserte el segundo numero: ");
				int num2 = sc.nextInt();
				
				res = calculo(num1,numsig,num2);
				
			}
			
			System.out.println(res);
		} while(numsig < 1 || numsig > 6);

		sc.close();

	}

}
