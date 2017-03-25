package diamon.lexer;


public class Main {

    public static void main(String[] args) {

        TokenMap tokenMap = new TokenMap();
        tokenMap.put("DIGITS","[0-9]");
        Lexer lexer = new Lexer("5+7", tokenMap);
        System.out.println(lexer.getTokens());

    }


}
