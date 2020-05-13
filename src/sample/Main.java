package sample;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label name=new Label("账号：");
        name.setFont(Font.font(14));
        Label password=new Label("密码：");
        password.setFont(Font.font(14));

        TextField tname=new TextField();
        PasswordField passwordField=new PasswordField();
        tname.setUserData("aaaaaa");
        passwordField.setUserData("123456");

        Button b1=new Button("清除");
        Button b2=new Button("登录");

        GridPane gr=new GridPane();
        gr.setStyle("-fx-background-color: greenyellow");
        gr.add(name,0,0);
        gr.setAlignment(Pos.CENTER);
        gr.add(tname,1,0);
        gr.add(password,0,1);
        gr.add(passwordField,1,1);
        gr.add(b1,0,2);
        gr.add( b2,1,2);
        gr.setHgap(5);
        gr.setVgap(15);
        GridPane.setMargin(b2,new Insets(0,0,0,120));

        Scene scene=new Scene(gr);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setResizable(false);
        primaryStage.show();

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tname.setText("");
                passwordField.setText("");
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name=(String) tname.getUserData();
                String password=(String) passwordField.getUserData();
               if(name.equals(tname.getText())&&password.equals("123456"))
               {
                   System.out.println("登录成功");
                MyWindow myWindow=new MyWindow(name,password);
                primaryStage.close();
               }
               else
                   {
                       System.out.println("登录失败");

                       primaryStage.setTitle("账号或者密码错误");
                       FadeTransition fade=new FadeTransition();

                       fade.setDuration(Duration.seconds(0.5));
                       fade.setNode(gr);
                       fade.setFromValue(0);
                       fade.setToValue(1);

                       fade.play();
                   }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class MyWindow
{
private  final Stage stage=new Stage();
public MyWindow(String name,String password)
{
    Text text=new Text("账号："+name+"密码："+password);

    BorderPane bor=new BorderPane();
    bor.setStyle("-fx-background-color: aqua");
    bor.setCenter(text);

    Scene scene=new Scene(bor);
    stage.setScene(scene);
    stage.setHeight(500);
    stage.setWidth(500);
    stage.setTitle("登录成功");
 stage.show();
}
}
