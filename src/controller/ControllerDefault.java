package controller;

import views.ViewDefault;

public class ControllerDefault {
    private String view;

    public ControllerDefault(String view) {



    }
    public static class Default {
        public Default(String view) {
            new ViewDefault(view);
        }
    }

    public void getView() {




    }

    public void setView() {

        this.view = view;
    }
}
