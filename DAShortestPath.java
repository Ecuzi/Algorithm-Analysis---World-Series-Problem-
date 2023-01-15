//Course: CS4306 W02
//Student Name: Ethan Fitzgerald
//Assignment: #3
//Due Date: November 20, 2022
//Signature: Ethan Fitzgerald
//Score:

import java.util.*;
import java.util.Arrays;

public class DAShortestPath {
    //      2d Array to Store DAShortestPath. 2 cells will be updated with every add.
    int[][] SPMatrix;
    int vertices;


    DAShortestPath(int[][] spMat, int vertices) {
        SPMatrix = spMat;
        this.vertices = vertices;

    }



    public static int shortestAdjNode(int[] dist, boolean[] visited) {
        int minimum = Integer.MAX_VALUE;
        //      This represents infinity in D's Algorithm
        int index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < minimum)
                if (visited[i] == false) {
                    minimum = dist[i];
                    index = i;
                }
        }
        return index;
        //      returns the index of the unvisited Node or Cell.
    }
    void addNode(int source, int destination, int weightEdge) {
        //      Two initializations inside matrix to keep account of both vertices.
        SPMatrix[source][destination] = weightEdge;
        SPMatrix[destination][source] = weightEdge;
    }

    public static int[] ShortestPathAlgorithm (DAShortestPath d, int source) {
        //      Display of Algorithm Array
        int[] dist = new int[d.vertices];

        boolean[] visited = new boolean[d.vertices];

        // Sets the Nodes to infinite and the visited array to false.
        for (int i = 0; i < d.vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;

        }

        dist[source] = 0;

        for (int i = 0; i < d.vertices; i++) {
            int shortestVertex = shortestAdjNode(dist, visited);
            //Checks closest vertex.

            if (shortestVertex == Integer.MAX_VALUE)
                return dist;

            visited[shortestVertex] = true;



            for (int j = 0; j < d.vertices; j++) {
                if (visited[j] == false) {

                    if (d.SPMatrix[shortestVertex][j] != 0) {

                        int x = dist[shortestVertex] + d.SPMatrix[shortestVertex][j];

                        if (x < dist[j]) {
                            dist[j] = x;

                        }

                    }
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) {
        int numOfVertices = 12;
        int[][] dag = new int[13][13];
        DAShortestPath DAShortestPath = new DAShortestPath(dag, numOfVertices);

        DAShortestPath.addNode(0, 2, 3);
        DAShortestPath.addNode(0, 1, 6);
        DAShortestPath.addNode(2, 4, 1);
        DAShortestPath.addNode(2, 1, 4);
        DAShortestPath.addNode(2, 3, 1);
        DAShortestPath.addNode(1, 3, 3);
        DAShortestPath.addNode(1, 5, 7);
        DAShortestPath.addNode(3, 4, 2);
        DAShortestPath.addNode(3, 7, 3);
        DAShortestPath.addNode(3, 6, 6);
        DAShortestPath.addNode(3, 5, 5);
        DAShortestPath.addNode(4, 7, 10);
        DAShortestPath.addNode(5, 6, 10);
        DAShortestPath.addNode(6, 7, 4);
        DAShortestPath.addNode(6, 8, 7);
        DAShortestPath.addNode(6, 10, 10);
        DAShortestPath.addNode(6, 9, 5);
        DAShortestPath.addNode(7, 8, 2);
        DAShortestPath.addNode(8, 10, 6);
        DAShortestPath.addNode(9, 10, 3);
        DAShortestPath.addNode(9, 11, 1);
        DAShortestPath.addNode(10, 11, 4);



        int[] array = ShortestPathAlgorithm(DAShortestPath, 0);

        for(int i = 0; i < array.length; i++) {
            System.out.println("Total Weight to get to vertex " + i + ": " + array[i]);
        }

        System.out.println("\n\nWeight from 0 -> 2: 3");
        System.out.println("Weight from 2 -> 3: 1");
        System.out.println("Weight from 3 -> 6: 6");
        System.out.println("Weight from 6 -> 9: 5");
        System.out.println("Weight from 9 -> 11: 1");
        System.out.println("Total Weight from Source 0 -> 11 = 16");

    }
}


