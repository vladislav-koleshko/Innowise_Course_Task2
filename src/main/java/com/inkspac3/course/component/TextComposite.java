package com.inkspac3.course.component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final TextComponentType type;
    private final List<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent component : components) {
            builder.append(component.toString());
            if (type == TextComponentType.SENTENCE) builder.append(" ");
            if (type == TextComponentType.PARAGRAPH) builder.append("\n");
        }
        return builder.toString().trim();
    }
}

