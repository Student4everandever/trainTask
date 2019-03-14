package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class PassengerDieselTrainBuilder extends PassengerTrainBuilder {

    @Override
    public PassengerTrain createPassengerTrain() throws IOException {
        PassengerTrain dieselPassengerTrain = new PassengerTrain();
        dieselPassengerTrain.locomotive.setTypeOfLocomotive("Diesel");

        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/diesel_train_carriages.properties");
        property.load(fis);
        String tmp = property.getProperty("diesel.carriages");
        ArrayList<String> dieselTrainCarriages = new ArrayList<>(Arrays.asList(tmp.split(" ")));
        dieselPassengerTrain.carriages.setTypeOfCarriages(dieselTrainCarriages);
        return dieselPassengerTrain;
    }
}
