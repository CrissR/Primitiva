package controlador;

import java.util.Scanner;

import modelo.BoletoPrimitiva;

public class Principal {

	public static void main(String[] args) {
		BoletoPrimitiva combinacionCris=null;
			
		//int[] ganadora={1,2,3,4,5,6};//o crear un nuevo boleto de 6 --->
		Scanner teclado=new Scanner(System.in);
				int aciertos;
				int numeroApuesta;
				String modo;
				
		//Genera boleto Cliente		
				System.out.println("¿De cuántos números quieres la apuesta?");
				numeroApuesta= teclado.nextInt();
				System.out.println("¿Cómo quieres el boleto [manual/automatico]?" );
				modo=teclado.next();
				//hay que mandalro al modelo para alli ya preguntar a que tipo de generador de boleto va
				if(modo.equalsIgnoreCase("AUTOMATICO"))
					combinacionCris=new BoletoPrimitiva(numeroApuesta, "AUTOMATICO");
				else
					combinacionCris=new BoletoPrimitiva(numeroApuesta, "MANUAL");	
				
		//boleto Ganador: Automático
				BoletoPrimitiva combinacionGanadora=new BoletoPrimitiva(6, "AUTOMATICO");		
				
		
			
				combinacionCris.imprimirCombinacion();
				System.out.println();
				combinacionGanadora.imprimirCombinacion();

				aciertos=combinacionCris.getAciertos(combinacionGanadora.getCombinacion());			//se pone el .getCombinacion para arreglar el get Aciertos
					
				System.out.println();

				System.out.println("Numeros de aciertos: "+aciertos);

	}

}
