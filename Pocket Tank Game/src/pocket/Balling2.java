/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocket;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Raju
 */
class Balling2 extends Circle{
    double initialX;
    double initialY;
    double time=0;
    double speed=120;
    double angle=60;
    double gravity=10;
    double pi=3.1416;
    
    double cx,cy;
    
    Balling2(double x,double y,Group root, double radius,Color color){
       
       super(x,y,radius,color);
       root.getChildren().add(this);
    }

    
    public void updateCenter()
    {
        cx=initialX-speed*(cos(angle*pi/180)*time);
        cy=initialY-(speed*(sin(angle*pi/180)*time)-.5*gravity*time*time);
        setCenterX(cx);
        setCenterY(cy);
        
        time+=.1;    
    }
    public void setAngle(double ang)
    {
        angle = ang;
    }
    
    public void setSpeed(double spd)
    {
        speed=spd;
    }
    public void setInitialCordinate(double x,double y)
    {
        initialX=x;
        initialY=y;
    }
   
  
}
