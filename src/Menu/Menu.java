package Menu;

import Utils.MenuMessages;

public class Menu implements MenuInterface{

    @Override
    public void displayMenu() {
        System.out.println(MenuMessages.MAIN_MENU_MESSAGE);
    }
}