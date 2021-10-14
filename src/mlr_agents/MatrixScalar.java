package mlr_agents;

public class MatrixScalar {
    public MatrixScalar() {
    }

    public void Scalar(double Scalar, double[][] mtrx) {
        for (double[] mtrx1 : mtrx) {
            for (int j = 0; j < mtrx.length; j++) {
                mtrx1[j] *= Scalar;
            }
        }
    }
}