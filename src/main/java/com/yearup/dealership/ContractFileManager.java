package com.yearup.dealership;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    private static final String FILE_NAME = "contracts.csv";

    public void saveContract(Contract contract) {

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving contract file.");
        }
    }


}
