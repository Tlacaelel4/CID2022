package examples.multiplelinearregresion;

import examples.multiplelinearregresion.MatricialHelperAritmetic;

public class MLR {
    public double [][] calculateBetas(){
        DataSet data = new DataSet();
        MatricialHelperAritmetic helper = new MatricialHelperAritmetic();
      
        double [][] matrizX = data.getX();
        double [][] matrizY = data.getY();
        double [][] transpuesta = helper.transposed(matrizX);                  
       
        double [][] inversa = helper.inverse(helper.multiplication(transpuesta, matrizX));
        double [][] productoXtY = helper.multiplication(transpuesta, matrizY);
        double [][] productoInversaXtY = helper.multiplication(inversa, productoXtY);
        
        return productoInversaXtY;
    }

    public double [][] calculateBetasBenetton(){
        DataSet data = new DataSet();
        MatricialHelperAritmetic helper = new MatricialHelperAritmetic();

        double [][] matrizXBenetton = data.getXBenetton();
        double [][] matrizYBenetton = data.getYBenetton();
        double [][] transpuestaBenetton = helper.transposed(matrizXBenetton); 
       
        double [][] inversa = helper.inverse(helper.multiplication(transpuestaBenetton, matrizXBenetton));
        double [][] productoXtY = helper.multiplication(transpuestaBenetton, matrizYBenetton);
        double [][] productoInversaXtY = helper.multiplication(inversa, productoXtY);

        return productoInversaXtY;
    }
    
    public double pronosticate(double beta0, double beta1, double beta2, double x1, double x2){
        double pronostico = beta0 + beta1 * x1 + beta2 * x2;
        
        return pronostico;
    }
    
    public double pronosticateBenetton(double beta0, double beta1, double x){
        double pronostico = beta0 + beta1 * x;
        
        return pronostico;
    }
}