import controller.Controller;
import controller.UtilityController;
import view.View;

public class Main {
    public static void main(String [] args) {

        View view = new View();
        UtilityController utilityController = new UtilityController(view);
        Controller controller = new Controller(view, utilityController);
        controller.run();

    }
}
