# Advanced Car Dealership Application

## Project Overview
This is a Java console application that manages a car dealership inventory and customer contracts. The application allows users to search vehicles, add and remove inventory, process vehicle sales and leases, and save contract information to CSV files.

This project was built using object-oriented programming principles and file handling in Java.

---

# Features

## Vehicle Inventory Features
- List all vehicles
- Search vehicles by:
    - Price range
    - Make and model
    - Year range
    - Color
    - Mileage range
    - Vehicle type
- Add vehicles to inventory
- Remove vehicles from inventory

## Contract Features
- Sell vehicles
- Lease vehicles
- Save sales contracts
- Save lease contracts
- Automatically remove sold/leased vehicles from inventory

---

# Technologies Used
- Java
- IntelliJ IDEA
- Maven
- Object-Oriented Programming (OOP)
- CSV File Handling
- ArrayLists
- FileReader / BufferedReader
- FileWriter

---

# Classes Used

## Program
Starts the application and launches the user interface.

## Vehicle
Represents a vehicle with:
- VIN
- Year
- Make
- Model
- Vehicle type
- Color
- Odometer
- Price

## Dealership
Stores dealership information and manages vehicle inventory.

## DealershipFileManager
Handles:
- Loading inventory from CSV file
- Saving inventory updates to CSV file

## UserInterface
Handles:
- Displaying menus
- Reading user input
- Processing dealership actions

## Contract
Abstract parent class for all contracts.

## SalesContract
Handles:
- Vehicle sales
- Sales tax
- Recording fee
- Processing fee
- Financing calculations

## LeaseContract
Handles:
- Lease calculations
- Ending value
- Lease fee
- Monthly payment calculations

## ContractFileManager
Handles saving sales and lease contracts to the contracts file.

---

# Inventory File
Vehicle inventory is stored in:

```text
src/main/resources/inventory.csv

contracts.csv

1 - List all vehicles
2 - Find vehicles by price
3 - Find vehicles by make/model
4 - Find vehicles by year
5 - Find vehicles by color
6 - Find vehicles by mileage
7 - Find vehicles by type
8 - Add a vehicle
9 - Remove a vehicle
10 - Sell or lease a vehicle
99 - Quit


Skills Demonstrated
Object-oriented programming
Inheritance
Abstract classes
ArrayLists
File handling
CSV parsing
User input handling
Menu-driven applications
Data persistence
Java class design
Future Improvements
Admin login system
GUI version
Database integration
Vehicle editing feature
Search by VIN
Contract history viewer



Author

Edom Gezahegn

Year Up Student – Application Development