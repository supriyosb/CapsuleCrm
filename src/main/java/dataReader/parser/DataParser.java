package dataReader.parser;

import com.google.common.base.Strings;
import dataReader.Table;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataParser implements TableParser {

    private static final DataFormatter DATA_FORMATTER = new DataFormatter();
    private final Sheet sheet;

    public DataParser(Sheet sheet) {
        this.sheet = sheet;
    }

    public static DataParser fromXls(InputStream input, int sheetIndex) throws IOException {
        return new DataParser((new HSSFWorkbook(input)).getSheetAt(sheetIndex));
    }

    @Override
    public Table readFile() throws IOException {
        int lastRowNum = this.sheet.getLastRowNum();
        List<List<String>> content = new ArrayList(lastRowNum);
        List<String> header = new ArrayList();
        Row firstRow = this.sheet.getRow(0);
        short lastCellNum = firstRow.getLastCellNum();

        for(short columnIndex = 0; columnIndex < lastCellNum; ++columnIndex){
            String currentValue = firstRow.getCell(columnIndex).getStringCellValue();
            if(Strings.isNullOrEmpty(currentValue)){
                System.out.println("Sheet: " + this.sheet.getSheetName() + " Column is empty --> rest will be ignored: " + columnIndex);
                lastCellNum = columnIndex;
                break;
            }
            header.add(firstRow.getCell(columnIndex).getStringCellValue());
        }

        for(int rowIndex = 1; rowIndex <= lastRowNum; ++rowIndex){
            Row row = this.sheet.getRow(rowIndex);
            List<String> rowContent = new ArrayList(lastCellNum);
            content.add(rowContent);

            for (int columnIndex = 0; columnIndex < lastCellNum; ++columnIndex){
                if (row != null){
                    rowContent.add(getCellValue(row.getCell(columnIndex)));
                }
            }
        }
        return new Table(header, content);
    }

    private static String getCellValue(Cell cell){
        if (cell == null){
            return "";
        } else {
            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue();
        }
    }
}
