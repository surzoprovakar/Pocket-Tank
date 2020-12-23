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
public class tank2 {
    Image tn;
    ImageView tnk;
    Group root;
    double x;
    double y;

    public tank2(Image tn,ImageView tnk,double x,double y,Group root) {
        this.tn=tn;
        this.tnk=tnk;
        this.x=x;
        this.y=y;
        this.root=root;
        tnk.setX(x);
        tnk.setY(y);
        root.getChildren().add(tnk);
    }
    
    void Setx(double x) {
        this.x=x;
    }
    void Sety(double y) {
        this.y=y;
    }
    double Getx() {
        return x;
    }
    double Gety() {
        return y;
    }
    void moveright() {
        tnk.setX(tnk.getX()+20);
        x=tnk.getX()+20;
    }
    void moveleft() {
        tnk.setX(tnk.getX()-20);
        x=tnk.getX()-20;
    }
     
}
