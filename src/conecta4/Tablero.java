package conecta4;

import java.util.Arrays;

public class Tablero {

	private char[][] tablero;
	public int[] donde;
	private char turno;
	private final int filas = 6;
	private final int columnas = 7;

	public Tablero() {

		turno = 'x';
		tablero = new char[filas][columnas];
		donde = new int[columnas];
		for (int i = 0; i < columnas; i++) {

			donde[i] = filas - 1;
		}
	}

	public void coloca(int columna) {

		if ((columna >= 0) & (columna < columnas)) {
			if (donde[columna] >= 0) {
				int fila = donde[columna];
				tablero[fila][columna] = turno;
				donde[columna]--;
				turno = (turno == 'x') ? 'o' : 'x';
			}
		}

	}
	
	public void ganador() {
		int contador = 0;
		boolean hayGanador = true;
		
		while(!hayGanador && contador!=4) {
			
			
			
		}
	}

	@Override
	public String toString() {
		String str_devolver = "";

		str_devolver += tablero.toString() + " ";

		return str_devolver;
	}

}
