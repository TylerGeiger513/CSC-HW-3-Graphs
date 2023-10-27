import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    // directed java graph
    private int vertices;
    private HashMap<Integer, ArrayList<Integer>> adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }
 
    public void reverse() {
        HashMap<Integer, ArrayList<Integer>> newAdj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++) {
            newAdj.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                newAdj.get(adj.get(i).get(j)).add(i);
            }
        }
        adj = newAdj; 
    }

    // returns the number edges pointing to edge V
    public int countInDegree(int v) {
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            if (adj.get(i).contains(v)) {
                count++;
            }
        }
        return count;
    }

    // returns the number of edges pointing from edge V
    public int countOutDegree(int v) {
        return adj.get(v).size();
    }

    
    // returns an arraylist of the nodes with the maximum in degree <[node, degree]>
    public ArrayList<int[]> maxInDegree() {
        int max = -1;
        ArrayList<int[]> nodes = new ArrayList<int[]>();
        for (int i = 0; i < vertices; i++) {
            int[] node = new int[2];
            node[0] = i;
            node[1] = countInDegree(i);
            if (node[1] > max) {
                max = node[1];
                nodes.clear();
                nodes.add(node);
            } else if (node[1] == max) {
                nodes.add(node);
            }
        }
        return nodes;
    }

    // returns an arraylist of the nodes with the maximum out degree <[node, degree]>
    public ArrayList<int[]> maxOutDegree() {
        int max = -1;
        ArrayList<int[]> nodes = new ArrayList<int[]>();
        for (int i = 0; i < vertices; i++) {
            int[] node = new int[2];
            node[0] = i;
            node[1] = countOutDegree(i);
            if (node[1] > max) {
                max = node[1];
                nodes.clear();
                nodes.add(node);
            } else if (node[1] == max) {
                nodes.add(node);
            }
        }
        return nodes;
    }
    

    public String toString() {
        String s = "";
        for (int i = 0; i < vertices; i++) {
            s += i + ": ";
            for (int j = 0; j < adj.get(i).size(); j++) {
                s += adj.get(i).get(j) + " ";
            }
            s += "\n";
        }
        return s;
    }
}
