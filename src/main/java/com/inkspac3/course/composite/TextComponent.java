package com.inkspac3.course.composite;

public interface TextComponent {
    String getText();
    TextComponentType getType();
    void setComponentType(TextComponentType type);
}
