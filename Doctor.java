// Assignment #: 11
// Name: Luca Fulmor
// StudentID:1217485191
// ssLecture: MWF 11:45 - 12:50
// Description: Class to build doctor objects to be assigned to patients and with methods to interact with them

public class Doctor {
	private int doctorID;
	private Patient currentPatient;

	// Constructor to initialize member variables
	// Initially no patient is assigned
	public Doctor(int id) {
		this.doctorID = id;
		currentPatient = null;
	}

	// toString method returns a string containing
	// the information of a doctor
	public String toString() {
		String result = "Doctor id " + doctorID;

		if (currentPatient == null)
			result += " is not seeing any patient";
		else
			result += " is seeing a patient with id " + currentPatient.getPatientID();

		return result;
	}

	// More Methods need to be added here

	// method to check if a doctor has a patient
	public boolean hasPatient() {

		if (currentPatient != null)

			return true;

		else

			return false;

	}

	// checks if doctor has current patient and if not assigns entered patient to
	// current patient
	public boolean assignPatient(Patient patient1) {

		if (currentPatient == null) {

			this.currentPatient = patient1;
			return true;
		}

		else

			return false;

	}

	// method to be used for patient management and to release current patient and
	// then make current patient null
	Patient releasePatient() {

		if (currentPatient != null) {

			Patient releasedPatient = currentPatient;
			@SuppressWarnings("unused")
			Patient currentPatient = null;
			return releasedPatient;

		}

		else

			return null;

	}

}