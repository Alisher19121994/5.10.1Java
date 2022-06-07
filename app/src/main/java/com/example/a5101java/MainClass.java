package com.example.a5101java;

import java.util.ArrayList;

public class MainClass {
    Posts posts;
    ArrayList<Story> story = new ArrayList();

    public MainClass(Posts posts) {
        this.posts = posts;
    }

    public MainClass(ArrayList<Story> story) {
        this.story = story;
    }
}
