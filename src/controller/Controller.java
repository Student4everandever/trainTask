package controller;

import model.PassengerDieselTrainBuilder;
import model.PassengerElectricTrainBuilder;
import model.PassengerTrain;
import model.PassengerTrainBuilder;
import view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static view.Text_Constants.*;

public class Controller {
    private View view;
    private UtilityController utilityController;
    //private PassengerTrain passengerTrain;

    public Controller(View view, UtilityController utilityController) {
        this.view = view;
        this.utilityController = utilityController;
    }

    public void run() {

        Scanner sc = new Scanner(System.in);
        PassengerTrain passengerTrain = null;
        PassengerTrainBuilder passengerTrainBuilder = null;


        view.printMyString(WELCOME_TO_PROGRAM);
        int choice = utilityController.electricOrDiesel(sc);

        if(choice == 1) {
            passengerTrainBuilder = new PassengerElectricTrainBuilder();
        } else if(choice == 2){
            passengerTrainBuilder = new PassengerDieselTrainBuilder();
        }
        try {
            assert passengerTrainBuilder != null;
            passengerTrain = passengerTrainBuilder.createPassengerTrain();
        } catch (IOException e) {
            view.printMyString(ERROR_PROPERTY_FILE_IS_MISSING);
        }

        System.out.println(utilityController.trainInfo(passengerTrain) + "\n");

        view.printMyString(PASSENGER_CAPACITY_OF_TRAIN);
        int tmp = passengerTrain != null ? passengerTrain.getPassengerCount() : 0;
        System.out.println(tmp);


        view.printMyString(BAGGAGE_CAPACITY_OF_TRAIN);
        int temp = passengerTrain != null ? passengerTrain.getBaggageCount() : 0;
        System.out.println(temp + "\n");

        view.printMyString(SORTED_TRAIN_CARRIAGES_BY_CLASS);
        ArrayList<String> array;
        array = passengerTrain != null ? passengerTrain.sortCarriagesByClass() : null;
        System.out.println(array + "\n");


        view.printMyString(CARRIAGES_OF_TRAIN_WITHIN_THE_CAPACITY_RANGE);
        int[] minMax;
        minMax = utilityController.getMinMaxWithScanner(sc);
        utilityController.printCarriagesWithinTheRange(passengerTrain, minMax);
    }
}
