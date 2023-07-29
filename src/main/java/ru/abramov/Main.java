package ru.abramov;

import org.apache.commons.cli.ParseException;
import ru.abramov.exceptions.ReaderException;
import ru.abramov.exceptions.SorterException;
import ru.abramov.reader.IntegerReader;
import ru.abramov.reader.Reader;
import ru.abramov.reader.StringReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ArgumentsParser.parse(args);
            SortInfo sortInfo = ArgumentsParser.getSortInfo();
            Sorter sorter = new Sorter(sortInfo);
            if(sortInfo.getInputType().equals(Integer.class)) {
                sorter.sort(makeIntegerReaders(sortInfo.getInputFilenames()));
            } else {
                sorter.sort(makeStringReaders(sortInfo.getInputFilenames()));
            }
        } catch (SorterException e) {
            System.err.println(e.getMessage());
            ArgumentsParser.printHelp();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Reader<Integer>> makeIntegerReaders(List<String> filenames) {
        List<Reader<Integer>> readers = new ArrayList<>();
        for (var filename: filenames) {
            try {
                readers.add(new IntegerReader(filename));
            } catch (ReaderException e) {
                System.err.println(e.getMessage());
            }
        }
        return readers;
    }

    private static List<Reader<String>> makeStringReaders(List<String> filenames) {
        List<Reader<String>> readers = new ArrayList<>();
        for (var filename: filenames) {
            try {
                readers.add(new StringReader(filename));
            } catch (ReaderException e) {
                System.err.println(e.getMessage());
            }
        }
        return readers;
    }
}