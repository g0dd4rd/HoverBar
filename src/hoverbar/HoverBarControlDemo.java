package hoverbar;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

/**
 *
 * @author jiri
 */
public class HoverBarControlDemo extends Application {
    final int WIDTH = 600;
    final int HEIGHT = 420;
    final int REC_WIDTH = 20;
    final int REC_HEIGHT = 30;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("@dr3dwerkz - Hover Bar Control Demo - www.dredwerkz.cz");
        final Group canvas = new Group();
        HoverBar hb = new HoverBar();
        hb.setPrefWidth(WIDTH);
        Group root = new Group();       
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);

        String[] colorNames = {"blue", "violet", "green", "yellow", "orange",
            "red", "black", "white"};
        
        for (final String s : colorNames) {
            hb.getChildren().add(RectangleBuilder.create()
                .width(REC_WIDTH).height(REC_HEIGHT)
                .fill(Color.valueOf(s))
                .id(s)
                .onMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent meClicked) {
                        canvas.getChildren().add(CircleBuilder.create()
                            .centerX(WIDTH / 2)
                            .centerY(HEIGHT / 2)
                            .radius(Math.random() * 200)
                            .fill(Color.valueOf(s))
                            .build());
                    }
                })
                .build());
        }

        hb.getChildren().add(new Separator(Orientation.VERTICAL));
        hb.getChildren().add(ButtonBuilder.create()
            .text("Add text")
            .onMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent meClicked) {
                    canvas.getChildren().add(
                        TextBuilder.create()
                            .x(Math.random() *  WIDTH)
                            .y(Math.random() * HEIGHT)
                            .text("Not random")
                            .build());
                        }
                })
            .build());
        
        root.getChildren().addAll(canvas, hb);
        primaryStage.show();
    }    
}
