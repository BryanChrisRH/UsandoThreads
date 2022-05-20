package PingPongGame;

import java.util.Random;
import java.awt.*;

public class ladrillo implements Pintable{
    Color color;
    int ancho,alto;
    int x,y;
    public ladrillo(int x, int y, int ancho, int alto){
        Random r=new Random();
        color =new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));

        this.x=x;
        this.y=y;
        this.alto=alto;
        this.ancho=ancho;

    }
    public void pintar(Graphics2D g){
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
