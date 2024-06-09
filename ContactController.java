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
}
