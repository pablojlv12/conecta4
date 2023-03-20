package conecta4;

public class Tablero {

	private char[][] tablero;
	public int[] donde;
	private char turno;
	private final int FILAS = 6;
	private final int COLUMNAS = 7;
	private boolean ganador;

	public Tablero() {

		ganador = false;
		turno = 'x';
		tablero = new char[FILAS][COLUMNAS];
		donde = new int[COLUMNAS];
		for (int i = 0; i < COLUMNAS; i++) {

			donde[i] = FILAS - 1;
		}
	}

	public void coloca(int columna) {

		if ((columna >= 0) & (columna < COLUMNAS)) {
			if (donde[columna] >= 0) {
				int fila = donde[columna];
				tablero[fila][columna] = turno;
				donde[columna]--;
				turno = (turno == 'x') ? 'o' : 'x';

				ganador = hayGanadorVertical(FILAS, COLUMNAS);
				ganador |= hayGanadorHorizontal(COLUMNAS, COLUMNAS);
				ganador |= hayGanadorDiagonalPrincipal(FILAS,COLUMNAS);
				ganador |= hayGanadorDiagonalSecundaria(FILAS,COLUMNAS);

			}
		}
	}

	private boolean hayGanadorVertical(int fila, int columna) {
		char mirarChar = tablero[fila][columna];
		int coincidencia = 0;
		boolean devolver = false;

		if (fila <= 2) {
			for (int i = fila + 1; i <= fila + 3; i++) {

				if (tablero[i][columna] == mirarChar) {

					coincidencia++;
				}
			}

			if (coincidencia == 4) {
				devolver = true;

			}
		}
		return devolver;
	}

	private boolean hayGanadorHorizontal(int fila, int columna) {

		char mirarChar = tablero[fila][columna];
		// mientras no encuentre 4 fichas iguales
		// mientras haya columnas

		int i = 0;
		int coincidencia = 0;
		while ((i < COLUMNAS) && (coincidencia < 4)) {
			// comparar con la ficha
			// contar las coincidencias

			if (tablero[fila][i] == mirarChar) {

				coincidencia++;
			} else
				coincidencia = 0;
			i++;
		}
		boolean devolver = true;
		if (coincidencia == 4) {
			devolver = true;
		}

		return devolver;
	}

	private boolean hayGanadorDiagonalPrincipal(int fila, int columna) {

		char mirarChar = tablero[fila][columna];
		int coincidencia = 0;
		
		while ((fila < FILAS) && (columna < COLUMNAS) && (coincidencia < 4)) {
			
			if (fila < columna) {

				fila = 0;
			} 
			else columna = 0;

			if (tablero[fila][columna] == mirarChar) {
				coincidencia++;

			}
            else coincidencia = 0;
			fila++;
            columna++;

		}
		boolean devolver = false;
		if (coincidencia == 4) {
			devolver = true;
		}
		return devolver;
	}
	
	private boolean hayGanadorDiagonalSecundaria(int fila, int columna) {

		char mirarChar = tablero[fila][columna];
		int coincidencia = 0;

		while ((fila < 0) && (columna < COLUMNAS-1) && (coincidencia < 4)) {
			
			if (fila < columna)	fila = FILAS;
			if(columna<fila) columna = 0;
			if(columna==fila) columna = 0; fila = 0;  

			if (tablero[fila][columna] == mirarChar) {
				coincidencia++;

			} 
			else coincidencia = 0;
			fila--;
			columna++;
		}
		boolean devolver = false;
		if (coincidencia == 4) {
			devolver = true;
		}
		return devolver;
	}
	
	
	public boolean hayGanador() {
		return ganador;
	}

	@Override
	public String toString() {

		String devolver = "";

		for (int i = 0; i < FILAS; i++) {

			for (int j = 0; j < COLUMNAS; j++) {

				devolver += tablero[i][j] + " ";
			}
			devolver += "\n";
		}
		for (int j = 0; j < COLUMNAS; j++) {

			devolver += "- ";
		}
		devolver += "\n";
		for (int j = 0; j < COLUMNAS; j++) {

			devolver += j + " ";
		}

		return devolver;
	}

}
