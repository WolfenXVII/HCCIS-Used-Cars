package hccis.menu;

import info.hccis.entity.Vehicle;
import info.hccis.util.CisUtility;

/**
 * Controls program and implements menu.
 *
 * @author Noel Spurrell
 * @since Nov 18, 2020
 */
public class Controller {

    public static final int EXIT = 0;

    public static final String MENU = "1) Calculate vehicle value" + "\n"
            + EXIT + ") Exit";

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";

    public static void main(String[] args) {

        int menuOption;

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT -> System.out.println(MESSAGE_EXIT);
                //Break out of the loop as we're finished.
                case 1 -> newVehicle();
                default -> System.out.println(MESSAGE_ERROR);
            }
        } while (menuOption != EXIT);
    }

    /**
     * Adds a new Vehicle object and displays the value.
     *
     * @author Noel Spurrell
     * @since 20221211
     */
    public static void newVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.getInformation();
        vehicle.display();
    }

}
