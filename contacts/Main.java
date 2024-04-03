package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Create create = new Create();
        Contacts contacts = new Contacts("contacts/phonebook.db");

        boolean exit = false;
        while (!exit) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String selection = scanner.nextLine();

            switch (selection) {
                case "add" -> {
                    System.out.print("Enter the type (person, organization): ");
                    String division = scanner.nextLine();
                    if (division.equals("person")) {
                        create.addPerson(contacts.getContacts());
                    } else if (division.equals("organization")) {
                        create.addOrganization(contacts.getContacts());
                    }
                    System.out.println("The record added.\n");
                }
                case "search" -> contacts.search(contacts.getContacts());
                case "count" -> contacts.count(contacts.getContacts());
                case "list" -> contacts.list(contacts.getContacts());
                case "exit" -> exit = true;
            }
        }
    }
}
