package dataReader.parser;

import com.google.common.base.Objects;
import dataReader.Table;
import dataReader.transformer.StringIdentityTransformer;
import dataReader.transformer.Transformer;
import exceptions.AutomationFrameworkException;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public final class ExcelParser<T> {

    private static final Map<Class<?>, Transformer<?>> transformers = new HashMap();
    private final Table table;
    private final Class<T> modelClass;

    static{
        registerTransformer(String.class, new StringIdentityTransformer());
    }

    /**
     * Constructor
     * It will initialize the Table object and Class object
     * @param table
     * @param modelClass
     */
    public ExcelParser(Table table, Class<T> modelClass) {
        this.table = table;
        this.modelClass = modelClass;
    }

    /**
     * It will return the data list
     * @param tableParser
     * @param modelClass
     * @param <T>
     * @return
     */
    public static <T>List<T> toModelList(TableParser tableParser, Class<T> modelClass){
        try{
            return (new ExcelParser(tableParser.readFile(), modelClass)).map();
        } catch (IllegalAccessException | IOException | InstantiationException var3){
            throw new RuntimeException("Can't map to model", var3);
        }
    }

    public static <T> void registerTransformer(Class<T> targetClass, Transformer<T> transformer){
        transformers.put(targetClass, transformer);
    }

    /**
     * It will map the data
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    List<T> map() throws IllegalAccessException, InstantiationException{
        List<T> mappedModels = new ArrayList(this.table.getData().size());
        List<Field> fieldList = fieldList(this.table.getHeader(), this.modelClass);
        Iterator var4 = this.table.getData().iterator();

        while (var4.hasNext()){
            List<String> row = (List)var4.next();
            T model = this.modelClass.newInstance();

            for (int i=0; i<row.size(); i++){
                Field field = (Field)fieldList.get(i);
                String value = (String) row.get(i);
                if (field == null){

                } else {
                    Class<?> fieldType = field.getType();
                    if(!transformers.containsKey(fieldType)){

                    }
                    Object transformedValue = ((Transformer)transformers.get(fieldType)).transform(value);
                    if (!fieldType.isPrimitive() || transformedValue !=null){
                        FieldUtils.writeField(field, model, transformedValue, true);
                    }
                }
            }
            mappedModels.add(model);
        }
        return mappedModels;
    }

    /**
     * It will return the list of Fields
     * @param headers
     * @param clazz
     * @return
     */
    private static List<Field> fieldList(List<String> headers, Class<?> clazz){
        boolean found = false;
        Field[] allFields = FieldUtils.getAllFields(clazz);
        List<Field> fields = new ArrayList(allFields.length);
        StringBuffer avail = new StringBuffer();
        Field[] var9 = allFields;
        int var8 = allFields.length;

        for(int var7 = 0; var7 < var8; ++var7){
            Field field = var9[var7];
            avail.append(field.getName() + " ; ");
        }

        Iterator var14 = headers.iterator();

        while (var14.hasNext()){
            String header = (String) var14.next();
            found = false;
            Field fieldToAdd = null;
            Field[] var12 = allFields;
            int var11 = allFields.length;

            for(int var10 = 0; var10 < var11; ++var10){
                Field field = var12[var10];
                if(header.trim().equalsIgnoreCase(field.getName())){
                    fieldToAdd = field;
                    found = true;
                    break;
                }
            }

            fields.add(fieldToAdd);
            if (!found){

            }
        }
        return fields;
    }
}
