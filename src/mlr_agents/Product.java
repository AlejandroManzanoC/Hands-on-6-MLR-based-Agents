package mlr_agents;

public class Product {
    public Product() {
    }

    public double[][] Product(double[][] p1, double[][] p2) {
        int row1, row2, column1, column2;
        
        row1 = p1.length;
        column1 = p1[0].length;
        row2 = p2.length;
        column2 = p2[0].length;
        double[][] result = new double[row1][column2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1; k++) {
                    result[i][j] += p1[i][k] * p2[k][j];
                }
            }
        }

        return result;
    }
}