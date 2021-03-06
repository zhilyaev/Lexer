# HOW TO USE IT?

### Default TokenMap
```java
Lexer lexer1 = new Lexer("+ / * -");
System.out.println(lexer1.getTokens());
```
> PRINT : [OPERAND, WHITESPACE, OPERAND, WHITESPACE, OPERAND, WHITESPACE, OPERAND]

### Custom TokenMap
```java
TokenMap tokenMap2 = new TokenMap();
tokenMap2.put("DIGIT","[0-9]");
Lexer lexer2 = new Lexer("5+7", tokenMap2);
System.out.println(lexer2.getTokens());
```
> PRINT : [DIGIT, OPERAND, DIGIT]


### Custom TokenMap with use TokenMap
```java     
TokenMap tokenMap3 = new TokenMap();
tokenMap3.put("DIGIT","[0-9]");
tokenMap3.put("NUMBER","[1-9]"+tokenMap3.get("DIGIT"));
Lexer lexer3 = new Lexer("15",tokenMap3);
System.out.println(lexer3.getTokens());
```
> PRINT : [NUMBER]

### Custom TokenMap with use TokenEnum     
```java
TokenMap tokenMap4= new TokenMap();
tokenMap4.put("DIGIT","[0-9]");
tokenMap4.put("NUMBER","[1-9]"+tokenMap4.get("DIGIT"));
tokenMap4.put("EXP",tokenMap4.get("NUMBER")+TokenEnum.OPERAND+tokenMap4.get("NUMBER"));
Lexer lexer4 = new Lexer("15+30",tokenMap4);
System.out.println(lexer4.getTokens());
```
> PRINT : [DIGIT, OPERAND, DIGIT]


### You can extend [TokenEnum](https://github.com/zhilyaev/Lexer/blob/master/src/diamon/lexer/TokenEnum.java)

```java
public enum TokenEnum {

    // U should add your token here:

    OPERAND("[*|/|+|-]"),
    NUMBER("\\d"),
    WHITESPACE("[ \t\f\r\n]+");
    
    ...
 }
    
```
