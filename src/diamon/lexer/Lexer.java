package diamon.lexer;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lexer {
    private TokenMap tokenMap;
    private ArrayList<String> tokens;


    Lexer (String input, TokenMap tokenMap) {
        this.tokenMap = tokenMap;
        this.tokens = lex(input);
    }
    Lexer (String input) {
        this.tokenMap = new TokenMap();
        this.tokens = lex(input);

    }

    private ArrayList<String> lex(String input) {
        ArrayList<String> tokens = new ArrayList<>();

        StringBuffer buffer = new StringBuffer();
        for(Map.Entry token : tokenMap.entrySet()) {
            buffer.append(String.format("|(?<%s>%s)", token.getKey(), token.getValue()));
        }

        Pattern tokenPatterns = Pattern.compile(buffer.substring(1));
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            int i = 1;
            for(String name : tokenMap.keySet()){
                    if(matcher.group(i) != null){
                        tokens.add(name); // {Здесь можно сделать генерацию кода}
                        break;
                    }//else tokens.add()
                    i++;
            }

        }
        return tokens;
    }

    ArrayList<String> getTokens() {
        return tokens;
    }

}// Lexer
