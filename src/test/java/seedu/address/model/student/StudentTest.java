package seedu.address.model.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ATTENDANCE_TODAY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STUDENT_NAME_BOB;
import static seedu.address.testutil.TypicalStudents.ALICE;
import static seedu.address.testutil.TypicalStudents.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.StudentBuilder;

public class StudentTest {

    @Test
    public void isSameStudent() {
        // same object -> returns true
        assertTrue(ALICE.isSameStudent(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameStudent(null));

        // same name, all other attributes different -> returns true
        Student editedAlice = new StudentBuilder(ALICE).withParentName(VALID_STUDENT_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
                .withAddress(VALID_ADDRESS_BOB).withAttendance(VALID_ATTENDANCE_TODAY).build();
        assertTrue(ALICE.isSameStudent(editedAlice));

        // different name, all other attributes same -> returns false
        editedAlice = new StudentBuilder(ALICE).withStudentName(VALID_STUDENT_NAME_BOB).build();
        assertTrue(ALICE.isSameStudent(editedAlice));

        // name differs in case, all other attributes same -> returns false
        Student editedBob = new StudentBuilder(BOB).withStudentName(VALID_STUDENT_NAME_BOB.toLowerCase()).build();
        assertTrue(BOB.isSameStudent(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_STUDENT_NAME_BOB + " ";
        editedBob = new StudentBuilder(BOB).withStudentName(nameWithTrailingSpaces).build();
        assertTrue(BOB.isSameStudent(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Student aliceCopy = new StudentBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different person -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Student editedAlice = new StudentBuilder(ALICE).withStudentName(VALID_STUDENT_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new StudentBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new StudentBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new StudentBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new StudentBuilder(ALICE).withAttendance(VALID_ATTENDANCE_TODAY).build();
        assertTrue(ALICE.equals(editedAlice));
    }

    @Test
    public void toStringMethod() {
        String expected = Student.class.getCanonicalName() + "{student name=" + ALICE.getStudentName()
                + ", student ID=" + ALICE.getStudentId() + ", parent name=" + ALICE.getParentName()
                + ", phone=" + ALICE.getPhone() + ", email=" + ALICE.getEmail()
                + ", address=" + ALICE.getAddress() + ", attendance=" + ALICE.getAttendance() + "}";
        assertEquals(expected, ALICE.toString());
    }
}
