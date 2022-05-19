package com.example.demo;

public class Node {

    private  String name;
    private boolean isMovie;
    public Node(String name ,  boolean isMovie){
        this.isMovie = isMovie;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean isMovie() {
        return isMovie;
    }

    public boolean equals(Object obj){
        Node node = (Node) obj;
        return this.name.equals(node.getName());
    }

    public int hashCode(){
        return this.name.hashCode();
    }

}
