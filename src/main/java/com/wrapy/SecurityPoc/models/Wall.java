package com.wrapy.SecurityPoc.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Wall {
    public int length;
    public  int width;
    @Autowired
    public List<Window> windows;

    public Wall(int length, int width, List<Window> windows) {
        this.length = length;
        this.width = width;
        this.windows = windows;
    }

    public Wall() {
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

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }
    public int area()
    {
        int area1=length*width;
        for(Window w :windows){
            area1=area1-(w.getLength()*w.getWidth());
        }
        return area1;
    }
}
