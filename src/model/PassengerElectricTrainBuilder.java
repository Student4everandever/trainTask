package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class PassengerElectricTrainBuilder extends PassengerTrainBuilder {

    @Override
    public PassengerTrain createPassengerTrain() throws IOException {
        PassengerTrain electricPassengerTrain = new PassengerTrain();
        electricPassengerTrain.locomotive.setTypeOfLocomotive("Electric");

        FileInputStream fis;
        Properties property2 = new Properties();
        fis = new FileInputStream("src/electric_train_carriages.properties");
        property2.load(fis);
        String tmp = property2.getProperty("electric.carriages");
        ArrayList<String> electricTrainCarriages = new ArrayList<>(Arrays.asList(tmp.split(" ")));
        electricPassengerTrain.carriages.setTypeOfCarriages(electricTrainCarriages);
        return electricPassengerTrain;
    }
}
