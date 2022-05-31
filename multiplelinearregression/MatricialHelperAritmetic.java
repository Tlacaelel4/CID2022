package examples.multiplelinearregresion;

public class MatricialHelperAritmetic {
    public double [][] transposed(double [][] matriz){
      double matrizT[][] = new double [matriz[0].length][matriz.length];      

      for(int i=0; i<matriz.length; i++){
        for(int j=0; j<matriz[0].length; j++){
            matrizT[j][i] = matriz[i][j];
        }            
      }
      return matrizT;
    }
    //                                            Transpuesta            Oritinal
    public double [][] multiplication(double [][] matrizUno, double [][] matrizDos){        
        double matrizMult[][] = new double [matrizUno.length][matrizDos[0].length]; 
        
        if(matrizUno[0].length == matrizDos.length){
            for(int i=0; i<matrizUno.length; i++){
                for(int j=0; j<matrizDos[0].length; j++){
                    for(int k=0; k<matrizUno[0].length; k++){
                        matrizMult[i][j] += matrizUno[i][k] * matrizDos[k][j];
                    }                
                }            
            }
        }        
        
        return matrizMult;
    }
    
    public double [][] inverse(double [][] matriz){
        double matrizInversa[][] = new double [matriz.length][matriz[0].length];
        double pivote, aux;
        
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                matrizInversa[i][j] = 0;
                if(i == j){
                    matrizInversa[i][j] = 1;
                }                
            }
        }
        
        for(int i=0; i<matriz.length; i++){
            pivote = matriz[i][i];
            
            for(int k=0; k<matriz.length; k++){
                matriz[i][k] = matriz[i][k]/pivote;
                matrizInversa[i][k] = matrizInversa[i][k]/pivote;
            }
            
            for(int j=0; j<matriz.length; j++){
                if(i != j){
                    aux = matriz[j][i];
                    
                    for(int k=0; k<matriz.length; k++){
                        matriz[j][k] = matriz[j][k] - aux * matriz[i][k];
                        matrizInversa[j][k] = matrizInversa[j][k] - aux * matrizInversa[i][k];
                    }
                }
            }
        }
        
        return matrizInversa;                
    }

}