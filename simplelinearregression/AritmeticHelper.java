package examples.simplelinearregresion;

public class AritmeticHelper {
    public double summation(int n, int [] array){
        int x = 0;
        for (int i=0; i<n; i++){
            x = x + array[i];
        }
        return x;
    }
    
    public double squareSummation(int n, int [] array){
        int x = 0;
        for (int i=0; i<n; i++){
            x = x + (array[i] * array[i]);
        }
        x = x * n;
        
        return x;
    }
    
    public double productSummation(int n, int [] sales, int [] advertising){
        int x = 0;
        for (int i=0; i<n; i++){
            x = x + (sales[i] * advertising[i]);
        }
        x = x * n;
        
        return x;
    }
}
