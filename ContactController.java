import java.time.LocalDate;

public class ContactController {
    public static boolean addContact(Contact contact) {
        list contacList = ContactDBConnection.getInstance().getContactList();
        contacList.add(contact);
        return true;
    }

    public static boolean deleteContact(int index) {
        ContactDBConnection.getInstance().getContactList().remove(index);
        return true;
    }

    public static int searchContacts(String nameOrPhone) {
        list contactlist = ContactDBConnection.getInstance().getContactList();
        return contactlist.search(nameOrPhone);
    }

    public static boolean updateContacts(String name, String mobile, String company, double salary, String birthday,
            int index) {
        list contactList = ContactDBConnection.getInstance().getContactList();
        contactList.get(index).setName(name);
        contactList.get(index).setMobile(mobile);
        contactList.get(index).setSalary(salary);
        contactList.get(index).setCompany(company);
        contactList.get(index).setBirthday(birthday);
        return true;
    }

    public static void sortName() {
        list contactList = ContactDBConnection.getInstance().getContactList();
        contactList.sortName();
    }

    public static void sortSalary() {
        list contactList = ContactDBConnection.getInstance().getContactList();
        contactList.sortSalary();
    }

    public static void sortBirthday() {
        list contactList = ContactDBConnection.getInstance().getContactList();
        contactList.sortBirthday();
    }

    public static boolean isValidMobile(String mobile) {
        if (mobile.length() == 10 && mobile.charAt(0) == '0') {
            return true;
        }
        return false;
    }

    public static boolean isValidSalary(double salary) {
        if (salary > 0) {
            return true;
        }
        return false;
    }

    public static boolean isValidBirthday(String str) {
        try {
            str = str.strip();
            String[] parts = str.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            boolean validate;

            LocalDate localD = LocalDate.now();
            // create a LocalDate object

            String localdate = localD.toString();
            localdate = localdate.strip();
            String[] local = localdate.split("-");
            int localyear = Integer.parseInt(local[0]);
            int localmonth = Integer.parseInt(local[1]);
            int localday = Integer.parseInt(local[2]);
            if (year < localyear) {
                validate = true;
            } else if (year == localyear) {
                if (month < localmonth) {
                    validate = true;
                } else if (month == localmonth) {
                    if (day < localday) {
                        validate = true;
                    } else {
                        validate = false;
                    }
                } else {
                    validate = false;
                }
            } else {
                validate = false;
            }

            if (str.length() == 10 && validate && month < 13 && day < 32) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
