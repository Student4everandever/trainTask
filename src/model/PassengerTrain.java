package model;

import model.entity.Carriages;
import model.entity.Locomotive;

import java.util.ArrayList;
import java.util.Collections;

public class PassengerTrain {
    public Locomotive locomotive = new Locomotive();
    public Carriages carriages = new Carriages();

    public int getCarriagesCount() {
        return carriages.getTypeOfCarriages().size();
    }

    /**
     *
     * @return People capacity of the passenger train
     */
    public int getPassengerCount() {
        int passengerCount = 0;

        for(String name : this.carriages.getTypeOfCarriages()) {
            for(CarriagesTypes pasClass : CarriagesTypes.values())
                if(name.equals(pasClass.toString())) {
                    passengerCount += pasClass.peopleCount();
                }
        }
        return passengerCount;
    }

    /**
     *
     * @return Baggage capacity of the passenger train
     */
    public int getBaggageCount() {
        int baggageCount = 0;

        for(String name : this.carriages.getTypeOfCarriages()) {
            for(CarriagesTypes pasClass : CarriagesTypes.values())
                if(name.equals(pasClass.toString())) {
                    baggageCount += pasClass.baggageCount();
                }
        }
        return baggageCount;
    }

    /**
     * Transforms String list to Integer list using carriage class enum indexes
     * @param carriages List of typeOfCarriages
     * @return Integer list of typeOfCarriages classes
     */
    private ArrayList<Integer> getIntListFromStringList(ArrayList<String> carriages) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for(String classes : carriages) {
            int temp = CarriagesTypes.valueOf(classes).ordinal();
            tmp.add(temp);
        }
        return tmp;
    }

    /**
     * Sorts typeOfCarriages of the train by class(comfort)
     * @return Sorted list of typeOfCarriages in train
     */
    public ArrayList<String> sortCarriagesByClass() {
        ArrayList<Integer> tmp = getIntListFromStringList(carriages.getTypeOfCarriages());
        Collections.sort(tmp);
        ArrayList<String> sorted = new ArrayList<>();
        for(Integer value : tmp) {
            String s = CarriagesTypes.values()[value].name();
            sorted.add(s);
        }
        return sorted;
    }

    /**
     * Looking for typeOfCarriages in train with capacity within the range
     * @param range - array with min and max of the range
     * @return String with result of search
     */
    public ArrayList<String> getCarriagesByRangeOfPassengers(int [] range) {
        ArrayList<String> carriagesInRange = new ArrayList<>();
        ArrayList<Integer> tmp = getIntListFromStringList(carriages.getTypeOfCarriages());
        for(Integer value : tmp) {
            if (!carriagesInRange.contains(CarriagesTypes.values()[value].name()) &&
                    CarriagesTypes.values()[value].peopleCount >= range[0] &&
                    CarriagesTypes.values()[value].peopleCount <= range[1]) {

                carriagesInRange.add(CarriagesTypes.values()[value].name());
            }
        }
        return carriagesInRange;
    }
}

