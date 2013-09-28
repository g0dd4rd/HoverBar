package hoverbar;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author jiri
 */
public class HoverBar extends FlowPane {

    public HoverBar() {
        super();
        this.setStyle("-fx-background-color: gray;");
        this.setPickOnBounds(true);
        this.setOpacity(0);
        setOnMouseEntered (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent meEntered) {
                if (isHover()) {
                    setOpacity(1);
                }
            }
        });
        
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent meExited) {
                if (!isHover()) {
                    setOpacity(0);
                }
            }
        });
    }
}
