package dataReader;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Table {

    private final List<String> header;
    private final List<List<String>> data;

    /**
     * Constructor
     * It will initialize list of header object and list of data object
     * @param header
     * @param data
     */
    public Table(List<String> header, List<List<String>> data) {
        this.header = Collections.unmodifiableList((List) Objects.requireNonNull(header));
        this.data = Collections.unmodifiableList(data);
    }

    /**
     * It will return header list
     * @return
     */
    public List<String> getHeader() {
        return header;
    }

    /**
     * It will return list of data list
     * @return
     */
    public List<List<String>> getData() {
        return data;
    }
}
