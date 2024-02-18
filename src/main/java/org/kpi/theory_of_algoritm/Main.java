package org.kpi.theory_of_algoritm;

import org.kpi.theory_of_algoritm.ArrayProviders.ArrayProvider;
import org.kpi.theory_of_algoritm.ArrayProviders.ConsoleProvider;
import org.kpi.theory_of_algoritm.ArrayProviders.FileProvider;
import org.kpi.theory_of_algoritm.ArrayProviders.Randomizer;
import org.kpi.theory_of_algoritm.Exception.ArrayProviderException;
import org.kpi.theory_of_algoritm.Exception.MenuException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Generate array elements - 1");
        System.out.println("Enter the array by yourself - 2");
        System.out.println("Read from file - 3 ");
        System.out.print("Input how you want entered array ");
        String choice = consoleScanner.nextLine();
        System.out.println("_______________________");

        try {
            ArrayProvider provider = getArrayProvider(choice);
            List<Float> array = provider.getArray();
            outputArray(array);
            countBiggerThen(array, getValueToCompare());
        } catch (ArrayProviderException | MenuException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayProvider getArrayProvider(String choice) throws MenuException {
        return switch (choice) {
            case "1" -> new Randomizer(getSize());
            case "2" -> new ConsoleProvider(getSize());
            case "3" -> new FileProvider(getFilePath());
            default -> throw new MenuException("You entered wrong menu option");
        };
    }

    private static void outputArray(List<Float> array) {
        System.out.println(array);
    }

    private static float getValueToCompare() throws MenuException {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Enter a value to compare ");
        try {
            return Float.parseFloat(consoleScanner.nextLine());
        } catch (NumberFormatException e) {
            throw new MenuException("You entered wrong value");
        }
    }

    private static void countBiggerThen(List<Float> array, float valueToCompare) {
        int amount = 0;
        for (Float aFloat : array) {
            if (aFloat > valueToCompare) {
                amount++;
            }
        }
        System.out.println("The amount of elements array bigger than entered number is " + amount);
    }

    private static int getSize() throws MenuException {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Input amount of element in array ");
        String length = consoleScanner.nextLine();

        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new MenuException("You entered wrong elements value");
        }

    }

    private static String getFilePath() {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Input file path (C:\\Users\\Anna\\Desktop\\Array.txt ) ");
        return consoleScanner.nextLine();
    }

}


