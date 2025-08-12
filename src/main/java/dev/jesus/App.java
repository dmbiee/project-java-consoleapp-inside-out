package dev.jesus;

import dev.jesus.views.HomeView;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        HomeView hv = new HomeView();

        HomeView.printMainMenu();

    }
}
