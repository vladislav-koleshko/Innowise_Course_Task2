package com.inkspac3.course.composite;

public class Symbol implements TextComponent{
    private String symbol;
    private TextComponentType type;

    public Symbol(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String getText() {
        return symbol;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public void setComponentType(TextComponentType type) {
        this.type = type;
    }
}