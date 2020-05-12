package controller;

import menu.MainMenu;

public class Application {



    public static void main(String[] args){
        //User select start or end game
        MainMenu mainMenuHandler = new MainMenu();
        mainMenuHandler.mainMenuHandler();
    }
}
