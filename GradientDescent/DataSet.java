package examples.GradientDescent;

public class DataSet{
    final int n = 9;

    public int[] getSales(){
        return new int[] {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
    }
    
    public int[] getAdvertising(){
        return new int[] {23, 26, 30, 34, 43, 48, 52, 57, 58};
    }
    
    public int getN(){
        return n;
    }
}