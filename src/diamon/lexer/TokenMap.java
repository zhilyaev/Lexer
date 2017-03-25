package diamon.lexer;

import java.util.HashMap;

class TokenMap extends HashMap<String,String>{

    TokenMap(){

       for(TokenEnum tok: TokenEnum.values()){
           this.put(tok.name(),tok.toString());
       }

    }
}// TokenMap