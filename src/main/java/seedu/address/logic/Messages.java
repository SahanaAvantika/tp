package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.student.Student;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command. Please type \"help\" to check out "
            + "the available commands";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX = "The student index provided is invalid";
    public static final String MESSAGE_INVALID_STUDENT_DISPLAYED_ID = "The student ID provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d student listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";
    public static final String MESSAGE_INVALID_STUDENT_NOT_FOUND = "Student with this ID not found";
    public static final String MESSAGE_STUDENT_ATTENDANCE_MARKED = "Student %1$s marked as present!";
    public static final String MESSAGE_STUDENT_ATTENDANCE_UNMARKED = "Student %1$s marked as absent!";

    public static final String MESSAGE_ALL_STUDENT_ATTENDANCE_UNMARKED = "All students marked as absent!";
    public static final String MESSAGE_ALL_STUDENT_ATTENDANCE_MARKED = "All students marked as present!";


    public static final String STUDENT_ID_MESSAGE_CONSTRAINTS =
            "Student ID should be 4 characters beginning with A followed by 2 digits and ending with an alphabet in UPPERCASE";
    public static final String PHONE_MESSAGE_CONSTRAINTS =
            "Phone numbers should only contain numbers, and should be between 80000000 and 99999999";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code student} for display to the user.
     */
    public static String format(Student student) {
        final StringBuilder builder = new StringBuilder();
        builder.append(student.getStudentName())
                .append("; Student Id: ")
                .append(student.getStudentId())
                .append("; Parent Name: ")
                .append(student.getParentName())
                .append("; Phone: ")
                .append(student.getPhone())
                .append("; Email: ")
                .append(student.getEmail())
                .append("; Address: ")
                .append(student.getAddress());
        return builder.toString();
    }

}
