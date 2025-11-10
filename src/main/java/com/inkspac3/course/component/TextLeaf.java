package com.inkspac3.course.component;

public class TextLeaf implements TextComponent {
    private final char symbol;
    private final TextComponentType type;

    public TextLeaf(char symbol, TextComponentType type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Leaf can't contain children");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Leaf can't contain children");
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
