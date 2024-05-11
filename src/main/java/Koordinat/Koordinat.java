package Koordinat;

public class Koordinat {
    private int x;
    private int y;

    public Koordinat(int a , int b){
        x = a;
        y = b;
    }

    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public void setX(int xnew){
        x = xnew;
    }

    public void setY(int ynew){
        x = ynew;
    }

    public void displayKoordinat(){
        System.out.println("[" + getX() + "," + getY() + "]");
    }
}
