package patientmanager;
import java.util.ArrayList;
import java.util.List;

public class PatientManager {
    private List<patient> patients;

    public PatientManager() {
        this.patients = new ArrayList<>();
    }

    // Register a new patient
    public boolean registerPatient(patient patient) {
        if (searchPatientById(patient.getPatientId()) != null) {
            System.out.println("Error: A patient with this ID already exists.");
            return false;
        }
        patients.add(patient);
        System.out.println("Patient registered successfully.");
        return true;
    }

    // Search for a patient using their Patient ID
    public patient searchPatientById(String patientId) {
        for (patient p : patients) {
            if (p.getPatientId().equalsIgnoreCase(patientId)) {
                return p;
            }
        }
        return null;
    }

    // Update an existing patient's details
    public boolean updatePatient(String patientId, String newCondition, patient.patientcategory newCategory) {
        patient patient = searchPatientById(patientId);
        if (patient != null) {
            patient.setMedicalCondition(newCondition);
            patient.setcategory(newCategory);
            System.out.println("Patient details updated successfully.");
            return true;
        }
        System.out.println("Error: Patient not found.");
        return false;
    }

    // Delete a patient
    public boolean deletePatient(String patientId) {
        patient patient = searchPatientById(patientId);
        if (patient != null) {
            patients.remove(patient);
            System.out.println("Patient removed successfully.");
            return true;
        }
        System.out.println("Error: Patient not found.");
        return false;
    }

    // Display all registered patients
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients currently registered in the system.");
            return;
        }
        System.out.println("\n--- Registered Patients List ---");
        for (patient p : patients) {
            System.out.println(p);
        }
    }
}