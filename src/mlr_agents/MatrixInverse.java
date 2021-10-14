package mlr_agents;

public class MatrixInverse {
    private final mlr_agents.MLRMethods MLRMethods;

    public MatrixInverse(mlr_agents.MLRMethods MLRMethods) {
        this.MLRMethods = MLRMethods;
    }

    public double[][] Inverse(double[][] mtrx) {
        double det = 1 / MLRMethods.getDeterminant().Determinant(mtrx);
        double[][] aux = MLRMethods.getAdjoint().Adjoint(mtrx);
        MLRMethods.Scalar(det, aux);

        return aux;
    }
}