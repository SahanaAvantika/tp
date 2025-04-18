package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PARENT_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENT_NAME;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddStudentCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.Address;
import seedu.address.model.student.Attendance;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Phone;
import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddStudentCommandParser implements Parser<AddStudentCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddStudentCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_STUDENT_NAME, PREFIX_ID,
                        PREFIX_PARENT_NAME , PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS);

        if (!arePrefixesPresent(argMultimap, PREFIX_STUDENT_NAME, PREFIX_ID,
                PREFIX_PARENT_NAME , PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStudentCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_STUDENT_NAME, PREFIX_ID,
                PREFIX_PARENT_NAME , PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS);
        Name studetName = ParserStudentUtil.parseName(argMultimap.getValue(PREFIX_STUDENT_NAME).get());
        Name parentName = ParserStudentUtil.parseName(argMultimap.getValue(PREFIX_PARENT_NAME).get());
        Phone phone = ParserStudentUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Email email = ParserStudentUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        Address address = ParserStudentUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
        try {
            StudentId studentId = ParserStudentUtil.parseStudentId(argMultimap.getValue(PREFIX_ID).get());
            Student student = new Student(studetName, studentId, parentName, phone, email, address,
                    new Attendance(new HashSet<LocalDate>()));
            return new AddStudentCommand(student);
        } catch (ParseException e) {
            throw new ParseException(String.format(e.getMessage(), AddStudentCommand.MESSAGE_USAGE));
        }
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
