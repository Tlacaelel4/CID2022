package examples.GradientDescent;

public class Gradient {
    public double calculateError(double [] betas, int [] sales, int [] advertising, int n){
        double error = 0.0;
        for(int i = 0; i < n; i++){
            error = error + (sales[i] - (betas[0] + (betas[1]*advertising[i])));
        }
        error = (error * error) * (1.0/n);
        return error;
    }

    public double [] recalculateBetasValues(double [] betas, int [] sales, int [] advertising, int n, double learningRate){
        double newBeta0 = 0.0;
        double newBeta1 = 0.0;

        for(int i = 0; i < n; i++){            
            newBeta0 = newBeta0 + (sales[i] - (betas[0] + (betas[1]*advertising[i])));
            newBeta1 = newBeta1 + ((sales[i] - (betas[0] + (betas[1]*advertising[i]))) * advertising[i]);
        }
        newBeta0 = newBeta0 * (-2.0/n);
        newBeta1 = newBeta1 * (-2.0/n);

        betas[0] = betas[0] - (learningRate * newBeta0);
        betas[1] = betas[1] - (learningRate * newBeta1);

        return betas;
    }

    public double [] minimazeError(double [] betas, int [] sales, int [] advertising, int n, double learningRate){
        double error = 1.0;
        double newBetas[] = betas;
        while(error > 0.0001){                        
            newBetas = recalculateBetasValues(newBetas, sales, advertising, n, learningRate);
            
            error = calculateError(newBetas, sales, advertising, n);            
        }

        return newBetas;
    } 

    public double pronosticate(double value, double beta0, double beta1){
        return beta0 + beta1 * value;
    }
}