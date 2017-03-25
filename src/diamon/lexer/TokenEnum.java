package diamon.lexer;

public enum TokenEnum {

    // U should add your token here:

    OPERAND("[*|/|+|-]"),
    //NUMBER("\\d"),
    WHITESPACE("[ \t\f\r\n]+");


    private final String pattern;

    TokenEnum(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return this.pattern;
    }

}