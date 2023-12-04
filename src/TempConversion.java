import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }

    public static double getTemp(String unit) {
        System.out.printf("Please enter °%s temperature to convert: ", unit);
        return Double.parseDouble(input.nextLine());
    }

    public static String getUnitChoice() {
        System.out.println("Enter the temperature unit (C, F, K, or Q to quit):");
        return input.nextLine();
    }

    public static void main(String[] args) {
        while(true) {
            String fromUnit = getUnitChoice();
            if (fromUnit.equalsIgnoreCase("Q")) {
                break;
            }

            String toUnit = getUnitChoice();
            if (toUnit.equalsIgnoreCase("Q")) {
                break;
            }

            double temp = getTemp(fromUnit);

            double convertedTemp = 0.0;
            switch (fromUnit.toUpperCase()) {
                case "C":
                    switch (toUnit.toUpperCase()) {
                        case "F":
                            convertedTemp = convertC2F(temp);
                            break;
                        case "K":
                            convertedTemp = convertC2K(temp);
                            break;
                    }
                    break;
                case "F":
                    switch (toUnit.toUpperCase()) {
                        case "C":
                            convertedTemp = convertF2C(temp);
                            break;
                        case "K":
                            convertedTemp = convertF2K(temp);
                            break;
                    }
                    break;
                case "K":
                    convertedTemp = convertK2C(temp);
                    break;
            }

            System.out.printf("The temperature in °%s is %.2f%n", toUnit, convertedTemp);
        }
    }
}
