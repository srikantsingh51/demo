package com.example.demo;

import java.util.*;

public class DegreeOfSeperation {

    // Driver Program
    public static void main(String args[]) throws Exception{

        MovieParser mp = new MovieParser();
        pathUnweighted pu = new pathUnweighted();
        int v = mp.getNodes().size();

        // Adjacency list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        Set<String> set = MovieParser.heros.keySet();

        set.parallelStream().forEach(element -> {
            try {
                int index1 = MovieParser.indexs.get(element);
                Set<String> subList = MovieParser.heros.get(element);
                for (String movie : subList) {
                    pu.addEdge(adj, index1,  MovieParser.indexs.get(movie));
                }
            }catch(Exception e){

            }
        });
        /*for(String name : set){
         int index1 = mp.getNodes().indexOf(new Node(name,false));
         Set<String> subList = MovieParser.heros.get(name);
         for(String movie: subList) {
             pu.addEdge(adj, index1, mp.getNodes().indexOf(new Node(movie,false)));
         }
        }*/


        int source =  mp.getNodes().indexOf(new Node("Brown, Bryan (I)", false)),
                dest = mp.getNodes().indexOf(new Node("Boutsikaris, Dennis", false));
        pu.printShortestDistance(adj, source, dest, v);

    }
}
