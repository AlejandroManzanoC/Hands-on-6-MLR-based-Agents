package mlr_agents;

public class Cofactors {
    private final mlr_agents.MLRMethods MLRMethods;

    public Cofactors(mlr_agents.MLRMethods MLRMethods) {
        this.MLRMethods = MLRMethods;
    }

    public double[][] Cofactors(double[][] mtrx) {
        double[][] cofactors = new double[mtrx.length][mtrx.length];

        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx.length; j++) {
                double[][] aux = new double[mtrx.length - 1][mtrx.length - 1];
                double element;
                for (int k=0; k<mtrx.length; k++) {
                    if (k != i) {
                        for (int l=0; l<mtrx.length; l++) {
                            if (l != j) {
                                int index1 = k < i ? k : k - 1;
                                int index2 = l < j ? l : l - 1;
                                aux[index1][index2] = mtrx[k][l];
                            }
                        }
                    }
                }
                element= MLRMethods.getDeterminant().Determinant(aux);
                cofactors[i][j]= element*(double) Math.pow(-1, i+j+2);
            }
        }
        return cofactors;
    }
}