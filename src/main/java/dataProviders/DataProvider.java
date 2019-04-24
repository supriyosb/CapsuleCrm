package dataProviders;

import dataReader.parser.DataParser;
import dataReader.parser.ExcelParser;
import managers.FileReaderManager;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataProvider {

    /**
     * It will read the data from input file and return data provider object
     * @return
     * @throws FileNotFoundException
     */
    @org.testng.annotations.DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() throws FileNotFoundException {
        List<DataModel> model = null;
        Object arr[][] = null;
        try(InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getTestDataPath())) {
            model = ExcelParser.toModelList(DataParser.fromXls(inputStream, 0), DataModel.class);
            int size = model.size();
            arr = new Object[size][1];
            for (int i = 0; i<size; i++){
                arr[i][0] = model.get(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
