package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_FILE_NAME_TOO_LONG;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_INVALID_FILE_NAME;

import java.io.File;

import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ExportCommand object
 */
public class ExportCommandParser implements Parser<ExportCommand> {
    public static final String VALIDATION_REGEX = "^[a-zA-Z0-9_]*$";
    public static final int MAX_FILENAME_LENGTH = 100;

    /**
     * Parses the given {@code String} of arguments in the context of the ExportCommand
     * and returns an ExportCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ExportCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        boolean fileNameTooLong = trimmedArgs.length() > MAX_FILENAME_LENGTH;
        boolean isValidFileName = trimmedArgs.matches(VALIDATION_REGEX);

        if (args.isEmpty()) {
            throw new ParseException((String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ExportCommand.MESSAGE_USAGE)));
        }

        if (!isValidFileName) {
            throw new ParseException(MESSAGE_INVALID_FILE_NAME);
        }

        if (fileNameTooLong) {
            throw new ParseException(MESSAGE_FILE_NAME_TOO_LONG);
        }

        File exportedFile = ParserStudentUtil.parseFileName(args);
        return new ExportCommand(exportedFile);
    }
}
