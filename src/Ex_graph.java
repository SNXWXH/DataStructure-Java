class AdjMatrix{
    int [][] edge = new int[10][10];
    int numV = 0;

    void insertVertex(int v){
        numV++;
    }
    void insertEdge(int v1, int v2){
        edge[v1][v2] = 1;
        edge[v2][v1] = 1;
    }
    void printGraph(){
        System.out.println("===== 인접 행렬");
        for(int i = 0; i <numV; i++){
            for(int j = 0; j < numV; j++)
                System.out.print(edge[i][j]+" ");
            System.out.println("");
        }
    }
}

class GraphNode{
    int v;
    GraphNode link;
}

class AdjList{
    GraphNode[] g = new GraphNode[10];
    int numV = 0;

    void insertVertex(int v){
        numV++;
    }
    void insertEdge(int v1, int v2){
        GraphNode node = new GraphNode();
        node.v = v2;
        node.link = g[v1];
        g[v1] = node;
    }
    void printGraph(){
        System.out.println("===== 인접 리스트");
        for(int i = 0; i < numV; i++) {
            System.out.print("정점 " + i + "의 연결리스트");
            GraphNode p = g[i];
            while (p != null){
                System.out.print(" -> "+p.v);
                p = p.link;
            }
            System.out.println();
        }
    }
}

public class Ex_graph {
    public static void main(String[] args){
        AdjMatrix g1 = new AdjMatrix();
        for(int i = 0; i < 4 ;i++)
            g1.insertVertex(i);
        g1.insertEdge(0, 1);
        g1.insertEdge(0, 2);
        g1.insertEdge(2, 1);
        g1.insertEdge(2, 3);
        g1.insertEdge(3, 1);

        g1.printGraph();

        AdjList g2 = new AdjList();
        for(int i = 0; i < 4;i++)
            g2.insertVertex(i);
        g2.insertEdge(0, 1);
        g2.insertEdge(0, 2);
        g2.insertEdge(1, 0);
        g2.insertEdge(1, 2);
        g2.insertEdge(1, 3);
        g2.insertEdge(2, 0);
        g2.insertEdge(2, 1);
        g2.insertEdge(2, 3);
        g2.insertEdge(3, 2);
        g2.insertEdge(3, 1);
        g2.printGraph();
    }
}
