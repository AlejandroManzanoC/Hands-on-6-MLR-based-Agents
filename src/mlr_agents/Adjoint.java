package mlr_agents;

public class Adjoint {
    private final MLRMethods MLRMethods;

    public Adjoint(MLRMethods MLRMethods) {
        this.MLRMethods = MLRMethods;
    }

    public double[][] Adjoint(double[][] mtrx) {
        return MLRMethods.Transpose(MLRMethods.Cofactors(mtrx));
    }
}