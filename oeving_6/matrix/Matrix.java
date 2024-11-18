package matrix;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Matrix {
    private double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public String toString() {
        return Arrays.deepToString(getMatrix());
    }

    public int rows() {
        return matrix.length;
    }

    public int columns() {
        return matrix[0].length;
    }

    public Matrix addMatrix(Matrix matrix) {
        double[][] m1 = getMatrix();
        double[][] m2 = matrix.getMatrix();

        if (rows() == matrix.rows() && columns() == matrix.columns()) {
            double[][] m3 = new double[rows()][columns()];

            for (int i = 0; i < rows(); i++) {
                for (int j = 0; j < columns(); j++) {
                    m3[i][j] = m1[i][j] + m2[i][j];
                }
            }
    
            return new Matrix(m3);
        }
        else return null;
    }

    public Matrix multiplyMatrix(Matrix matrix) {
        double[][] m1 = getMatrix();
        double[][] m2 = matrix.getMatrix();

        if (rows() == matrix.columns()) {
            double[][] m3 = new double[matrix.rows()][columns()];

            System.out.println(Arrays.deepToString(m1));
            System.out.println(Arrays.deepToString(m2));
            System.out.println(Arrays.deepToString(m3));

            for (int i = 0; i < matrix.rows(); i++) {
                for (int j = 0; j < columns(); j++) {
                    m3[i][j] = 0;
                    for (int k = 0; k < rows(); k++) {
                        m3[i][j] += m1[k][j] * m2[i][k];
                    }
                }
            }

            return new Matrix(m3);
        }
        else return null;
    }

    public Matrix transposeMatrix() {
        if (rows() > 0 && columns() > 0) {
            double[][] transpose = new double[columns()][rows()];

            for (int i = 0; i < columns(); i++) {
                for (int j = 0; j < rows(); j++) {
                    transpose[i][j] = getMatrix()[j][i];
                }
            }

            return new Matrix(transpose);
        }
        else return null;
    }

    static Scanner scanner = new Scanner(System.in);

    public static Matrix makeMatrix() {        
        boolean validDimensions = false;

        int rows = 2;
        int columns = 2;

        while (!validDimensions) {
            System.out.println("Dimensions of the matrix (rowsxcolumns):");
            String dimensions = scanner.nextLine();

            if (dimensions.length() == 3) {
                String[] dimensionsList = dimensions.split("");
                try {
                    rows = Integer.parseInt(dimensionsList[0]);
                    columns = Integer.parseInt(dimensionsList[2]);

                    if (rows > 0 && columns > 0) {
                        validDimensions = true;
                    }
                    else {
                        System.out.println("Rows and columns must be above 0");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Write dimensions in the form rowsxcolumns (e.g. 3x5)");
                }
            }
            else {
                System.out.println("Write dimensions in the form rowsxcolumns (e.g. 3x5)");
            }
        }

        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean validNumber = false;

                while (!validNumber) {
                    System.out.printf("Value at row %d column %d:", i, j);

                    try {
                        int number = scanner.nextInt();
                        matrix[i][j] = number;
                        validNumber = true;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Must be a valid number");
                    }
                }
            }
        }

        return new Matrix(matrix);
    }

    public static void menu() {

        while (true) {
            System.out.println("Pick an option");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose");
            System.out.println("4. Quit");

            try {
                int mode = scanner.nextInt();

                if (mode == 1) {
                    while (true) {
                        Matrix m1 = makeMatrix();
                        Matrix m2 = makeMatrix();

                        if (m1.rows() == m2.rows() && m1.columns() == m2.columns()) {
                            Matrix m3 = m1.addMatrix(m2);
                            System.out.printf("%s + %s = %s%n", m1.toString(), m2.toString(), m3.toString());
                            break;
                        }
                        else {
                            System.out.println("Can't add matrices that aren't the same size");
                        }
                    }

                }
                else if (mode == 2) {
                    while (true) {
                        Matrix m1 = makeMatrix();
                        Matrix m2 = makeMatrix();
    
                        if (m1.rows() == m2.columns()) {
                            Matrix m3 = m1.multiplyMatrix(m2);
                            System.out.printf("%s.%s = %s%n", m2.toString(), m1.toString(), m3.toString());
                            break;
                        }
                        else {
                            System.out.println("Can't add matrices that aren't the same size");
                        }
                    }
                }
                else if (mode == 3) {
                    Matrix m1 = makeMatrix();
                    Matrix m2 = m1.transposeMatrix();

                    System.out.printf("The transpose of %s is %s%n", m1.toString(), m2.toString());
                }
                else if (mode == 4) {
                    break;
                }
                else {
                    System.out.println("Enter a valid option");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Pick a valid option");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        menu();
        scanner.close();
    }
}
