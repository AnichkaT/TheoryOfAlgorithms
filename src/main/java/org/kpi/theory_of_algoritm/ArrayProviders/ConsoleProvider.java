package org.kpi.theory_of_algoritm.ArrayProviders;


import org.kpi.theory_of_algoritm.Exception.ArrayProviderException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleProvider implements ArrayProvider {

    public int size;

    public ConsoleProvider(int size) {
        this.size=size;
    }

    @Override
    public List<Float> getArray() throws ArrayProviderException {
        ArrayList<Float> list = new ArrayList<>();
        Scanner consoleScanner = new Scanner(System.in);

        for (int i=0; i<size;i++){

            /*
            Assigning a specific value to each element
             */
            System.out.print((i+1)+" element=");
            
            try {
                list.add(Float.parseFloat(consoleScanner.nextLine()));
            } catch (NumberFormatException e) {

                /*
                Throwing an error in case the user accidentally inputs
                not a number
                 */
                throw new ArrayProviderException("Invalid input format! Check if the array elements are correct, only numbers are allowed.");
            }
        }

        return list;
    }

}
