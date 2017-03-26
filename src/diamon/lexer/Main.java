package diamon.lexer;

public class Main {



    public static void main(String[] args) {

        Lexer lexer = new Lexer("(a+a)*(b+b)*b");
        System.out.println("Lexer -> "+lexer.getTokens());
        Grammar grammar = new Grammar(lexer);
        System.out.println("ANSWER => "+grammar.result());

    }


}
