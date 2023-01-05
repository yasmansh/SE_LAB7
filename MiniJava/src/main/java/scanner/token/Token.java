package scanner.token;

import scanner.type.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token {
    public Type type;
    public String value;

    private String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }

    private Type getType() {
        return type;
    }

    private void setType(Type type) {
        this.type = type;
    }

    public Token(Type type, String value) {
        setType(type);
        setValue(value);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", getType().name(), getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Token) {
            Token temp = (Token) o;
            if (temp.getType() == this.getType()) {
                return this.getType() != Type.KEYWORDS || this.getValue().equals(temp.getValue());
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (getType() == Type.KEYWORDS) ?
                prime * getType().hashCode() + (getValue() == null ? 0 : getValue().hashCode()):getType().hashCode();
    }

    public static Type getTyepFormString(String s) {
        Pattern pattern;
        Matcher matcher;
        for (Type t : Type.values()) {
            if (t.toString().equals(s)) return t;
        }
        for (Type t : Type.values()) {
            pattern = Pattern.compile(t.pattern);
            matcher = pattern.matcher(s);
            if (matcher.matches()) return t;
        }

//        if (s.equals("class")||s.equals("extends")||s.equals("public")||s.equals("static")||s.equals("void")||s.equals("return")||s.equals("main")||
//                s.equals("boolean")||s.equals("int")||s.equals("if")||s.equals("else")||s.equals("while")||s.equals("true")||s.equals("false")||s.equals("System.out.println")) {
//            return KEYWORDS;
//        }else if(s.equals("")){
//
//        }else if(s.equals("")){
//
//        }
        throw new IllegalArgumentException();
    }
}
