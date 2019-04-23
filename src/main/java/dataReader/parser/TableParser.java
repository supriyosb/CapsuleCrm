package dataReader.parser;

import dataReader.Table;

import java.io.IOException;

public interface TableParser {

    Table readFile() throws IOException;
}
