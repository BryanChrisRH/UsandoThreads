package MultiThread;

public class Test {
    public static void main(String[] args) {
        
        MyStack laPila=new MyStack();
        Productor p=new Productor(laPila);
        Consumidor c=new Consumidor(laPila);
        Thread TProd=new Thread(p);
        Thread TCons=new Thread(c);
        TProd.start();
        TCons.start();
        
    }
}
