package org.kpi.theory_of_algoritm.ArrayProviders;


import org.kpi.theory_of_algoritm.Exception.ArrayProviderException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProvider implements ArrayProvider {

    private final String filePath;

    public FileProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Float> getArray() throws ArrayProviderException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String line = reader.readLine();

            //Throwing an error if the file is blank
            if (line == null) {
                throw new ArrayProviderException("Problem with reading file. Check your file is not empty!");
            }

            /*
            Throwing an error if the file isn't blank but its content
            doesn't meet the requirements
             */
            ArrayList<Float> list = getFloats(line.split(" "));

            if (reader.readLine() != null) {
                throw new ArrayProviderException("Problem with reading file");
            }

            return list;
        } catch (FileNotFoundException e) {
            throw new ArrayProviderException("Can't open file. Check your file path!");
        } catch (IOException e) {
            throw new ArrayProviderException("Problem with reading file");
        }
    }

    private ArrayList<Float> getFloats(String[] strings) throws ArrayProviderException {
        ArrayList<Float> list = new ArrayList<>();
        for (String string : strings) {
            try {
                list.add(Float.parseFloat(string));
            } catch (NumberFormatException e) {

                //Throwing an error in case the elements aren't numbers
                throw new ArrayProviderException("Check your file content!Make sure it is a numbers.");
            }
        }
        return list;
    }
}
