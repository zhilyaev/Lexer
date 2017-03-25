package diamon.spuusk;

import java.util.EnumMap;

public class TokenMap  {
    private EnumMap<TokenEnum, String> map = new EnumMap<>(TokenEnum.class);
    protected enum TokenEnum {

        // U can add your token here:

        OPERAND("[*|/|+|-]"),
        DIGEST("[0-9]"),
        NUMBER("[1-9]"+DIGEST),
        WHITESPACE("[ \t\f\r\n]+");

        TokenEnum(String pattern) {
            this.pattern = pattern;
        }
        public final String pattern;

        @Override
        public String toString() {
            return this.pattern;
        }
    }

    TokenMap(){

    }

    @Override
    public String toString() {
        return "Token map: " + map;
    }
}
