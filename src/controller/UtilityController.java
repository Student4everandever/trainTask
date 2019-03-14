package controller;

import model.PassengerTrain;
import view.View;

import java.util.ArrayList;
import java.util.Scanner;

import static view.Text_Constants.*;

public class UtilityController {
    private View view;

    public UtilityController(View view) {
        this.view = view;
    }

    int electricOrDiesel(Scanner sc) {
        int value;
        do {
            view.printMyString(CHOOSE_THE_LOCOMOTIVE);
            while(!sc.hasNextInt()) {
                view.printMyString(ERROR_ONLY_CORRECT_DIGITS_TO_INPUT);
                sc.next();
            }
            value = sc.nextInt();
        } while((value <1) || (value >2));
        return value;
    }

    String trainInfo(PassengerTrain passengerTrain) {
        return view.returnMyString(PASSENGER_TRAIN) + "["
             + view.returnMyString(TYPE_OF_LOCOMOTIVE) + passengerTrain.locomotive.getTypeOfLocomotive()
             + view.returnMyString(NUMBER_OF_CARRIAGES) + passengerTrain.getCarriagesCount()+ "]" + "\n"
             + view.returnMyString(CARRIAGES_OF_TRAIN_BY_CLASS) + passengerTrain.carriages.getTypeOfCarriages();
    }

    int [] getMinMaxWithScanner(Scanner sc) {
        int [] range = new int[2];
        view.printMyString(INPUT_THE_MIN_OF_THE_RANGE);
        while(!sc.hasNextInt()) {
            view.printMyString(ERROR_ONLY_CORRECT_DIGITS_TO_INPUT);
            sc.next();
        }
        range[0] = sc.nextInt();
        do{
            view.printMyString(INPUT_THE_MAX_OF_THE_RANGE);
            while(!sc.hasNextInt()) {
                view.printMyString(ERROR_ONLY_CORRECT_DIGITS_TO_INPUT);
                sc.next();
            }
            range[1] = sc.nextInt();
        } while (range[1] < range[0]);
        return range;
    }



    void printCarriagesWithinTheRange(PassengerTrain passengerTrain, int[] range) {
        ArrayList<String> arrayList;
        arrayList = passengerTrain.getCarriagesByRangeOfPassengers(range);
        if(!(arrayList.isEmpty())) {
            for (String value : arrayList) {
                System.out.println(value + " ");
            }
        } else {
            view.printMyString(NO_CARRIAGES_WITHIN_THE_CAPACITY_RANGE);
        }
    }
}
