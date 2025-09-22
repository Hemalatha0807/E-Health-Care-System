package hospitals.staff.doctors;

import hospitals.staff.StaffDetails;

public class DoctorDetails extends StaffDetails {
    private String department;
    private String specialist;
    private int yearOfExperience;

    public DoctorDetails(){}

    public DoctorDetails(String id, String name, String dob, int age, String address, double phone, String qualification, String department, String specialist, int yearOfExperience){
        super(id, name, dob, age, address, phone, qualification);
        this.department = department;
        this.specialist = specialist;
        this.yearOfExperience = yearOfExperience;
    }
}
