package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Create {

    public void addPerson(List<Contact> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter the birth date: ");
        String birthData = scanner.nextLine();
        birthData = new CheckValidation().hasBirthDate(birthData);

        System.out.print("Enter the gender (M, F): ");
        String gender = scanner.nextLine();
        gender = new CheckValidation().hasGender(gender);

        System.out.print("Enter the number: ");
        String phoneNUmber = scanner.nextLine();
        phoneNUmber = new CheckValidation().hasNumer(phoneNUmber);

        String formattedDateTime = currentDate();

        list.add(new Person(name, surname, birthData, gender, phoneNUmber, formattedDateTime, formattedDateTime));
    }


    public void addOrganization(List<Contact> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the organization name: ");
        String organizationName = scanner.nextLine();

        System.out.print("Enter the address: ");
        String address = scanner.nextLine();

        System.out.print("Enter the number: ");
        String phoneNumber = scanner.nextLine();
        phoneNumber = new CheckValidation().hasNumer(phoneNumber);

        String formattedDateTime = currentDate();
        list.add(new Organization(organizationName, address, phoneNumber, formattedDateTime, formattedDateTime));
    }

    private static String currentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
    }


    public void editOrganization(Organization organization) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (address, number): ");
        String field = scanner.nextLine();

        switch (field) {
            case "address" -> {
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                organization.setAddress(address);
            }
            case "number" -> {
                System.out.print("Enter number ");
                String number = scanner.nextLine();
                organization.setPhoneNumber(number);
            }
        }

        String formattedDateTime = currentDate();
        organization.setRevisionTime(formattedDateTime);
    }

    public void editPerson(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine();

        switch (field) {
            case "name" -> {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                person.setName(name);
            }
            case "surname" -> {
                System.out.print("Enter surname ");
                String surname = scanner.nextLine();
                person.setSurname(surname);
            }
            case "birth" -> {
                System.out.print("Enter birth date: ");
                String birth = scanner.nextLine();
                birth = new CheckValidation().hasBirthDate(birth);
                person.setBirthdate(birth);
            }
            case "gender" -> {
                System.out.print("Enter gender: ");
                String gender = scanner.nextLine();
                gender = new CheckValidation().hasGender(gender);
                person.setGender(gender);
            }
            case "number" -> {
                System.out.print("Enter number: ");
                String number = scanner.nextLine();
                number = new CheckValidation().hasNumer(number);
                person.setPhoneNumber(number);
            }
        }
        String formattedDateTime = currentDate();
        person.setRevisionTime(formattedDateTime);
    }
}
