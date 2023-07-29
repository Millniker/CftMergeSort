package ru.abramov.reader;

import ru.abramov.exceptions.ReaderException;

import java.util.Optional;

public class StringReader extends Reader<String> {

    public StringReader(String filename) throws ReaderException {
        super(filename);
    }

    @Override
    public Optional<String> readNext() {

        String nextLine;

        do {
            if (!scanner.hasNext()) {
                return Optional.empty();
            }
            nextLine = scanner.nextLine();
        } while (nextLine.contains(" "));

        return Optional.of(nextLine);
    }
}
