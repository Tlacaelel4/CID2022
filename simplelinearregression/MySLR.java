package examples.simplelinearregresion;

public class MySLR{
    double beta_1;
    double beta_0;

    public double beta_uno(double xiyi, double xi, double yi, double xi2){                 
        double aux = xiyi - xi * yi;
        double aux2 = xi2 - xi * xi;
        beta_1 = (aux / aux2);
        
        return beta_1;
    }
    
    public double beta_cero(int n, double xi, double yi, double beta1){
        beta_0 = (yi - beta1 * xi)/n;

        return beta_0;
    }
    
    public double calcular_y(int x, double beta1, double beta0){
        double result = x * beta1 + beta0;
        return result;
    }
  } 