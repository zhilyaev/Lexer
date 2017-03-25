package diamon.spuusk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    TokenMap tokenMap = new TokenMap();
    private ArrayList<String> tokens = new ArrayList<>();
    Lexer (String input){
      tokens = lex(input);
    }

    public ArrayList<String> getTokens() {
        return tokens;
    }

    public ArrayList<String> lex(String input) {
        ArrayList<String> tokens = new ArrayList<>();

        String tmp = null;
        for(String name : TokenMap.map.keySet())
            tmp+=TokenMap.map.get(name);

        Pattern tokenPatterns = Pattern.compile(String.valueOf(tmp));
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            for(String name : TokenMap.map.keySet()){
                    if(matcher.group(name) != null){
                        tokens.add(name);
                        break;
                    }
            }
        }
        return tokens;
    }

    static class TokenMap  {

        static HashMap<String, String> map = new HashMap<>();

        public enum TokenEnum {
            // U should add your token here:

            OPERAND("[*|/|+|-]"),
            DIGEST("[0-9]"),
            NUMBER("[1-9]"+DIGEST),
            WHITESPACE("[ \t\f\r\n]+");


            private final String pattern;

            TokenEnum(String pattern) {
                this.pattern = pattern;
                map.put(this.name(),this.pattern);
            }

            @Override
            public String toString() {
                return this.pattern;
            }

        }

        TokenMap(){
            // map is empty, because TokenEnum not used
            TokenEnum.values();
        }

        @Override
        public String toString() {
            return "Tokens map: " + map ;
        }

        // Also u can add token
        void addToken(String name, String pattern){
            map.put(name,pattern);
        }

        String getToken(String name){
            return map.get(name);
        }

    }

}// Lexer
