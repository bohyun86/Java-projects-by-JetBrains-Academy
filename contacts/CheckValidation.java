package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValidation {
    public String hasNumer(String phoneNUmber) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*");
        Matcher matcher = pattern.matcher(phoneNUmber);
        if (!matcher.find()) {
            phoneNUmber = "[no number]";
            System.out.println("Wrong number format!");
        }
        return phoneNUmber;
    }

    public String hasBirthDate(String birthdate) {
        Pattern pattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(birthdate);
        if (!matcher.find()) {
            birthdate = "[no data]";
            System.out.println("Bad birth date!");
        }
        return birthdate;
    }

    public String hasGender(String gender) {
        Pattern pattern = Pattern.compile("^[MF]$");
        Matcher matcher = pattern.matcher(gender);
        if (!matcher.find()) {
            gender = "[no data]";
            System.out.println("Bad gender!");
        }
        return gender;
    }

}
