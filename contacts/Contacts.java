package contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;
    Create create = new Create();
    private String filename;
    private List<Contact> contacts = new LinkedList<>();

    private transient Scanner scanner = new Scanner(System.in); // `transient`로 선언하여 직렬화에서 제외

    public Contacts(String filename) {
        this.filename = filename;
        loadFromFile();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    // 데이터 저장
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Saved");
        } catch (IOException e) {
            System.out.println("Cannot save contacts to file: " + e.getMessage());
        }
    }

    // 데이터 로딩
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Contacts loadedContacts = (Contacts) ois.readObject();
            this.contacts = loadedContacts.contacts;
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new contacts list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load contacts from file: " + e.getMessage());
        }
    }

    public void search(List<Contact> list) {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        List<Contact> tempContacts = new ArrayList<>();
        for (Contact contact : list) {
            if (pattern.matcher(contact.toString()).find()) {
                tempContacts.add(contact);
            }
        }
        System.out.printf("Found %d results: \n", tempContacts.size());
        print(tempContacts);

        System.out.print("[search] Enter action ([number], back, again): ");
        String action = scanner.nextLine();
        switch (action) {
            case "back" -> {
                System.out.println();
            }
            case "again" -> search(list);
            default -> {
                try {
                    int num = Integer.parseInt(action) - 1;
                    System.out.println(tempContacts.get(num).toString());
                    System.out.print("[record] Enter action (edit, delete, menu): ");
                    String action2 = scanner.nextLine();
                    switch (action2) {
                        case "edit" -> edit(tempContacts, num);
                        case "delete" -> {
                            list.remove(tempContacts.get(num));
                            saveToFile();
                        }
                        case "menu" -> System.out.println();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("It is a wrong input.");
                }
            }
        }
    }


    public void edit(List<Contact> list, int num) {

        Contact contact = list.get(num);

        if (contact instanceof Person) {
            create.editPerson((Person) contact);
        } else {
            create.editOrganization((Organization) contact);
        }
        saveToFile();
        System.out.println(list.get(num).toString());
    }



    public void list(List<Contact> list) {
        print(list);

        System.out.print("[list] Enter action ([number], back): ");
        String action = scanner.nextLine();
        if (action.equals("back")) {
            System.out.println();
        } else {
            try {
                int num = Integer.parseInt(action) - 1;
                System.out.println(list.get(num).toString());
                System.out.print("[record] Enter action (edit, delete, menu): ");
                String action2 = scanner.nextLine();
                switch (action2) {
                    case "edit" -> edit(list, num);
                    case "delete" -> {
                        list.remove(list.get(num));
                        saveToFile();
                    }
                    case "menu" -> System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("It is a wrong input.");
            }
        }
    }

    private static void print(List<Contact> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).info());
        }
        System.out.println();
    }

    public void count(List<Contact> list) {
        System.out.printf("The Phone Book has %d records\n", list.size());
    }
}
