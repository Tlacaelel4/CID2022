package examples.knn;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.knn.DataSet;
import examples.knn.HelperAritmetic;
import examples.knn.Knn;


public class KnnAgent extends Agent {

  protected void setup() {    
    addBehaviour(new MyKnnBehaviour());

  }

  private class MyKnnBehaviour extends Behaviour {    
    int cont = 0;
    public void action() {
        DataSet data = new DataSet();
        Knn obj = new Knn();

        
        System.out.println(obj.calculateKnn(data.getX(), data.getY(), data.getZ(), 5.2, 3.1, 10));
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