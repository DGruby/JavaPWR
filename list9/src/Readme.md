# Medical Clinic Management System

A Java-based clinic management system demonstrating object-oriented programming concepts including inheritance, interfaces, and relationships between entities.

## Overview

This system manages appointments, prescriptions, patients, doctors, and staff in a medical clinic. 

## Features

- **Appointment Management**: Staff can schedule appointments for patients with doctors, with automatic conflict detection
- **Prescription Management**: Doctors can create and manage prescriptions with multiple treatments
- **Patient Tracking**: View all appointments and prescriptions for specific patients
- **Doctor Calendars**: Display scheduled appointments for each doctor
- **Medicine Queries**: Find all patients with active prescriptions for specific medicines

## Class Structure

### Core Classes

- **`Person`** (abstract): Base class for all people in the system
    - `Patient`: Extends Person, implements Treatable
    - `Staff` (abstract): Extends Person, provides appointment creation capability
        - `Doctor`: Can create prescriptions and manage appointments
        - `Nurse`: Performs patient care duties
        - `Receptionist`: Manages administrative tasks

### System Classes

- **`Appointment`**: Links a patient, doctor, and scheduled time
- **`Prescription`**: Contains treatments prescribed by a doctor to a patient
- **`ClinicSystem`**: Implements ClinicOperations interface, manages all clinic data
- **`ClinicOperations`** (interface): Defines core clinic functionality

### Interfaces

- **`Treatable`**: Interface for entities that can receive treatment
- **`ClinicOperations`**: Interface defining clinic system operations

## Key Design Features

- **Conflict Prevention**: Prevents double-booking of doctors at the same time
- **Encapsulation**: Uses interfaces to separate implementation from interface
- **Inheritance Hierarchy**: Logical class structure with Person as the root
- **Bidirectional Relationships**: Both patients and doctors maintain their appointment lists

## Running the Program

Execute `ClinicTest.java` to see a demonstration of:
- Creating patients, doctors, and staff
- Scheduling appointments (including conflict handling)
- Creating prescriptions
- Querying appointments and prescriptions
```bash
javac ClinicTest.java
java ClinicTest
```

## Requirements

- Java 8 or higher (uses `java.time.LocalDateTime`)