import BmrBackend.Bmr;
import BmrFrontEnd.Software;
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {




    @Override
    public void start(Stage stage) throws Exception {
        Bmr bmr = new Bmr();
        Software view = new Software(stage);
        Controller controller = new Controller(bmr,view);
        controller.addObserver();
        view.addHandlerButton(controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
