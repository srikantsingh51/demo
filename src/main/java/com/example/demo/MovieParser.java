package com.example.demo;

import java.io.*;
import java.util.*;

import static java.util.Arrays.asList;

public class MovieParser {

    public static Map<String,Set> heros = new HashMap();

    public static Map<String,Integer> indexs = new HashMap();

    public List<Node> getNodes() throws IOException {
         List<Node> nodes = new ArrayList<>();
        FileReader fileReader = new FileReader("src/main/resources/Movies.text");

        BufferedReader buffReader
                = new BufferedReader(
                fileReader);

        while (buffReader.ready()) {

            String []  movie =buffReader.readLine().split("/");
            List<String> list = Arrays.asList(movie);
            boolean isMovie = false ;
            String movieName = null;
            for(int i=0;i<list.size();i++){
                if(i==0) {
                    isMovie = true;
                    movieName = list.get(i);
                }
                Node node1 = new Node(list.get(i),isMovie);
                if(i>0) {
                    if ( heros.containsKey(list.get(i))){
                       Set<String> list1 = heros.get(list.get(i));
                       list1.add(movieName);
                       heros.put(list.get(i),list1);
                    }else {
                        LinkedHashSet<String> newList = new LinkedHashSet();
                        newList.add(movieName);
                        heros.put(list.get(i),newList);
                    }
                }
                if(!nodes.contains(node1)) {
                    nodes.add(node1);
                    indexs.put(list.get(i), nodes.size() - 1);
                }
                isMovie = false;
            }



        }
        /*HashSet<Node> set = new HashSet<>();
        set.addAll(nodes);
        nodes.clear();
        nodes.addAll(set);*/
          return nodes;
    }

    public static void main(String [] args) throws Exception{
        MovieParser mp = new MovieParser();
        List<Node> movies = mp.getNodes();

        System.out.print(movies);
    }


}
