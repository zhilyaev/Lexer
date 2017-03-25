package diamon.lexer;


public class Main {

    public static void main(String[] args) {

        // HOW USE?

        // Default TokenMap
        Lexer lexer1 = new Lexer("+ / * -");
        System.out.println(lexer1.getTokens());


        // Custom TokenMap
        TokenMap tokenMap2 = new TokenMap();
        tokenMap2.put("DIGIT","[0-9]");
        Lexer lexer2 = new Lexer("5+7", tokenMap2);
        System.out.println(lexer2.getTokens());

        // Custom TokenMap with use TokenMap
        TokenMap tokenMap3 = new TokenMap();
        tokenMap3.put("DIGIT","[0-9]");
        tokenMap3.put("NUMBER","[1-9]"+tokenMap3.get("DIGIT"));
        Lexer lexer3 = new Lexer("15",tokenMap3);
        System.out.println(lexer3.getTokens());

        // Custom TokenMap with use TokenEnum
        TokenMap tokenMap4= new TokenMap();
        tokenMap4.put("DIGIT","[0-9]");
        tokenMap4.put("NUMBER","[1-9]"+tokenMap4.get("DIGIT"));
        tokenMap4.put("EXP",tokenMap4.get("NUMBER")+TokenEnum.OPERAND+tokenMap4.get("NUMBER"));
        Lexer lexer4 = new Lexer("15+30",tokenMap4);
        System.out.println(lexer4.getTokens());

    }


}
