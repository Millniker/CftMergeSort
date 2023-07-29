package ru.abramov.reader;

import ru.abramov.exceptions.ReaderException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public abstract class Reader<T extends Comparable<T>>{
    protected final String filename;
    protected final Scanner scanner;
    protected T element;
    protected T prevElement;

    public Reader(String filename) throws ReaderException {
        this.filename = filename;

        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            this.scanner = new Scanner(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new ReaderException(filename + " file was not found");
        }

        var optionalElement = readNext();
        if (optionalElement.isEmpty()) {
            scanner.close();
            throw new ReaderException("There is no valid lines in the file " + filename +
                    ". Data from file will not be included in the output file");
        }
        this.element = optionalElement.get();
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.prevElement = this.element;
        this.element = element;
    }

    public T getPrevElement() {
        return prevElement;
    }

    public abstract Optional<T> readNext();

    public void close() {
        scanner.close();
    }
}
