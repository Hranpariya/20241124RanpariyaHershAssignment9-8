import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Fan fan = new Fan();

        try {
            System.out.print("Enter fan speed (1-SLOW, 2-MEDIUM, 3-FAST): ");
            int speed = input.nextInt();
            if (speed < 1 || speed > 3) {
                System.out.println("Invalid speed. Setting to default (SLOW).");
                fan.setSpeed(Fan.SLOW);
            } else {
                fan.setSpeed(speed);
            }
        } catch (Exception e) {
            System.out.println("Invalid input for speed. Setting to default (SLOW).");
            fan.setSpeed(Fan.SLOW);
            input.nextLine();
        }

        while (true) {
            System.out.print("Enter fan radius: ");
            if (input.hasNextDouble()) {
                fan.setRadius(input.nextDouble());
                input.nextLine();
                break;
            } else {
                System.out.println("Invalid input for radius. Setting to default (5.0).");
                fan.setRadius(5.0);
                input.nextLine();
                break;
            }
        }

        System.out.print("Enter fan color: ");
        String colorInput = input.nextLine().trim();

        if (isValidColor(colorInput)) {
            fan.setColor(colorInput);
        } else {
            System.out.println("Invalid color input. Setting to default (blue).");
            fan.setColor("blue");
        }

        System.out.print("Is the fan on or off? ");
        String fanStateInput = input.nextLine();
        switch (fanStateInput.toLowerCase()) {
            case "on":
            case "off":
                fan.setOn(fanStateInput.equalsIgnoreCase("on"));
                break;
            default:
                System.out.println("Invalid input for fan state. Setting to default (off).");
                fan.setOn(false);
                break;
        }

        System.out.println("\nFan description:");
        System.out.println(fan.toString());

        input.close();
    }

    private static boolean isValidColor(String color) {
        String[] validColors = {"red", "green", "yellow", "blue", "orange", "purple", "pink", "black", "white"};
        for (String validColor : validColors) {
            if (validColor.equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }
}