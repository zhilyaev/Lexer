package diamon.lexer;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lexer {
    private TokenMap tokenMap;
    private ArrayList<String> tokens = new ArrayList<>();

    //private Iterator<String> iterator;
    Lexer (String input, TokenMap tokenMap) {
        this.tokenMap = tokenMap;
        lex(input);
    }
    Lexer (String input) {
        this.tokenMap = new TokenMap();
        lex(input);
    }

    private void lex(String input) {
        StringBuffer buffer = new StringBuffer();
        for(Map.Entry token : tokenMap.entrySet()) {
            buffer.append(String.format("|(?<%s>%s)", token.getKey(), token.getValue()));
        }

        //System.out.println(buffer);

        // Lex logic
        Pattern tokenPatterns = Pattern.compile(buffer.substring(1));
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            int i = 1;
            for(String name : tokenMap.keySet()){
                    if(matcher.group(i) != null){
                        tokens.add(name); // {Здесь можно сделать генерацию кода}
                        break;
                    }
                    i++;
            }

        }
    }

    private int current_i = 0;
    public String current(){
        if (current_i>=tokens.size()) return null;
       else return tokens.get(current_i);
    }

    public String next(){
        current_i++;
        if (current_i>=tokens.size()) return null;
        else return tokens.get(current_i);
    }

    ArrayList<String> getTokens() {
        return tokens;
    }

}// Lexer
