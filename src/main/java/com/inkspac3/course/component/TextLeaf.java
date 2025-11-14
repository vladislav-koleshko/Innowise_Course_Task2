package com.inkspac3.course.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextLeaf implements TextComponent {
    private static final Logger log = LogManager.getLogger();
    private final char symbol;
    private final TextComponentType type;

    public TextLeaf(char symbol, TextComponentType type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        log.error("Leaf can't contain children");
        throw new UnsupportedOperationException("Leaf can't contain children");
    }

    @Override
    public void remove(TextComponent component) {
        log.error("Leaf can't contain children");
        throw new UnsupportedOperationException("Leaf can't contain children");
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
