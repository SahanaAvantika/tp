package seedu.address.model.student;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Student's attendance in the address book.
 */
public class Attendance {
    private boolean isPresentToday;
    private LocalDate lastUpdatedDate;
    private final Set<LocalDate> attendance = new HashSet<>();

    /**
     * Initialises attendance.
     * @param attendance Set of dates where student was present.
     */
    public Attendance(Set<LocalDate> attendance) {
        requireNonNull(attendance);
        this.attendance.addAll(attendance);
        updateIsPresentToday();
    }

    /**
     * Returns whether student is present today.
     * @return True if present today, False otherwise.
     */
    public boolean getIsPresentToday() {
        if (!lastUpdatedDate.equals(LocalDate.now())) {
            updateIsPresentToday();
        }
        return this.isPresentToday;
    }

    private void updateIsPresentToday() {
        isPresentToday = attendance.contains(LocalDate.now());
        lastUpdatedDate = LocalDate.now();
    }

    /**
     * Sets student to present today.
     */
    public void setPresent() {
        this.attendance.add(LocalDate.now());
        updateIsPresentToday();
    }

    /**
     * Sets student to absent today.
     */
    public void setAbsent() {
        this.attendance.remove(LocalDate.now());
        updateIsPresentToday();
    }

    /**
     * Gets set of dates where student was present.
     * @return Set of dates
     */
    public Set<LocalDate> getAttendance() {
        return this.attendance;
    }

    @Override
    public String toString() {
        return attendance.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Attendance)) {
            return false;
        }

        Attendance otherAttendance = (Attendance) other;
        return attendance.equals(otherAttendance.attendance);
    }

    @Override
    public int hashCode() {
        return attendance.hashCode();
    }
}
