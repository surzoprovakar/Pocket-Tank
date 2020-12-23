
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocket;

import java.io.IOException;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Raju
 */

public class Pocket extends Application {
    Stage mainStage;
    Text txt= new Text(160,40,"X");
    Text txt1= new Text(1220,40,"X");
    Text score1=new Text(160,70,"X");
    Text score2=new Text(1220,70,"X");
    Text volley=new Text(520,180,"X");
    Text vol1count=new Text(170,110,"X");
    Text vol2count=new Text(1230,110,"X");
    Text mov1count=new Text(160,140,"X");
    Text mov2count=new Text(1220,140,"X");
    Text l=new Text(30,240,"X");
    Text r=new Text(1080,240,"X");
    Text d=new Text(510,220,"X");
   
    int v1=10;
    int v2=10;
    int m1=4;
    int m2=4;
    double ang=45;
    double spd=60;
    int sc1=0;
    int sc2=0;
    
    int ballcontrol=0;
 
    void reduceangle() {
        ang--;
        txt.setText(String.format("%.0f",ang));
    }
    void increaseangle() {
        ang++;
        txt.setText(String.format("%.0f",ang));
    }
    void speedup() {
        spd++;
        txt1.setText(String.format("%.0f",spd));
    }
    void speeddown() {
        spd--;
        txt1.setText(String.format("%.0f",spd));
    }
    void increasesc1() {
        sc1+=10;
        score1.setText(String.format("%d",sc1));
    }
    void increasesc2() {
        sc2+=10;
        score2.setText(String.format("%d",sc2));
    }
    void voldec1() {
        v1--;
        vol1count.setText(String.format("%d",v1));
    }
    void voldec2() {
        v2--;
        vol2count.setText(String.format("%d",v2));
    }
    void movdec1() {
        m1--;
        mov1count.setText(String.format("%d",m1));
    }
    void movdec2() {
        m2--;
        mov2count.setText(String.format("%d",m2));
    }
    
    boolean detect1(double a,double b,double c,double d) {
        if ((c>=a && c<=a+70) && (d>=b && d<=b+25)) return true;
        else return false;
    }
    
    boolean detect2(double a,double b,double c,double d) {
        if ((c>=a && c<=a+70) && (d>=b && d<=b+25)) return true;
        return false;
    }

    
    @Override
    public void start(Stage stage) throws Exception {
        new themesound();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        
        HomeController controller=loader.getController();
        controller.setMain(this);
        mainStage=stage;
        
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
   
    
    public void OptionPage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Option.fxml"));
        Parent root = loader.load();
        
        OptionController controller=loader.getController();
        controller.setMain(this);
        
        
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public void About() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("About.fxml"));
        Parent root = loader.load();
        
        AboutController controller=loader.getController();
        controller.setMain(this);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void moun1() throws IOException{
        Group root=new Group();
        
        Text txt2= new Text(30,40,"ANGLE :");
        Text txt3= new Text(1090,40,"SPEED :");
        Text Score1=new Text(30,70,"SCORE :");
        Text Score2=new Text(1090,70,"SCORE :");
        
        Text vol1=new Text(30,110,"VOLLEY :");
        Text vol2=new Text(1090,110,"VOLLEY :");
        Text mov1=new Text(30,140,"MOVE :");
        Text mov2=new Text(1090,140,"MOVE :");
        

        txt.setText(String.format("%.0f",ang));
        txt1.setText(String.format("%.0f",spd));
        score1.setText(String.format("%d",sc1));
        score2.setText(String.format("%d",sc2));
        vol1count.setText(String.format("%d",v1));
        vol2count.setText(String.format("%d",v2));
        mov1count.setText(String.format("%d",m1));
        mov2count.setText(String.format("%d",m2));

        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        txt1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        score1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        score2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        
        txt2.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        txt3.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        Score1.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        Score2.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        
        vol1.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        vol1count.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        vol2.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        vol2count.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        
        mov1.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        mov1count.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        mov2.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        mov2count.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        
        root.getChildren().add(txt);
        root.getChildren().add(txt1);
        root.getChildren().add(score1);
        root.getChildren().add(score2);
        root.getChildren().add(txt2);
        root.getChildren().add(txt3);
        root.getChildren().add(Score1);
        root.getChildren().add(Score2);
        root.getChildren().add(vol1);
        root.getChildren().add(vol2);
        root.getChildren().add(vol1count);
        root.getChildren().add(vol2count);
        root.getChildren().add(mov1);
        root.getChildren().add(mov2);
        root.getChildren().add(mov1count);
        root.getChildren().add(mov2count);
        
        
        
        Image cn1 = new Image("canon2.png");
        ImageView cn2 = new ImageView(cn1);
        
        canonrotate canon=new canonrotate(cn1, cn2, (int) ang, 60, 505, root);
        
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (ballcontrol%2==0) {
                    canon.SetAngle((int) ang);
                }
            }

        }.start();
        
        Image cn3 = new Image("canon2.png");
        ImageView cn4 = new ImageView(cn3);
        
        canonrotate2 canon2=new canonrotate2(cn3, cn4, (int) ang, 1100, 520, root);
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (ballcontrol%2==1) {
                    canon2.SetAngle((int) ang);
                }
            }
        }.start();
            
        
        Image image = new Image("tank1new.png");
        ImageView iv1 = new ImageView(image);
        
        tank1 ftank=new tank1(image,iv1,50,515,root);


        Image iv4 = new Image("tank1new.png");
        ImageView iv3 = new ImageView(iv4);
        
        tank2 stank=new tank2(iv4,iv3,1100,532,root);


        Canvas canvas=new Canvas(1280,650);
        GraphicsContext gc=canvas.getGraphicsContext2D();
        mountain1 mountain=new mountain1();
        mountain.drawMountain(gc);
        root.getChildren().add(canvas);
        
        Button b=new Button("FIRE");
        b.setLayoutX(550);
        b.setLayoutY(50);
        b.setPrefSize(100,50);
        b.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
        
        root.getChildren().add(b);
        
        Button ml=new Button("<");
        ml.setLayoutX(40);
        ml.setLayoutY(360);
        ml.setPrefSize(40,40);
        ml.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
        root.getChildren().add(ml);
        
        Button mr=new Button(">");
        mr.setLayoutX(90);
        mr.setLayoutY(360);
        mr.setPrefSize(40,40);
        mr.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
        root.getChildren().add(mr);
        
        Button ml2=new Button("<");
        ml2.setLayoutX(1090);
        ml2.setLayoutY(360);
        ml2.setPrefSize(40,40);
        ml2.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
        root.getChildren().add(ml2);
        
        Button mr2=new Button(">");
        mr2.setLayoutX(1140);
        mr2.setLayoutY(360);
        mr2.setPrefSize(40,40);
        mr2.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
        root.getChildren().add(mr2);
        
        double p=ftank.Getx();
        double q=stank.Getx();
        
        ml.setOnAction((ActionEvent event) -> {
            if (m1>0 && ftank.Getx()>0) {
                movdec1();
                canon.moveleft();
                ftank.moveleft();
            }
        });
        mr.setOnAction((ActionEvent event) -> {
            if (m1>0) {
                movdec1();
                canon.moveright();
                ftank.moveright();
            }
        });
        
        ml2.setOnAction((ActionEvent event) -> {
            if (m2>0 && (q-stank.Getx()<=40)) {
                System.out.println(q);
                System.out.println(stank.Getx());
                movdec2();
                canon2.moveleft();
                stank.moveleft();
            }
        });
        mr2.setOnAction((ActionEvent event) -> {
            if (m2>0) {
                movdec2();
                canon2.moveright();
                stank.moveright();
            }
        });
       
        Scene scene=new Scene(root,1280,650,Color.DARKVIOLET);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCode()==KeyCode.LEFT) {
                    increaseangle();
                }
                else if(e.getCode()==KeyCode.RIGHT) {
                    reduceangle();
                }
                else if(e.getCode()==KeyCode.UP) {
                    speedup();
                }
                else if(e.getCode()==KeyCode.DOWN) {
                    speeddown();
                }
        }
        });
        
        
        
        b.setOnAction((ActionEvent event) -> {
            double x= spd;
            double y= ang;
            
            if (ballcontrol%2==0 && ballcontrol<=18) {
                double m=canon.Getx()+29+29*cos(3.1416*(180-(double)canon.angle)/180);
                double n=canon.Gety()-4-29*sin(3.1416*(180-(double)canon.angle)/180);
                Balling ball=new Balling(m,n,root,6,Color.BLACK);
                ball.setInitialCordinate(m,n);
                
                new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                          if (detect1(stank.x-3,stank.y,ball.getCenterX(),ball.getCenterY())) {
                              try {
                                  new Sound();
                              } catch (IOException ex) {
                                  Logger.getLogger(Pocket.class.getName()).log(Level.SEVERE, null, ex);
                              }
                                increasesc1();
                                root.getChildren().remove(ball);
                                stop();
                            }
                          if(mountain.detectCollision(ball.getCenterX(),ball.getCenterY(),ball.getRadius())) {
                              try {
                                  new Sound();
                              } catch (IOException ex) {
                                  Logger.getLogger(Pocket.class.getName()).log(Level.SEVERE, null, ex);
                              }
                                ball.setRadius(20);
                                mountain.drawImpact(ball.getCenterX(), ball.getCenterY(), gc);
                                root.getChildren().remove(ball);
                                stop();
                            }
                          
                          else {
                                ball.updateCenter();
                                ball.setAngle(y);
                                ball.setSpeed(x);
                            }  
                        }

                }.start();
                
                ballcontrol++;
                voldec1();
            }
            else if (ballcontrol%2==1 && ballcontrol<=19) {
                double m=canon2.Getx()+29+29*cos(3.1416*((double)canon.angle)/180);
                double n=canon2.Gety()-4-29*sin(3.1416*((double)canon.angle)/180);
                Balling2 ball2=new Balling2(m,n,root,6,Color.YELLOW);
                ball2.setInitialCordinate(m,n);

                new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                          if (detect2(ftank.x-5,ftank.y,ball2.getCenterX(),ball2.getCenterY())) {
                              try {
                                  new Sound();
                              } catch (IOException ex) {
                                  Logger.getLogger(Pocket.class.getName()).log(Level.SEVERE, null, ex);
                              }
                                increasesc2();
                                root.getChildren().remove(ball2);
                                stop();
                            }
                          if(mountain.detectCollision(ball2.getCenterX(),ball2.getCenterY(),ball2.getRadius())) {
                              try {
                                  new Sound();
                              } catch (IOException ex) {
                                  Logger.getLogger(Pocket.class.getName()).log(Level.SEVERE, null, ex);
                              }
                                ball2.setRadius(20);
                                mountain.drawImpact(ball2.getCenterX(), ball2.getCenterY(), gc);
                                root.getChildren().remove(ball2);
                                stop();
                            }
                          else {
                                ball2.updateCenter();
                                ball2.setAngle(y);
                                ball2.setSpeed(x);
                            }  
                        }

                }.start();
                
                ballcontrol++;
                voldec2();
            }
            else if (ballcontrol==20) {
                volley.setText(String.valueOf("VOLLEY END"));
                volley.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
                root.getChildren().add(volley);
                
                if (sc1==sc2) {
                    d.setText(String.valueOf("GAME DRAWN"));
                    d.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
                    root.getChildren().add(d); 
                }
                else if (sc1>sc2) {
                    l.setText(String.valueOf("WINNER"));
                    l.setFont(Font.font("Tahoma", FontWeight.NORMAL, 35));
                    root.getChildren().add(l);
                }
                else {
                    r.setText(String.valueOf("WINNER"));
                    r.setFont(Font.font("Tahoma", FontWeight.NORMAL, 35));
                    root.getChildren().add(r);
                }

                ballcontrol=40;
            }
            else {
                
            }
        });
        
        
        mainStage.setScene(scene);
        mainStage.show();
    }
    
     public static void main(String[] args) {
        launch(args);
    }
    
    
}
