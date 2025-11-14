package com.inkspac3.course.component;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);
    void remove(TextComponent component);
    List<TextComponent> getComponents();
    String toString();
}
