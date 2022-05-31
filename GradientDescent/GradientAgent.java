package examples.GradientDescent;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.GradientDescent.Gradient;

public class GradientAgent extends Agent {

  protected void setup() {    
    addBehaviour(new MyGradientDescentBehaviour());

  } 

  private class MyGradientDescentBehaviour extends Behaviour {    
    int cont = 0;
    public void action() {      
        Gradient obj = new Gradient();        
        DataSet data = new DataSet();
        double startBetas[] = {0.0, 0.0};
        final int x = 80;
        final double learningRate = 0.0005;
        
        System.out.println("Inicio");
        double betas[] = obj.minimazeError(startBetas, data.getSales(), data.getAdvertising(), data.getN(), learningRate);       
        
        System.out.println("Finalizo");
        System.out.println(betas[0] + " + " + betas[1] + " * " + x);
        double result = obj.pronosticate(x, betas[0], betas[1]);
        System.out.println("Resultado del pronostico: " + result);            
        
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