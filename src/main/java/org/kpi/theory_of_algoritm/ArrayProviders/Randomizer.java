package org.kpi.theory_of_algoritm.ArrayProviders;

import org.kpi.theory_of_algoritm.Exception.ArrayProviderException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer implements ArrayProvider {
    public int size;
    private final String filePath;

    public Randomizer(int size,String filePath) {
        this.size = size;
        this.filePath = filePath;
    }

    @Override
    public List<Float> getArray() throws ArrayProviderException {
        ArrayList<Float> generatedList = new ArrayList<>();
        Random rand = new Random();
        //Adding random values to our array
        for (int i=0; i<size;i++){
            generatedList.add(rand.nextFloat(10));
        }

        writeToFile(generatedList);

        return generatedList;
    }

    private void writeToFile(ArrayList<Float> generatedList ) throws ArrayProviderException {
        // Output list of random element to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath,false))) {
            for (Float value: generatedList){
                writer.write(value.toString().concat(" "));
            }
        } catch (FileNotFoundException e) {
            throw new ArrayProviderException("Can't open file. Check your file path!");
        } catch (IOException e) {
            throw new ArrayProviderException("Problem with output file");
        }
    }
}
