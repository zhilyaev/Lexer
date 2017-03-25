package diamon.spuusk;


public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer("a+b-84+abc");
        lexer.tokenMap.addToken("alphabet","[a-z]");
        lexer.tokenMap.addToken("identificator", lexer.tokenMap.getToken("alphabet")+Lexer.TokenMap.TokenEnum.NUMBER);
        System.out.println(lexer.getTokens());

    }


}
