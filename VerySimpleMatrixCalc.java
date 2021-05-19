import java.util.Scanner;

public class VerySimpleMatrixCalc {
    private static Scanner scanner = new Scanner(System.in);
    private static double[][] result;

    /**
     * method addMatrix() performs sum of two matrices.
     */

    public static void addMatrix() {
        double[][] matrixOne = floatMatrix("first");
        double[][] matrixTwo = floatMatrix("second");
        matrixSum(matrixOne, matrixTwo);
    }

    /**
     * method multiByConst performs multiplication matrix by constant.
     */

    public static void multiByConst() {
        double[][] matrix = floatMatrix("");
        System.out.print("Enter constant:");
        double constant = Double.parseDouble(scanner.nextLine());
        simpleMultiply(matrix, constant);
    }

    /**
     * method multiMatrix() performs multiplication of two matrices.
     */

    public static void multiMatrix() {
        double[][] matrixOne = floatMatrix("first");
        double[][] matrixTwo = floatMatrix("second");
        matrixMultiplication(matrixOne, matrixTwo);
    }

    /**
     * method floatMatrix() create matrix of custom size and returns it.
     * @param order
     * @return
     */

    public static double[][] floatMatrix(String order) {
        System.out.print(String.format("Enter size of %s matrix: ", order));
        String dimension = scanner.nextLine();
        String[] rowElements = dimension.split("\\s");
        double[][] matrix = new double[Integer.parseInt(rowElements[0])][Integer.parseInt(rowElements[1])];
        System.out.println(String.format("Enter %s matrix:", order));
        for(int i = 0; i < Integer.parseInt(rowElements[0]); i++) {
            String rowLine = scanner.nextLine();
            String[] columnsElements = rowLine.split("\\s");
            for(int j = 0; j < columnsElements.length; j++) {
                matrix[i][j] = Double.parseDouble(columnsElements[j]);
            }
        }
        return matrix;
    }

    /**
     * method matrixSum() implements the mechanism of matrix summation.
     * @param arrayOne
     * @param arrayTwo
     */

    public static void matrixSum(double[][] arrayOne, double[][] arrayTwo) {
        if(arrayOne.length != arrayTwo.length || arrayOne[0].length != arrayTwo[0].length) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println("The result is:");
            result = new double[arrayOne.length][arrayOne[0].length];
            for(int y = 0; y < arrayOne.length; y++) {
                for(int x = 0; x < arrayOne[y].length; x++) {
                    result[y][x] = arrayOne[y][x] + arrayTwo[y][x];
                    System.out.print(result[y][x] + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * method matrixMultiplication() implements the mechanism of matrix multiplication.
     * @param matrix1
     * @param matrix2
     */

    public static void matrixMultiplication(double[][] matrix1, double[][] matrix2) {
        if(matrix1[0].length != matrix2.length) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println("The result is:");
            result = new double[matrix1.length][matrix2[0].length];
            for(int y = 0; y < matrix1.length; y++) {
                for(int x = 0; x < matrix2[0].length; x++) {
                    for(int z = 0; z < matrix1[0].length; z++) {
                        result[y][x] += matrix1[y][z] * matrix2[z][x];
                    }
                }
            }
            for(int y = 0; y < result.length; y++) {
                for(int x = 0; x < result[0].length; x++) {
                    System.out.print(result[y][x] + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * method simpleMultiply() implements the mechanism of simple multiplication matrix by constant.
     * @param array
     * @param constant
     */

    public static void simpleMultiply(double[][] array, double constant) {
        System.out.println("The result is:");
        double[][] result = new double[array.length][array[0].length];
        for(int y = 0; y < array.length; y++) {
            for(int x = 0; x < array[0].length; x++) {
                result[y][x] = array[y][x] * constant;
                System.out.print(result[y][x] + " ");
            }
            System.out.println();
        }
    }

    /**
     * method transposeMainDiagonal() implements the mechanism which allows to transpose matrix by its main diagonal.
     * @param matrix
     */

    public static void transposeMainDiagonal(double[][] matrix) {
        System.out.println("The result is: ");
        double[][] matrixT = new double[matrix[0].length][matrix.length];
        for(int y = 0; y < matrixT.length; y++) {
            for(int x = 0; x < matrixT[0].length; x++) {
                matrixT[y][x] = matrix[x][y];
                System.out.print(matrixT[y][x] + " ");
            }
            System.out.println();
        }
    }

    /**
     * method mainD() transpose matrix by its main diagonal.
     */

    public static void mainD() {
        double[][] matrix = floatMatrix("");
        transposeMainDiagonal(matrix);

    }

    /**
     * method transposeSideDiagonal() implements the mechanism which allows to transpose matrix by its side diagonal.
     * @param matrix
     */

    public static void transposeSideDiagonal(double[][] matrix) {
        System.out.println("The result is: ");
        double[][] matrixT = new double[matrix[0].length][matrix.length];
        for(int y = 0; y < matrixT.length; y++) {
            for (int x = 0; x < matrixT[0].length; x++) {
                matrixT[y][x] = matrix[matrixT[0].length - 1 - x][matrixT.length - 1 - y];
                System.out.print(matrixT[y][x] + " ");
            }
            System.out.println();
        }
    }

    /**
     * method sideD() transpose matrix by its side diagonal.
     */

    public static void sideD() {
        double[][] matrix = floatMatrix("");
        transposeSideDiagonal(matrix);
    }

    /**
     * method transposeByVertical() implements the mechanism which allows to transpose matrix by vertical.
     * @param matrix
     */

    public static void transposeByVertical(double[][] matrix) {
        System.out.println("The result is: ");
        double[][] matrixT = new double[matrix.length][matrix[0].length];
        for(int y = 0; y < matrixT.length; y++) {
            for(int x = 0; x < matrixT[0].length; x++) {
                matrixT[y][x] = matrix[y][matrixT[0].length - 1 - x];
                System.out.print(matrixT[y][x] + " ");
            }
            System.out.println();
        }
    }

    /**
     * method vertical() transpose matrix by vertical.
     */

    public static void vertical() {
        double[][] matrix = floatMatrix("");
        transposeByVertical(matrix);
    }

    /**
     * method transposeByHorizontal() implements the mechanism which allows to transpose matrix by horizontal.
     * @param matrix
     */

    public static void transposeByHorizontal(double[][] matrix) {
        System.out.println("The result is: ");
        double[][] matrixT = new double[matrix.length][matrix[0].length];
        for(int y = 0; y < matrixT.length; y++) {
            for (int x = 0; x < matrixT[0].length; x++) {
                matrixT[y][x] = matrix[matrix.length - 1 - y][x];
                System.out.print(matrixT[y][x] + " ");
            }
            System.out.println();
        }
    }

    /**
     * method horizontal() transpose matrix by horizontal.
     */

    public static void horizontal() {
        double[][] matrix = floatMatrix("");
        transposeByHorizontal(matrix);
    }

    /**
     * method transposeAction() performs result of choice of transpose type.
     * @param option
     */

    public static void transposeAction(String option) {
        switch(option) {
            case "1":
                mainD();
                break;
            case "2":
                sideD();
                break;
            case "3":
                vertical();
                break;
            case "4":
                horizontal();
                break;
        }
    }

    /**
     * method transpose() allows to choose preferable type of transpose.
     */
    public static void transpose() {
        String choice;
        System.out.println("1. Main diagonal" + '\n' + "2. Side diagonal" + '\n' + "3. Vertical line" + '\n' +
                "4. Horizontal line");
        System.out.print("Your choice: ");
        choice = scanner.nextLine();
        transposeAction(choice);
    }

    /**
     * method action() performs result of choice of action with matrix.
     * @param option
     */

    public static void action(String option) {
        switch(option) {
            case "1":
                addMatrix();
                break;
            case "2":
                multiByConst();
                break;
            case "3":
                multiMatrix();
                break;
            case "4":
                transpose();
        }
    }

    /**
     * method menu() allows to choose preferable type of action with matrix.
     */

    public static void menu() {
        String choice;
        do {
            System.out.println("1. Add matrices" + '\n' + "2. Multiply matrix by a constant" + '\n' +
                    "3. Multiply matrices" + '\n' + "4. Transpose matrix" + '\n' + "0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextLine();
            action(choice);
        } while(!choice.equals("0"));
    }

    public static void main(String[] args) {
        menu();
    }
}
