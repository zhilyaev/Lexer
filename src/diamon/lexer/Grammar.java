package diamon.lexer;


import java.util.ArrayList;

class Grammar {

    private Lexer lexer;

    private boolean error(){
        System.out.println("TOKEN -> "+lexer.current());
        return false;
    }

    private boolean error(String msg){
        System.out.println("FUNCTION -> "+msg);
        return error();
    }

    Grammar(Lexer lexer){
        this.lexer = lexer;
    }

    public boolean result(){
        return axiom();
    }

    private boolean axiom(){
        // Можно оставить только return E();
        if(lexer.current()=="AB" || lexer.current()=="OPEN") return E();
        else return error("AXIOM");
    }

    private boolean E(){
        // Можно оставить только return T();
        if(lexer.current()=="AB" || lexer.current()=="OPEN") return T();
        else return error("F");
    }

    private boolean T(){
        // Можно оставить только return F();
        if(lexer.current()=="AB" || lexer.current()=="OPEN") return F();
        else return error("T");
    }

    private boolean Z() {
        if(lexer.current()=="Z"){
            lexer.next();
            return T();
        }else return error("Z");
    }

    private boolean Y() {
        if(lexer.current()=="Y"){
            lexer.next();
            return F();
        }else return error("Y");
    }

    private boolean F(){
        if(lexer.current()=="AB"){
            //System.out.println("=> a|b");
            /* <Предсказывающий> */
            if(lexer.next()=="CLOSE"){
                //System.out.println("=> )");
                return true;
            }else if(lexer.current()=="Y"){
                //System.out.println("=> *");
                return Y();
            }
            else if (lexer.current()=="Z"){
                //System.out.println("=> +");
                return Z();
            }
            /* </Предсказывающий> */
            return true;
        }else if (lexer.current()=="OPEN"){
            //System.out.println("=> (");
            lexer.next();
            return E();
        }
        else return error("F");
    }
}
