package dataReader.transformer;

public class StringIdentityTransformer implements Transformer<String> {

    public StringIdentityTransformer(){

    }

    public String transform(String source) {
        return source;
    }
}
