# Parking Lot

Problem Source: <a href = "https://workat.tech/machine-coding/practice/design-parking-lot-qm6hwq4wkhp8">work@tech</a>
## Problem Statement
A parking lot is an area where cars can be parked for a certain amount of time. A parking lot can have multiple floors with each floor having a different number of slots and each slot being suitable for different types of vehicles.

For this problem, we have to design the next generation parking lot system which can manage a parking lot without any human intervention.

## Requirements
Create a command-line application for the parking lot system with the following requirements.

- The functions that the parking lot system can do:
    - Create the parking lot.
    - Add floors to the parking lot.
    - Add a parking lot slot to any of the floors.
    - Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
    - Unparks a vehicle given the ticket id.
    - Displays the number of free slots per floor for a specific vehicle type.
    - Displays all the free slots per floor for a specific vehicle type.
    - Displays all the occupied slots per floor for a specific vehicle type.

- Details about the Vehicles:
    - Every vehicle will have a type, registration number, and color.
    - Different Types of Vehicles:
        - Car
        - Bike
        - Truck
- Details about the Parking Slots:
    - Each type of slot can park a specific type of vehicle.
    - No other vehicle should be allowed by the system.
    - Finding the first available slot should be based on:
        - The slot should be of the same type as the vehicle.
        - The slot should be on the lowest possible floor in the parking lot.
        - The slot should have the lowest possible slot number on the floor.
    - Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.
- Details about the Parking Lot Floors:
    - Numbered serially from 1 to n where n is the number of floors.
    - Might contain one or more parking lot slots of different types.
    - We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.
- Details about the Tickets:
    - The ticket id would be of the following format:
<parking_lot_id>\_<floor_no>\_<slot_no>
Example: PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
- We can assume that there will only be 1 parking lot. The ID of that parking lot is PR1234.

## Input/Output Format
The code should strictly follow the input/output format and will be tested with provided test cases.

### Input Format
Multiple lines with each line containing a command.

Possible commands:
- create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
- park_vehicle <vehicle_type> <reg_no> <color>
- unpark_vehicle <ticket_id>
- display <display_type> <vehicle_type>
    - Possible values of display_type: free_count, free_slots, occupied_slots
- exit<br>
Stop taking the input when you encounter the word exit.

### Output Format
Print output based on the specific commands as mentioned below.

**create_parking_lot**<br>
Created parking lot with <no_of_floors> floors and <no_of_slots_per_floor> slots per floor

**park_vehicle**<br>
Parked vehicle. Ticket ID: <ticket_id><br>
Print "Parking Lot Full" if slot is not available for that vehicle type.

**unpark_vehicle**<br>
Unparked vehicle with Registration Number: <reg_no> and Color: <color><br>
Print "Invalid Ticket" if ticket is invalid or parking slot is not occupied.

**display free_count <vehicle_type>**
No. of free slots for <vehicle_type> on Floor <floor_no>: <no_of_free_slots><br>
The above will be printed for each floor.

**display free_slots <vehicle_type>**<br>
Free slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
The above will be printed for each floor.

display occupied_slots <vehicle_type>
Occupied slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos><br>
The above will be printed for each floor.

## Examples
Sample Input<br>
create_parking_lot PR1234 2 6<br>
display free_count CAR<br>
display free_count BIKE<br>
display free_count TRUCK<br>
display free_slots CAR<br>
display free_slots BIKE<br>
display free_slots TRUCK<br>
display occupied_slots CAR<br>
display occupied_slots BIKE<br>
display occupied_slots TRUCK<br>
park_vehicle CAR KA-01-DB-1234 black<br>
park_vehicle CAR KA-02-CB-1334 red<br>
park_vehicle CAR KA-01-DB-1133 black<br>
park_vehicle CAR KA-05-HJ-8432 white<br>
park_vehicle CAR WB-45-HO-9032 white<br>
park_vehicle CAR KA-01-DF-8230 black<br>
park_vehicle CAR KA-21-HS-2347 red<br>
display free_count CAR<br>
display free_count BIKE<br>
display free_count TRUCK<br>
unpark_vehicle PR1234_2_5<br>
unpark_vehicle PR1234_2_5<br>
unpark_vehicle PR1234_2_7<br>
display free_count CAR<br>
display free_count BIKE<br>
display free_count TRUCK<br>
display free_slots CAR<br>
display free_slots BIKE<br>
display free_slots TRUCK<br>
display occupied_slots CAR<br>
display occupied_slots BIKE<br>
display occupied_slots TRUCK<br>
park_vehicle BIKE KA-01-DB-1541 black<br>
park_vehicle TRUCK KA-32-SJ-5389 orange<br>
park_vehicle TRUCK KL-54-DN-4582 green<br>
park_vehicle TRUCK KL-12-HF-4542 green<br>
display free_count CAR<br>
display free_count BIKE<br>
display free_count TRUCK<br>
display free_slots CAR<br>
display free_slots BIKE<br>
display free_slots TRUCK<br>
display occupied_slots CAR<br>
display occupied_slots BIKE<br>
display occupied_slots TRUCK<br>
exit<br>

### Expected Output
Created parking lot with 2 floors and 6 slots per floor<br>
No. of free slots for CAR on Floor 1: 3<br>
No. of free slots for CAR on Floor 2: 3<br>
No. of free slots for BIKE on Floor 1: 2<br>
No. of free slots for BIKE on Floor 2: 2<br>
No. of free slots for TRUCK on Floor 1: 1<br>
No. of free slots for TRUCK on Floor 2: 1<br>
Free slots for CAR on Floor 1: 4,5,6<br>
Free slots for CAR on Floor 2: 4,5,6<br>
Free slots for BIKE on Floor 1: 2,3<br>
Free slots for BIKE on Floor 2: 2,3<br>
Free slots for TRUCK on Floor 1: 1<br>
Free slots for TRUCK on Floor 2: 1<br>
Occupied slots for CAR on Floor 1: <br>
Occupied slots for CAR on Floor 2: <br>
Occupied slots for BIKE on Floor 1: <br>
Occupied slots for BIKE on Floor 2: <br>
Occupied slots for TRUCK on Floor 1: <br>
Occupied slots for TRUCK on Floor 2: <br>
Parked vehicle. Ticket ID: PR1234_1_4<br>
Parked vehicle. Ticket ID: PR1234_1_5<br>
Parked vehicle. Ticket ID: PR1234_1_6<br>
Parked vehicle. Ticket ID: PR1234_2_4<br>
Parked vehicle. Ticket ID: PR1234_2_5<br>
Parked vehicle. Ticket ID: PR1234_2_6<br>
Parking Lot Full<br>
No. of free slots for CAR on Floor 1: 0<br>
No. of free slots for CAR on Floor 2: 0<br>
No. of free slots for BIKE on Floor 1: 2<br>
No. of free slots for BIKE on Floor 2: 2<br>
No. of free slots for TRUCK on Floor 1: 1<br>
No. of free slots for TRUCK on Floor 2: 1<br>
Unparked vehicle with Registration Number: WB-45-HO-9032 and Color: white<br>
Invalid Ticket<br>
Invalid Ticket<br>
No. of free slots for CAR on Floor 1: 0<br>
No. of free slots for CAR on Floor 2: 1<br>
No. of free slots for BIKE on Floor 1: 2<br>
No. of free slots for BIKE on Floor 2: 2<br>
No. of free slots for TRUCK on Floor 1: 1<br>
No. of free slots for TRUCK on Floor 2: 1<br>
Free slots for CAR on Floor 1: <br>
Free slots for CAR on Floor 2: 5<br>
Free slots for BIKE on Floor 1: 2,3<br>
Free slots for BIKE on Floor 2: 2,3<br>
Free slots for TRUCK on Floor 1: 1<br>
Free slots for TRUCK on Floor 2: 1<br>
Occupied slots for CAR on Floor 1: 4,5,6<br>
Occupied slots for CAR on Floor 2: 4,6<br>
Occupied slots for BIKE on Floor 1: <br>
Occupied slots for BIKE on Floor 2: <br>
Occupied slots for TRUCK on Floor 1: <br>
Occupied slots for TRUCK on Floor 2: <br>
Parked vehicle. Ticket ID: PR1234_1_2<br>
Parked vehicle. Ticket ID: PR1234_1_1<br>
Parked vehicle. Ticket ID: PR1234_2_1<br>
Parking Lot Full<br>
No. of free slots for CAR on Floor 1: 0<br>
No. of free slots for CAR on Floor 2: 1<br>
No. of free slots for BIKE on Floor 1: 1<br>
No. of free slots for BIKE on Floor 2: 2<br>
No. of free slots for TRUCK on Floor 1: 0<br>
No. of free slots for TRUCK on Floor 2: 0<br>
Free slots for CAR on Floor 1: <br>
Free slots for CAR on Floor 2: 5<br>
Free slots for BIKE on Floor 1: 3<br>
Free slots for BIKE on Floor 2: 2,3<br>
Free slots for TRUCK on Floor 1: <br>
Free slots for TRUCK on Floor 2: <br>
Occupied slots for CAR on Floor 1: 4,5,6<br>
Occupied slots for CAR on Floor 2: 4,6<br>
Occupied slots for BIKE on Floor 1: 2<br>
Occupied slots for BIKE on Floor 2: <br>
Occupied slots for TRUCK on Floor 1: 1<br>
Occupied slots for TRUCK on Floor 2: 1

## Expectations
- Make sure that you have a working and demonstrable code
- Make sure that the code is functionally correct
- Code should be modular and readable
- Separation of concern should be addressed
- Please do not write everything in a single file (if not coding in C/C++)
- Code should easily accommodate new requirements and minimal changes
- There should be a main method from where the code could be easily testable
- [Optional] Write unit tests, if possible
No need to create a GUI

## Optional Requirements
Please do these only if you’ve time left. You can write your code such that these could be accommodated without changing your code much.

- Keep the code extensible to add additional types of vehicles and slot types.
- Keep the code extensible to allow a different strategy of finding the first available slot.
- Keep the code extensible to allow any other type of command.
- Keep the code extensible to allow multiple parking lots. - You can assume that the input/output format can be changed for that.
- Keep the system thread-safe to allow concurrent requests.