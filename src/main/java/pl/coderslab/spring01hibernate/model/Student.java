package pl.coderslab.spring01hibernate.model;

import java.util.List;


public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    private List programmingSkills;
    private List<String> hobbies;


    public Student setId(long id) {
        this.id = id;
        return this;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Student setCountry(String country) {
        this.country = country;
        return this;
    }

    public Student setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Student setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
        return this;
    }

    public Student setProgrammingSkills(List programmingSkills) {
        this.programmingSkills = programmingSkills;
        return this;
    }

    public Student setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public List getProgrammingSkills() {
        return programmingSkills;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", notes='" + notes + '\'' +
                ", mailingList=" + mailingList +
                ", programmingSkills=" + programmingSkills +
                ", hobbies=" + hobbies +
                '}';
    }
}
