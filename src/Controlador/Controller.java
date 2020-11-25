package Controlador;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class Controller {

    @FXML
    private Label label;
    @FXML
    private Ellipse elipse1;
    @FXML
    private Line linea1;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    @FXML
    private Button btnRotate1, btn2R;
    @FXML
    private Polygon trianid;
    

    public void initialize() {
        elipse1.setOnMousePressed(elipsOnMousePressedEventHandler);
        elipse1.setOnMouseDragged(elipsOnMouseDraggedEventHandler);
        btnRotate1.setOnMouseClicked(a -> {
        	linea1.setRotate(linea1.getRotate() + 15);
        });

        btn2R.setOnMouseClicked(a -> {
        	trianid.setRotate(trianid.getRotate() + 15);
        });
        
           }

    EventHandler<MouseEvent> elipsOnMousePressedEventHandler = 
            new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((Ellipse)(t.getSource())).getTranslateX();
                orgTranslateY = ((Ellipse)(t.getSource())).getTranslateY();

            }
        };
        EventHandler<MouseEvent> elipsOnMouseDraggedEventHandler = 
                new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    
                    ((Ellipse)(t.getSource())).setTranslateX(newTranslateX);
                    ((Ellipse)(t.getSource())).setTranslateY(newTranslateY);

                }
           
                    };
}
