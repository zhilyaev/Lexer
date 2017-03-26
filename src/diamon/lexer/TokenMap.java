package diamon.lexer;

import java.util.HashMap;

class TokenMap extends HashMap<String,String>{

    TokenMap(){

       for(TokenEnum tok: TokenEnum.values()){
           this.put(tok.name(),tok.toString());
       }

    }

    @Override
    public String put(String key, String value) {
        return super.put(key.toUpperCase(), value);
    }

    public String get(String key) {
        return super.get(key.toUpperCase());
    }
}// TokenMap