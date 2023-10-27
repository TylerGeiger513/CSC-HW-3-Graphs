import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Graph figA = new Graph(6);
        Graph figD = new Graph(7);
        Graph figC = new Graph(7);
        
        figA.addEdge(0, 2);
        figA.addEdge(0, 4);
        figA.addEdge(0, 5);

        figA.addEdge(1, 5);

        figA.addEdge(2, 3);
        figA.addEdge(2, 4);

        figA.addEdge(4, 1);
        figA.addEdge(4, 5);


        figC.addEdge(1, 3);
        figC.addEdge(2, 1);
        figC.addEdge(3, 2);
        figC.addEdge(4, 0);
        figC.addEdge(4, 2);
        figC.addEdge(5, 0);
        figC.addEdge(5, 4);
        figC.addEdge(6, 1);
        figC.addEdge(6, 2);
        figC.addEdge(6, 4);

        figD.addEdge(0, 3);
        figD.addEdge(0, 6);
        figD.addEdge(2, 1);
        figD.addEdge(3, 5);
        figD.addEdge(4, 0);
        figD.addEdge(5, 0);
        figD.addEdge(6, 1);
        figD.addEdge(6, 2);
        figD.addEdge(6, 4);

        ArrayList<Graph> figures = new ArrayList<Graph>();
        figures.add(figA);
        figures.add(figC);
        figures.add(figD);

        for (Graph fig : figures) {
            fig.reverse();
            System.out.println("Running on graph:");
            ArrayList<int[]> maxInDegree = fig.maxInDegree();
            ArrayList<int[]> maxOutDegree = fig.maxOutDegree();

            for (int[] inDegree : maxInDegree) {
                System.out.println("Node-" + inDegree[0] + " has the maximum in-degree of " + inDegree[1]);
            }

            for (int[] outDegree : maxOutDegree) {
                System.out.println("Node-" + outDegree[0] + " has the maximum out-degree of " + outDegree[1]);
            }
        }
       


    }
}
