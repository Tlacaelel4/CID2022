package examples.multiplelinearregresion;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.multiplelinearregresion.DataSet;
import examples.multiplelinearregresion.MatricialHelperAritmetic;
import examples.multiplelinearregresion.MLR;


public class MLRAgent extends Agent {

  protected void setup() {    
    addBehaviour(new MyMultipleLinearRegressionBehaviour());

  }

  private class MyMultipleLinearRegressionBehaviour extends Behaviour {    
    int cont = 0;
    public void action() {
      MLR obj = new MLR();
      double [][] betas = obj.calculateBetas();
      double beta0 = betas[0][0];
      double beta1 = betas[1][0];
      double beta2 = betas[2][0];
      final double x1 = 82.5;
      final double x2 = 31.2;      

      System.out.printf("Pronostico: %.4f + %.4f * %.1f + %.4f * %.1f\n", beta0, beta1, x1, beta2, x2);        
      System.out.printf("Resultado: %.6f", obj.pronosticate(beta0, beta1, beta2, x1, x2));

      double [][] betasBenetton = obj.calculateBetasBenetton();
      double beta0B = betasBenetton[0][0];
      double beta1B = betasBenetton[1][0];
      final double x = 70;

      System.out.printf("\n\nPronostico: %.4f + %.4f * %.1f\n", beta0B, beta1B, x);        
      System.out.printf("Resultado: %.6f", obj.pronosticateBenetton(beta0B, beta1B, x));

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