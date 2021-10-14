
package mlr_agents;

import java.util.Scanner;
import java.text.DecimalFormat;

public class MLRMethods extends MLR_agents{
    
    Scanner scan = new Scanner(System.in);
    
    
    private double[][] MtrxX;
    private double[][] MtrxY;
    private double[][] MtrxXTrans;
    
    private final Product product = new Product();
    private final MatrixInverse matrixInverse = new MatrixInverse(this);
    private final MatrixTranspose matrixTranspose = new MatrixTranspose();
    private final MatrixScalar matrixScalar = new MatrixScalar();

    public Adjoint getAdjoint() {
        return adjoint;
    }
    private final Adjoint adjoint = new Adjoint(this);

    private final Cofactors cofactors = new Cofactors(this);

    public Determinant getDeterminant() {
        return determinant;
    }
    private final Determinant determinant = new Determinant();

    
    
    public MLRMethods() {
        this.MtrxX= new double[][]{ {1,41.9,29.1},{1,43.4,29.3},{1,43.9,29.5},{1,44.5,29.7},{1,47.3,29.9},
                                    {1,47.5,30.3},{1,47.9,30.5},{1,50.2,30.7},{1,52.8,30.8},{1,53.2,30.9},
                                    {1,56.7,31.5},{1,57.0,31.7},{1,63.5,31.9},{1,65.3,32.0},{1,71.1,32.1},
                                    {1,77.0,32.5},{1,77.8,32.9} };
        
        this.MtrxY= new double[][]{ {251.3},{251.3},{248.3},{267.5},{273.0},{276.5},{270.3},{274.9},{285.0},{290.0},
                                    {297.0},{302.5},{304.5},{309.3},{321.7},{330.7},{349.0} };

        this.MtrxXTrans= new double[this.MtrxX[0].length][this.MtrxX.length];
        
        
    }
    
    public void MatrixOps() {
        double[][] ProductXTX, ProductXTY;
        this.MtrxXTrans= matrixTranspose.Transpose(this.MtrxX);
        
        ProductXTX= new double[this.MtrxXTrans.length][this.MtrxX[0].length];
        ProductXTX= product.Product(this.MtrxXTrans, this.MtrxX);
        
        ProductXTY= new double[this.MtrxXTrans.length][this.MtrxY[0].length];
        ProductXTY= product.Product(this.MtrxXTrans, this.MtrxY);
        
        double[][]inv= Inverse(ProductXTX);
        double[][]NormalEquationApproach= Product(inv, ProductXTY);
        
        Results(NormalEquationApproach);
    }

    public double[][] Product(double[][] p1, double[][] p2) {

        return product.Product(p1, p2);
    }

    public void Scalar(double Scalar, double[][] mtrx) {
        matrixScalar.Scalar(Scalar, mtrx);
    }

    public double[][] Transpose(double[][] mtrx) {

        return matrixTranspose.Transpose(mtrx);
    }

    public double[][] Inverse(double[][] mtrx) {

        return matrixInverse.Inverse(mtrx);
    }

    public double Determinant(double[][] mtrx) {

        return determinant.Determinant(mtrx);
    }

    public double[][] Cofactors(double[][] mtrx) {

        return cofactors.Cofactors(mtrx);
    }
    
    public double[][] Adjoint(double[][] mtrx) {
        return adjoint.Adjoint(mtrx);
    }
    
    public void Results(double[][] mtrx) {
        double x1, x2, y, b0=0.0, b1=0.0, b2=0.0, beta1=0.0, beta2=0.0;
        DecimalFormat numberFormat = new DecimalFormat("#.0000");
        
        System.out.print("Enter value of <x1>: \n");
        x1= scan.nextDouble();
        System.out.print("Enter value of <x2>: \n");
        x2= scan.nextDouble();
        
        System.out.print("Beta Coefficients:\n");
        
        for(double[] row : mtrx){
            
            for(double column : row){ 
                System.out.println(column+" ");
                
                if (column<0)
                    b0=column;
                else if (column>0 && column<10)
                    b1=column;
                else if(column>10)
                    b2=column;
                
                beta1=b1*x1;
                beta2=b2*x2;
                
            }
            
        System.out.print(" ");
        }
        
        y= b0+ beta1+ beta2;
        System.out.println("ÿ = "+numberFormat.format(b0)+" + "+numberFormat.format(b1)+"x1"+" + "+numberFormat.format(b2)+"x2");
        System.out.printf("%.4f", y);
        System.out.print("\n");
        
    }
    
    

}
