package org.kpi.theory_of_algoritm.ArrayProviders;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer implements ArrayProvider {
    public int size;

    public Randomizer(int size) {
        this.size = size;
    }

    @Override
    public List<Float> getArray() {
        ArrayList<Float> list = new ArrayList<>();
        Random rand = new Random();

        //Adding random values to our array
        for (int i=0; i<size;i++){
            list.add(rand.nextFloat(10));
        }

        return list;
    }
}
