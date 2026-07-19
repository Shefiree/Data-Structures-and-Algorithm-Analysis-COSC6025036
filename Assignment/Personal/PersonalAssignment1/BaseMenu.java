package Assignment.Personal.PersonalAssignment1;

import java.util.Scanner;

public abstract class BaseMenu {
    protected Scanner sc = new Scanner(System.in);

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            displayMenuName();
            displayOptions();
            System.out.print("Masukkan pilihan: ");
            String input = sc.nextLine();
            isRunning = handleInput(input);
        }
    }

    protected abstract void displayMenuName();

    protected abstract void displayOptions();

    protected abstract boolean handleInput(String input);
}