/*
 *  Alejandro A. Manzano Carcamo.
    07/10/21
    Simple Linear Regression
 */

package mlr_agents;


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;


public class MLR_agents extends Agent {
    
    @Override
    protected void setup(){
        
        System.out.println("Active Agent: "+getLocalName());
        
        
        addBehaviour(new OneShotDataAgent() );
        //addBehaviour(new OneShotDataAgent2() );
        //addBehaviour(new OneShotDataAgent3() );
    }
    
    private class OneShotDataAgent extends OneShotBehaviour {
        @Override
        public void action(){
            MLRMethods mlr = new MLRMethods();
            mlr.MatrixOps();
            System.out.println("\n"+getLocalName()+" executed its task.");
        }
        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
        
    }
    
    /*private class OneShotDataAgent2 extends OneShotBehaviour {
        @Override
        public void action(){
            MLRDataAgents mlr = new MLRDataAgents();
            mlr.MatrixOps();
            System.out.println("\n"+getLocalName()+" executed its task.");
        }
        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
        
    }
    
    private class OneShotDataAgent3 extends OneShotBehaviour {
        @Override
        public void action(){
            MLRDataAgents mlr = new MLRDataAgents();
            mlr.MatrixOps();
            System.out.println("\n"+getLocalName()+" executed its task.");
        }
        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
        
    }*/
    
}
