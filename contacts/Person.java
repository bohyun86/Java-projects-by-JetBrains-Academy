package contacts;

public class Person extends Contact {
    private String name;
    private String surname;
    private String birthdate;

    private String gender;

    public Person(String name, String surname, String birthdate, String gender
            , String phoneNumber, String creationTime, String revisionTime) {
        super(phoneNumber, creationTime, revisionTime);
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Surname: " + this.surname + "\n" +
                "Birth date: " + this.birthdate + "\n" +
                "Gender: " + this.gender + "\n" +
                "Number: " + this.phoneNumber + "\n" +
                "Time created: " + this.creationTime + "\n" +
                "Time last edit: " + this.revisionTime + "\n";
    }

    @Override
    String info() {
        return String.format("%s %s", this.name, this.surname);
    }
}
