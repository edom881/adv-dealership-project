package com.yearup.dealership;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public void display() {

        init();

        boolean running = true;

        while (running) {

            System.out.println("\n--- Car Dealership Menu ---");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Find vehicles by price");
            System.out.println("3 - Find vehicles by make/model");
            System.out.println("4 - Find vehicles by year");
            System.out.println("5 - Find vehicles by color");
            System.out.println("6 - Find vehicles by mileage");
            System.out.println("7 - Find vehicles by type");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell or lease a vehicle");
            System.out.println("99 - Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    processAllVehiclesRequest();
                    break;

                case 2:
                    processGetByPriceRequest();
                    break;

                case 3:
                    processGetByMakeModelRequest();
                    break;
                case 4:
                    processGetByYearRequest();
                    break;
                case 5:
                    processGetByColorRequest();
                    break;
                case 6:
                    processGetByMileageRequest();
                    break;
                case 7:
                    processGetByVehicleTypeRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSellLeaseVehicleRequest();
                    break;



                case 99:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void processGetByPriceRequest() {

        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }


    private void init() {

        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    private void processAllVehiclesRequest() {

        displayVehicles(dealership.getAllVehicles());
    }

    private void displayVehicles(java.util.ArrayList<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    private void processGetByMakeModelRequest() {

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }
    private void processGetByYearRequest() {

        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();

        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }
    private void processGetByColorRequest() {

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }
    private void processGetByMileageRequest() {

        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();

        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }
    private void processGetByVehicleTypeRequest() {

        System.out.print("Enter vehicle type car/truck/SUV/van: ");
        String vehicleType = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }
    private void processAddVehicleRequest() {

        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer: ");
        int odometer = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        dealership.addVehicle(vehicle);
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully.");
    }
    private void processRemoveVehicleRequest() {

        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }

    }
    private void processSellLeaseVehicleRequest() {

        System.out.print("Enter VIN of vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToSell = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToSell = vehicle;
                break;
            }
        }

        if (vehicleToSell == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter contract date YYYYMMDD: ");
        String date = scanner.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Is this a sale or lease? ");
        String type = scanner.nextLine();

        Contract contract;

        if (type.equalsIgnoreCase("sale")) {

            System.out.print("Finance? yes/no: ");
            String financeAnswer = scanner.nextLine();

            boolean finance = financeAnswer.equalsIgnoreCase("yes");

            contract = new SalesContract(date, customerName, customerEmail, vehicleToSell, finance);

        } else {

            contract = new LeaseContract(date, customerName, customerEmail, vehicleToSell);
        }

        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContract(contract);

        dealership.removeVehicle(vehicleToSell);

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);

        System.out.println("Contract saved and vehicle removed from inventory.");
    }

}