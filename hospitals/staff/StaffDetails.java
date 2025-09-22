package hospitals.staff;

public class StaffDetails {
    private String id;
    private String name;
    private String dob;
    private int age;
    private String address;
    private double phone;
    private String qualification;

    public StaffDetails(){}

    public StaffDetails(String id, String name, String dob, int age, String address, double phone, String qualification){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.qualification = qualification;
    }

}
