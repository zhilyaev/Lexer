package diamon.lexer;

public enum TokenEnum {

    // U should add your token here:

    OPERAND("[*|/|+|-]"),
    //DIGEST("[0-9]"),
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