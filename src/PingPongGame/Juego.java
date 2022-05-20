package PingPongGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Juego extends JPanel implements Runnable, MouseMotionListener{
    
    ArrayList<ladrillo> ladrillos;
    Barra barra;
    Pelota bolita;
    Pelota bolita2;
    Graphics2D g;
    public int Dy;
    public int Dx;
    public int DxBolita;
    boolean jugando=true;
    int contadorniveles=4;
    int auxTiempo=8;
    int auxTiempo2=0;
    int tiempo=4;
    int vidas=3;
    int auxiliarVidas;
    int puntuaje;
    int nuevo;
    String nombre;
    boolean auxJugando;
    String niveles[]=new String[tiempo];

    public Juego(){
        niveles[0] ="Fácil";
       niveles[1] ="Medio";
       niveles[2] ="Dificil";
       niveles[3] ="Leyenda";
        nombre="";
        auxJugando=true;
        Dy=-1;
        Dx=1;
        DxBolita=1;
        puntuaje=15;
        auxiliarVidas=vidas;
        barra=new Barra(400,540);
        bolita=new Pelota(400,510);
        bolita2=new Pelota(400,-40);
        
        //Fila de ladrillos
        ladrillos=new ArrayList<>();
        for(int j=0;j<contadorniveles;j++){
            for(int i=0;i<800/50;i++){
                ladrillos.add(new ladrillo(1+50*i,j*20,
                        50,20));
                
            }
        }
        
        addMouseMotionListener(this);

    }

    @Override
    public void run() {
        
        while (jugando) {
            try {
                //Movimiento de la bolita
                Thread.sleep(tiempo);
                bolita.x += Dx;
                if ((bolita.y += Dy) > 0)
                    bolita.y += Dy;

                /*colision con las orillas*/
                if (bolita.x >= getWidth() || bolita.x <= 0) {
                    Dx *= -1;
                }
                if (bolita.y <= 0) {
                    Dy *= -1;
                }

                /*colision con la barra*/
                if (bolita.x >= barra.x &&
                        bolita.x < barra.x + barra.ancho
                        && bolita.y == barra.y) {
                    Dy *= -1;
                }

                //Vidas
                if (bolita.y > barra.y) {
                    vidas--;
                    bolita.x=400;
                    bolita.y=510;
                    Thread.sleep(3000);
                }

                /*colision con los bloques*/
                Iterator<ladrillo> it = ladrillos.iterator();
                while (it.hasNext()) {
                    ladrillo ladrillo = it.next();
                    if (bolita.x > ladrillo.getX() &&
                            bolita.x < ladrillo.getX() + ladrillo.getAncho()
                            && bolita.y == ladrillo.getY()) {
                        it.remove();//elimino el ladrillo
                        java.awt.Toolkit.getDefaultToolkit().beep();
                        Dy *= -1;
                        puntuaje+=10;
                    }
                }

                //Juego ganada
                if(contadorniveles==30){
                    JOptionPane.showMessageDialog(null,"¡¡¡Felicidades Has Ganado El Juego!!!\n"+"Puntuaje: "+puntuaje);

                }
                //Juego perdido
                if(vidas==0){
                    JOptionPane.showMessageDialog(null,"¡¡¡XDDDD!!!!!\n"+"Puntuaje: "+puntuaje);

                }

                //Nivel Nuevo
                if(ladrillos.isEmpty()) {
                    contadorniveles++;
                    //for para volver a llenar el array list
                        //CAmbiar el valor de j para agregar nuevos niveles
                        for(int j=0;j<contadorniveles;j++){
                            for(int i=0;i<800/50;i++){
                                ladrillos.add(new ladrillo(1+50*i,j*20,
                                        50,20));
                            }
                        }
                        bolita.x=400;
                        bolita.y=510;
                    Thread.sleep(3000);

                        }
                    //Juego nuevo
                if (vidas==0||contadorniveles ==30){
                    nuevo = JOptionPane.showConfirmDialog(null, "¿Quieres volver a Jugar?");
                    if (nuevo == 0) {
                        vidas=auxiliarVidas;
                        auxJugando=true;
                        puntuaje=15;
                        contadorniveles=4;
                        //Pintar los bloques
                        for(int j=0;j<contadorniveles;j++){
                            for(int i=0;i<800/50;i++){
                                ladrillos.add(new ladrillo(1+50*i,j*20,
                                        50,20));
                            }
                        }
                    }else{
                        jugando=false;
                        JOptionPane.showMessageDialog(null,"¡¡ADIOS!!"+nombre);
                    }
                    }

               repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Termina el while
}

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getX()<590){
            barra.x=e.getX();
            repaint();
    }
}

@Override
public synchronized void paintComponent(Graphics g) {
    super.paintComponent(g);
        this.g=(Graphics2D) g;

        try {
            for (ladrillo l : ladrillos) {
                l.pintar(this.g);
            }
        }catch (Exception e){

        }

        barra.pintar(this.g);
        bolita.pintar(this.g);
        bolita2.pintar(this.g);
    }
}


