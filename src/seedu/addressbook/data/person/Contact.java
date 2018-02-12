package seedu.addressbook.data.person;

/**
 * Represents an person's contact.
 */
public class Contact {

    public final String value;
    public boolean isPrivate;

    public Contact(String contact, boolean isPrivate) {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        this.value = trimmedContact;

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}