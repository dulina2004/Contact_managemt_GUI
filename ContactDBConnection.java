public class ContactDBConnection {
    private list contactList;
    private static ContactDBConnection contactDBConnection;

    private ContactDBConnection() {
        contactList = new list();
    }

    public static ContactDBConnection getInstance() {
        if (contactDBConnection == null) {
            contactDBConnection = new ContactDBConnection();
        }
        return contactDBConnection;
    }

    public list getContactList() {
        return contactList;
    }
}
