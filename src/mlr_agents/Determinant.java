package mlr_agents;

public class Determinant {
    public Determinant() {
    }

    public double Determinant(double[][] mtrx) {
        double det;
        
        if (mtrx.length == 2) {
            det = (mtrx[0][0] * mtrx[1][1]) - (mtrx[1][0] * mtrx[0][1]);
            return det;
        }
        double result = 0;
        for (int i = 0; i < mtrx.length; i++) {
            double[][] aux = new double[mtrx.length - 1][mtrx.length - 1];
            for (int j = 0; j < mtrx.length; j++) {
                if (j != i) {
                    for (int k = 1; k < mtrx.length; k++) {
                        int index = -1;
                        if (j < i)
                            index = j;
                        else if (j > i)
                            index = j-1;
                            aux[index][k-1] = mtrx[j][k];
                        
                    }
                }
            }
            if (i % 2 == 0)
                result += mtrx[i][0] * Determinant(aux);
            else
                result -= mtrx[i][0] * Determinant(aux);
        }

        return result;
    }
}