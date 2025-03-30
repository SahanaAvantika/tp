package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.student.Address;
import seedu.address.model.student.Attendance;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Phone;
import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSamplePersons() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new StudentId("A01A"), new Name("Allen Yeoh"),
                    new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                    new Attendance(new HashSet<>())),
            new Student(new Name("Bernice Yu"), new StudentId("A02A"), new Name("Ben Yu"),
                    new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new Attendance(new HashSet<>())),
            new Student(new Name("Charlotte Oliveiro"), new StudentId("A01P"), new Name("Charlie Oliveiro"),
                    new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    new Attendance(new HashSet<>())),
            new Student(new Name("David Li"), new StudentId("A99Z"), new Name("Dan Li"),
                    new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    new Attendance(new HashSet<>())),
            new Student(new Name("Irfan Ibrahim"), new StudentId("A91C"), new Name("Illya Ibrahim"),
                    new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                    new Attendance(new HashSet<>())),
            new Student(new Name("Roy Balakrishnan"), new StudentId("A01Q"), new Name("Raymond Balakrishnan"),
                    new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                new Attendance(new HashSet<>()))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student samplePerson : getSamplePersons()) {
            sampleAb.addStudent(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
