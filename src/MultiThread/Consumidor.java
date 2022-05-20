package MultiThread;

public class Consumidor implements Runnable{
    MyStack pila;
    Integer cont;

    Consumidor(MyStack laPila){
        pila=laPila;
        cont=0;
    }

    @Override
    public void run() {

        for (int i = 0; i < 200; i++) {
            char c=pila.pop();
            System.out.println(++cont+":"+c);
            
            try {
                Thread.sleep((int)(Math.random()*300));
            } 
            catch (InterruptedException e) {
                
                throw new RuntimeException(e);
            }
        }
    }  
}
