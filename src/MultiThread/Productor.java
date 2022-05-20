package MultiThread;

public class Productor implements Runnable {
    
    MyStack pila;
    Integer num;

    Productor(MyStack laPila){
        pila=laPila;
        num=0;
    }

    @Override
    public void run() {
       char c;
       
       for(int i=0; i<200; i++){
           
        c=(char)(Math.random()*26+'A');
           pila.push(c);

           try{
            Thread.sleep( (int) (Math.random() *300 ) );
           }catch(InterruptedException e){
               throw new RuntimeException();

           }
       }
    }
    
}
