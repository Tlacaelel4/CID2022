package examples.knn;

import java.util.*;

public class HelperAritmetic{    
    int[] rank = {0,0,0};    
    
    double calculateDistance(double a,double b, double x, double y){
        double distance = Math.sqrt((Math.pow((x-a),2) + Math.pow((y-b), 2)));
        return distance;
    }

    public String nearestNeighbor(String[] categories, int k){
        String higher;
        int i = 0;
        int pos = 0;
        while(i < k){
            for(;i < k; i++){
                switch(categories[i]){
                    case "Setosa":rank[0]++;
                    break;
    
                    case "Virginica":rank[1]++;
                    break;

                    case "Verscicolor":rank[2]++;
                    break;
                    default:System.out.println("error");
                    break;
                }                      
            }

            int repetido =0;
            int mayor = 0;
            pos = 0;

            for(int j=0; j<rank.length; j++){
                if(rank[j] > mayor){
                    mayor = rank[j];
                    pos = j;
                }
                else if(rank[j] == mayor){
                    repetido = j;
                }
            }

            if(repetido != pos && rank[repetido] == rank[pos])
                k++;
        }
        
        
        switch(pos){
            case 0: higher = "Setosa";
                break;
            case 1: higher = "Virginica";
                break;
            case 2: higher = "Verscicolor";
                break;
            default: higher = "error";
        }
        return higher;
    }
}