package application;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Table {
	/*
	 * 1 es bomba, 0 es sin nada
	 */
	public int[][] table;
	/*
	 * 0 oculto, 1 abierto y 2 marcado como bomba
	 */
	public int[][] state;
	/*
	 * numero de bombas de 0 a 8
	 */
	public int[][] bombNear;
	
	public Table(int tam,int prob) {
		table = new int[tam][tam];
		state = new int[tam][tam];
		bombNear = new int[tam][tam];
		int valorEntero;
		
		for(int i = 0; i<tam;i++) {
			for(int j = 0; j<tam;j++) {
				valorEntero = (int) (Math.random()*(prob-0+1)+0);
				if(valorEntero == 0) {
					table[i][j] = 1;
					for(int fila = i-1;fila<=i+1;fila++) {
						for(int col = j-1;col<=j+1;col++) {
							if(fila>=0 && fila < tam && col >= 0 && col < tam) {
								bombNear[fila][col]+=1;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0;i<tam;i++) {
			for(int j = 0;j<tam;j++) {
				System.out.print(table[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("\n");
		
		for(int i = 0;i<tam;i++) {
			for(int j = 0;j<tam;j++) {
				System.out.print(bombNear[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
