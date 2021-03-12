// Assignment #: 11
// Name: Luca Fulmor
// StudentID:1217485191
// ssLecture: MWF 11:45 - 12:50
// Description: This program manages patient queues, assigns patients to doctors,
//              release them to check out, etc.

import java.util.Iterator;
import java.util.LinkedList;

public class PatientManagement {
	private LinkedList<Patient> highPriorityQueue; // Requires immediate life-saving intervention
	private LinkedList<Patient> intermediateQueue; // Requires significant intervention within two to four hours.
	private LinkedList<Patient> delayedCareQueue; // Needs medical treatment, but this can safely be delayed.

	private LinkedList<Patient> checkOutQueue; // queue for patients that need to check out

	private Doctor[] doctorList; // an array of doctors

	// Constructor to initialize member variables
	public PatientManagement(int numOfDoctors) {
		highPriorityQueue = new LinkedList<Patient>();
		intermediateQueue = new LinkedList<Patient>();
		delayedCareQueue = new LinkedList<Patient>();
		checkOutQueue = new LinkedList<Patient>();

		// creating doctor objects
		doctorList = new Doctor[numOfDoctors];
		for (int i = 0; i < doctorList.length; i++) {
			doctorList[i] = new Doctor(i);
		}
	}

	// The printQueue prints out the content
	// of the queues and the array of doctors
	public void printPatientQueues() {
		System.out.print("\nHigh Priority Queue:\n" + highPriorityQueue.toString() + "\n");
		System.out.print("\nIntermediate Queue:\n" + intermediateQueue.toString() + "\n");
		System.out.print("\nDelayed Care Queue:\n" + delayedCareQueue.toString() + "\n\n");
		for (int i = 0; i < doctorList.length; i++) {
			System.out.println(doctorList[i].toString());
		}
		System.out.print("\nCheck Out Queue:\n" + checkOutQueue.toString() + "\n\n");
	}

	// method to add patient based off their priority level
	boolean addPatient(int patientID, String conditionLevel) {

		if (conditionLevel.equals("High Priority")) {

			// creates new patient object off the information entered in the method
			Patient patient = new Patient(patientID, conditionLevel);
			// adds it to respective queue
			highPriorityQueue.addFirst(patient);

			return true;

		}

		if (conditionLevel.equals("Intermediate")) {

			Patient patient = new Patient(patientID, conditionLevel);

			intermediateQueue.addFirst(patient);

			return true;

		}

		if (conditionLevel.equals("Delayed Care")) {

			Patient patient = new Patient(patientID, conditionLevel);
			delayedCareQueue.addFirst(patient);

			return true;

		}
//returns false if no patient is able to be added
		else
			return false;

	}

	// method which checks for patients needing to be assigned to a doctor in the
	// queue by priority, then creates new objects and adds the patient to the
	// doctor
	@SuppressWarnings("unused")
	Patient assignPatientToDoctor() {

		Iterator<Patient> hIterator = highPriorityQueue.iterator();
		Iterator<Patient> iIterator = intermediateQueue.iterator();
		Iterator<Patient> dIterator = delayedCareQueue.iterator();

		while (highPriorityQueue.size() > 0) {

			for (int index = 0; index < doctorList.length; index++) {

				// checks if doctor has a patient or not using method we designed in doctor
				// class
				if (doctorList[index].hasPatient() == false) {

					// Patient hPatient = new Patient(highPriorityQueue.peek(), "High Priority");
					// assigns the doctor currently being looked at that also has no current patient
					// to the new patient

					Patient patient = (highPriorityQueue.peek());
					doctorList[index].assignPatient(highPriorityQueue.poll());
					return patient;

				}

				else

				{

				}

			}

		}

		// repeats above method for intermediate queue
		while (intermediateQueue.size() > 0) {

			for (int index = 0; index < doctorList.length; index++) {

				if (doctorList[index].hasPatient() == false) {

					// Patient iPatient = new Patient(index, "Intermediate Priority");

					Patient patient2 = (intermediateQueue.peek());
					doctorList[index].assignPatient(intermediateQueue.poll());
					return patient2;

				}

				else {

				}

			}

		}

		while (delayedCareQueue.size() > 0) {

			for (int index = 0; index < doctorList.length; index++) {

				if (doctorList[index].hasPatient() == false) {

					// Patient dPatient = new Patient(index, "Delayed Care");

					Patient patient3 = (delayedCareQueue.peek());
					doctorList[index].assignPatient(delayedCareQueue.peekFirst());
					return patient3;

				}

			}

		}

		{

			return null;

		}

	}

	// method to be used on patient whos been treated and can be released
	Patient releasePatientFromDoctorToCheckOutQueue(int doctorID) {

		Doctor doctor = new Doctor(doctorID);

		Patient patient = new Patient(doctorID, "null");
		// checks if doctor id entered has patient, if so, gets the patient id and
		// releases them, adding them to the check out queue
		if (doctor.hasPatient()) {

			patient.getPatientID();
			doctor.releasePatient();
			checkOutQueue.add(patient);

			return patient;
		}

		else

			return null;
	}

	Patient checkOutPatient() {

		// checks the checkout queue and removes any patients in it
		while (checkOutQueue.size() > 0) {
			checkOutQueue.remove();

		}

		return null;

	}

}