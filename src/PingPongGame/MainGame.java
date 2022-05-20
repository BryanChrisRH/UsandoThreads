package PingPongGame;

import java.awt.*;
import javax.swing.*;

public class MainGame {
    Juego juego;
    JLabel jl3;
    Image fondo;
    JButton boton;
    JFrame ventana;

    public MainGame(){
        juego= new Juego();
        ventana=new JFrame(" ");
      
        ventana.add(juego, BorderLayout.CENTER);

        ventana.setSize(800,600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread MainThread=new Thread(juego);
        MainThread.start();
    }

    public static void main(String[] args) {
        new MainGame();
    }
}
