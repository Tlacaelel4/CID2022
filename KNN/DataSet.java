package examples.knn;

public class DataSet {
    double x[][] = {
        { 5.3 },
        { 5.1 },
        { 7.2 },
        { 5.4 },
        { 5.1 },
        { 5.4 },
        { 7.4 },
        { 6.1 },
        { 7.3 },
        { 6.0 },
        { 5.8 },
        { 6.3 },
        { 5.1 },
        { 6.3 },
        { 5.5 },
};

double y[][] = {
    { 3.7 },
    { 3.8 },
    { 3.0 },
    { 3.4 },
    { 3.3 },
    { 3.9 },
    { 2.8 },
    { 2.8 },
    { 2.9 },
    { 2.7 },
    { 2.8 },
    { 2.3 },
    { 2.5 },
    { 2.5 },
    { 2.4 },
};

String z[][] = {
    {"Setosa"},
    {"Setosa"},
    {"Virginica"},
    {"Setosa"},
    {"Setosa"},
    {"Setosa"},
    {"Virginica"},
    {"Verscicolor"},
    {"Virginica"},
    {"Verscicolor"},
    {"Virginica"},
    {"Verscicolor"},
    {"Verscicolor"},
    {"Verscicolor"},
    {"Verscicolor"},
};

    public double[][] getX(){
        return x;
    };

    public double[][] getY(){
        return y;
    };

    public String[][] getZ(){
        return z;
    };
}
