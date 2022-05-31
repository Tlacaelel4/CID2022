package examples.simplelinearregresion;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.simplelinearregresion.DataSet;
import examples.simplelinearregresion.AritmeticHelper;
import examples.simplelinearregresion.MySLR;

public class SLRAgent extends Agent {

  protected void setup() {    
    addBehaviour(new MySimpleLinearRegressionBehaviour());

  } 

  private class MySimpleLinearRegressionBehaviour extends Behaviour {    
    int cont = 0;
    public void action() {      
        MySLR obj = new MySLR();        
        DataSet data = new DataSet();
        AritmeticHelper ari = new AritmeticHelper();
    
        double beta0, beta1;    
        final int x = 60;    

        beta1 = obj.beta_uno(ari.productSummation(data.getN(), data.getSales(), data.getAdvertising()), ari.summation(data.getN(), data.getAdvertising()), ari.summation(data.getN(), data.getSales()), ari.squareSummation(data.getN(), data.getAdvertising()));
        beta0 = obj.beta_cero(data.getN(), ari.summation(data.getN(), data.getAdvertising()), ari.summation(data.getN(), data.getSales()), beta1);

        System.out.printf("Sales = %.3f + %.3f * %s\n", beta0, beta1, x);
        System.out.printf("Sales = %.3f\n", obj.calcular_y(x, beta1, beta0));
        cont += 1;
    }
    
    public boolean done(){
        if(cont == 1){
          return true;
        }
        else{
          return false;
        }
    }
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}