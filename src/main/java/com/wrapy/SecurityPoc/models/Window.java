package com.wrapy.SecurityPoc.models;

import org.springframework.stereotype.Component;

@Component
public class Window {
    public int length;
    public int width;

    public Window(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Window() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int area(){
        return length*width;
    }
}
