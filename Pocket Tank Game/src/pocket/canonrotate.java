/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocket;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Raju
 */
public class canonrotate {
    
    Image cn;
    ImageView cnn;
    double angle;
    Group root;
    double x;
    double y;

    public canonrotate(Image cn,ImageView cnn,int ang,double x,double y,Group root) {
        this.cn=cn;
        this.cnn=cnn;
        angle=180-ang;
        this.root=root;
        this.x=x;
        this.y=y;
        
        cnn.setRotate(angle);
        cnn.setX(x);
        cnn.setY(y);
        root.getChildren().add(cnn);
    }
     public void SetAngle(double ang) {
         angle=180-ang;
         cnn.setRotate(180-ang);
     }
     void Setx(double x) {
         this.x=x;
     }
      double Getx() {
         return x;
     }
     double Gety() {
         return y;
     }
     void moveright() {
         cnn.setX(cnn.getX()+20);
          x=cnn.getX()+20;
     }
     void moveleft() {
         cnn.setX(cnn.getX()-20);
          x=cnn.getX()-20;
     }
    
}
