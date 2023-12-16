public class Graph {
    //1. Class 'Graph' with 2 count instances and a reference to adjacent matrix
    private int v_count;
    private int e_count;
    private int[][] adj;

    //2. Define method createGraph() to create and store adjacent node info.
    public void createGraph(int v_count, int e_count){
        this.v_count = v_count;
        this.e_count = e_count;
        adj = new int[this.v_count][this.e_count];
        for(int i=0; i<v_count; i++){
            for(int j=0; j<e_count; j++){
                adj[i][j] = 0;
            }
        }
    }

    //3. Define method to add edge
    public void addEdge(int from, int to){
        try{
            adj[from][to] = 1;
            adj[to][from] = 1;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("addEdge: Node doesn't exist.");
        }
    }

    //4. Define method to print graph matrix
    public void printGraphMatrix(){
        for(int i=0; i<v_count; i++){
            for(int j=0; j<e_count; j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }

    //5. Define method to print all the adjacent nodes of a given node.
    public void printAdjacentNodesOf(int node){
        try{
            for(int i=0; i<e_count; i++){
                if(adj[node][i]==1)
                    System.out.print(i+" ");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("printAdjacentNodesOf: Node doesn't exist.");
        }
    }

    //6. Define a method to check if a given node is isolated node.
    public boolean isIsolated(int node){
        for(int i=0; i<e_count; i++){
            if(adj[node][i]==1)
                return false;
        }
        return true;
    }

    //driver
    public static void driver(){
        Graph graph = new Graph();
        graph.createGraph(5,5);
        graph.printGraphMatrix();
        System.out.println();
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.printGraphMatrix();
        System.out.println("Nodes adjacent to 2: ");
        graph.printAdjacentNodesOf(2);
        System.out.println("\nIs 0 isolated? \n"+graph.isIsolated(0));
        System.out.println("\nIs 1 isolated? \n"+graph.isIsolated(1));
    }
}
