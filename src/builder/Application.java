package builder;

import controller.ControllerDefault;

public class Application {
    public String temp;

    public Application() {
        ControllerDefault.Default instance= new ControllerDefault.Default("0");
    }
}
