package com.yearup.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {

    private static final String FILE_NAME = "src/main/resources/inventory.csv";

    public Dealership getDealership() {



        try { BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String dealershipLine = reader.readLine();
            String[] dealershipParts = dealershipLine.split("\\|");
            Dealership dealership = new Dealership(
                    dealershipParts[0],
                    dealershipParts[1],
                    dealershipParts[2]
            );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(
                        vin,
                        year,
                        make,
                        model,
                        vehicleType,
                        color,
                        odometer,
                        price
                );

                dealership.addVehicle(vehicle);
            }

            reader.close();

            return dealership;

        } catch (IOException e) {
            System.out.println("Error reading inventory file.");
        }

        return null;
    }
    public void saveDealership(Dealership dealership) {

            try {
                FileWriter writer = new FileWriter(FILE_NAME);

                writer.write(dealership.getName() + "|" +
                        dealership.getAddress() + "|" +
                        dealership.getPhone() + "\n");

                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    writer.write(vehicle.toString() + "\n");
                }

                writer.close();

            } catch (IOException e) {
                System.out.println("Error saving inventory file.");
            }
        }


    }

