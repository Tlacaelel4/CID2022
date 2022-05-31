package examples.knn;

import examples.knn.HelperAritmetic;

public class Knn {
    public String calculateKnn(double [][] arrayX, double [][] arrayY, String [][] arrayZ, double entrada1, double entrada2, int k){
        HelperAritmetic knn = new HelperAritmetic();

        double distances[] = new double[arrayX.length];
        String categories[] = new String[distances.length];

        for (int i = 0; i < arrayX.length; i++) {
            distances[i] = knn.calculateDistance(arrayX[i][0], arrayY[i][0], entrada1, entrada2);
            categories[i] = arrayZ[i][0];
        }   
        
        for (int x = 0; x < distances.length; x++) {            
            for (int y = 0; y < distances.length - 1; y++) {
                double elementoActual = distances[y],
                        elementoSiguiente = distances[y + 1];

                String elementoActualS = categories[y],
                        elementoSiguienteS = categories[y + 1];

                if (elementoActual > elementoSiguiente) {                    
                    distances[y] = elementoSiguiente;
                    distances[y + 1] = elementoActual;
                    categories[y] = elementoSiguienteS;
                    categories[y + 1] = elementoActualS;
                }
            }
        }

        return knn.nearestNeighbor(categories, k);        
    }
}
