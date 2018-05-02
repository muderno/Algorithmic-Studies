/**
 * What is this here?
 */
package muderno.net.AlgorithmicStudies;

/**
 * @author Vinicius Barros
 *
 */
public class Transpose {

	private static int[][] originMatrix;

	public static void populateOriginMatrix(int lines, int columns) {
		int value = 0;
		if (lines <= 0 || columns <= 0)
			throw new IllegalArgumentException("Should have at least one column and line");
		originMatrix = new int[lines][columns];
		for (int j = 0; j < lines; j++) {
			for (int i = 0; i < columns; i++) {
				originMatrix[j][i] = ++value;
			}
		}

	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%2d", matrix[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}
	}

	/**
	 * This method receive a two-dimensional array and transpose it creating a new
	 * one.
	 * 
	 * @param matrix
	 *            is a two-dimensional int array that you want to transpose.
	 * @return an int two-dimensional array.
	 */
	public static int[][] transpose(int[][] matrix) {
		int[][] matrixAux = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrixAux[j][i] = matrix[i][j];
			}
		}
		return matrixAux;
	}

	public static void main(String[] args) {
		populateOriginMatrix(5, 5);
		printMatrix(originMatrix);
		System.out.println("=== transposing ===");
		printMatrix(transpose(originMatrix));
	}

}
