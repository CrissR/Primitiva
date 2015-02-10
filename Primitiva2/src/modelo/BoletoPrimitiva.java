package modelo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BoletoPrimitiva {
	
/****************************************MODO DE APUESTA*************************************************/	
	private int[] combinacion;
																	//el String modo es lo que varia en la forma de hacer el boleto
	public BoletoPrimitiva(int numeroApuestas,String modo){			//Son los únicos que se pueden llamar igual que la clase. lo del paréntesis es un parámentro. lo de arriva es una variable de instancia SE LLAMA SIGNATURA
		
		if(modo.equals("AUTOMATICO"))
			generarBoletoAutomatico(numeroApuestas);
		else
			generarBoletoManual(numeroApuestas);
	}
/*********************************HACE EL BOLETO AUTOMATICAMENTE*******************************************************/
	private void generarBoletoAutomatico(int numeroApuestas){		//private porq no se llamara desde fuera
		combinacion=new int [numeroApuestas];
		for(int i=0;i<combinacion.length;i++)
			combinacion[i]=0; 										//es para asegurarse. aunque lo pone a 0 automaticamente
		Random aleatorio=new Random();
		int contadorApuestas=0;										//Es para hacer el contador
		while(contadorApuestas<numeroApuestas){						//si el numero aleatorio no ha salido lo guardo(para lo que usamos un método=haSalido
			int numeroAleatorio=aleatorio.nextInt(49)+1;
			if(!haSalido(numeroAleatorio)){
				combinacion[contadorApuestas]=numeroAleatorio;
				contadorApuestas++;
			}
		}
	}
/*******************************************HACE EL BOLETO MANUAL*******************************************************/
	public void generarBoletoManual(int numeroApuestas){
		
		combinacion=new int[numeroApuestas];
		for(int i=0;i<combinacion.length;i++)
			combinacion[i]=0;
		int contadorApuestas=0;
		int numero;
		Scanner teclado=new Scanner(System.in);
		
		while(contadorApuestas<numeroApuestas){
			System.out.println("Le quedan "+ (numeroApuestas-contadorApuestas)+" que escribir:");		//i----contadorApuestas
			boolean numeroValido=false;
			do{
				numero=teclado.nextInt();
				if(numero>=1 && numero<=49)
					numeroValido=true;
				else
					System.out.println("El numero no está entre el 1 y 49");
				
			}while(!numeroValido);
				if(!haSalido(numero)){
					combinacion[contadorApuestas]=numero;
					contadorApuestas++;
			}
				else{
					System.out.println("ese num ya ha salido");
				}
		}		
	}
/*********************************METODO QUE COMPRUEBA SI EL NUMERO ESTA REPETIDO********************************************/
			
	public boolean haSalido(int numero){							//boolean para que te diga si si o no esta
		boolean encontrado=false;									//se pone al contrario de lo qu buscas
		int i=0;											
		while(i<combinacion.length&&!encontrado){
			if(combinacion[i]==numero)
				encontrado=true;
			i++;
		}
		return encontrado;											//este metodo lo usamos arrba
	}
/*******************LOS GETTS  Y SETS (COMBINACION,xq es la única variable de instacia que tenemos)*************************/
	public int[] getCombinacion() {
		return combinacion;
	}
	public void setCombinacion(int[] combinacion) {
		this.combinacion = combinacion;
	}
	
/*********************************************IMPRIME EL BOLETO*************************************************************/
	public void imprimirCombinacion(){
		Arrays.sort(combinacion);
		for (int i=0;i<combinacion.length;i++){
			System.out.print(combinacion[i]+"-");					//luego se va a ver en el depurador
		}
	}
/******************************************COMPROBACION DE BOLETO GANADOR***********************************************************/
	public int getAciertos(int[]combinacionGanadora){		//Este método para trabajar necesita la combinacion ganadora (entre los paréntesis y l uego se le dara el valor)
			
		int aciertos=0;
		for(int i=0;i<combinacionGanadora.length;i++){		//se mira la ganadora par saber si esta en la anterior, ya que la combinacion creada ya tenia un método
			if(haSalido(combinacionGanadora[i])){
				aciertos++;
			}
		}
		return aciertos;	
	}
}	




