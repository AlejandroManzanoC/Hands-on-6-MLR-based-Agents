package mlr_agents;

public class MatrixTranspose {
    public MatrixTranspose() {
    }

    public double[][] Transpose(double[][] mtrx) {
        int rows, columns;
        
        rows = mtrx.length;
        columns = mtrx[0].length;
        double[][] aux = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                aux[j][i] = mtrx[i][j];
            }
        }

        return aux;
    }
}