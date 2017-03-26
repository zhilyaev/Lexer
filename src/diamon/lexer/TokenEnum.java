package diamon.lexer;

public enum TokenEnum {

    // U should add your token here:

    //NUMBER("\\d"),
    WHITESPACE("\\s"),
    AB("a|b"),
    OPEN("\\("),
    CLOSE("\\)"),
    Y("\\*"),
    Z("\\+");




    private final String pattern;

    TokenEnum(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return this.pattern;
    }

}