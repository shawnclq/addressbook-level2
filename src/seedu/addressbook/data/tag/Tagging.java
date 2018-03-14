package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents addition or deletion of tag for a person during a session
 *
 * Used for displaying tags changed at the end of a session
 */

public class Tagging {
    private static ArrayList<Tagging> taggings;

    public enum Action {
        ADD, DELETE
    }

    private static final String ADD_TAG_SIGN = "+";
    private static final String DELETE_TAG_SIGN = "-";

    private final Person person;
    private final Tag tag;
    private final Action action;

    /**
     * @param person person whose tag was changed
     * @param tag tag that was changed
     * @param action type of action executed
     */
    public Tagging(Person person, Tag tag, Action action) {
        this.person = person;
        this.tag = tag;
        this.action = action;
    }

    /**
     * Adds tagging to class-level variable that stores all taggings
     */
    public static void addTagging(Tagging tagging) {
        taggings.add(tagging);
    }

    /**
     * Accessor method for obtaining taggings.
     * @return all Taggings, representing all changes made to tags since start of session
     */
    public static ArrayList<Tagging> getTaggings() {
        return taggings;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this // short circuit if same object
                || obj instanceof Tagging // instanceof handles null
                && ((Tagging) obj).getPerson().equals(this.person)
                && ((Tagging) obj).getTag().equals(this.tag)
                && ((Tagging) obj).getAction().equals(this.getAction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, tag, action);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.action == Action.ADD) {
            builder.append(ADD_TAG_SIGN);
        } else {
            builder.append(DELETE_TAG_SIGN);
        }

        builder.append(" " + person.getName() + " " + tag);
        return builder.toString();
    }
}