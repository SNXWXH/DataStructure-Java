import java.util.Stack;

class AdjMatrix {
    int[][] edge=new int[10][10];
    int numV=0;

    void insertVertex(int v) {
        numV++;
    }
    void insertEdge(int v1, int v2) {
        edge[v1][v2]=1;
    }
    void printGraph()  {
        System.out.println("= 인접 행렬 =");
        for (int i=0;i<numV;i++) {
            for (int j=0;j<numV;j++)
                System.out.print(edge[i][j]+"  ");
            System.out.println();
        }
        System.out.println();
    }
}

class GraphNode {
    int v;
    GraphNode link;
}

class AdjList  {
    GraphNode[] g = new GraphNode[10];
    int numV=0;

    void insertVertex(int v) {
        numV++;
    }
    void insertEdge(int v1, int v2) {
        GraphNode node=new GraphNode();
        node.v=v2;
        node.link=g[v1];
        g[v1]=node;
    }

    void printGraph()  {
        System.out.println("= 인접 리스트 =");
        for (int i=0;i<numV;i++)  {
            System.out.print("정점 "+i+"의 인접리스트 ");
            GraphNode p=g[i];
            while ( p!=null  ) {
                System.out.print(" ==> "+p.v);
                p=p.link;
            }
            System.out.println();
        }

    }


    void doDFS() {
        DFS dfs=new DFS(g, numV);
        dfs.startDFS();
    }

    void doBFS()  {
        BFS bfs=new BFS(g, numV);
        bfs.startBFS();
    }
}


class BFS { //너비우선탐색 - 가까운 정점부터!
    final int NUM;
    boolean[] visited;
    int[] q;
    int[] order;
    int order_index, enqueue=-1, dequeue=-1;
    GraphNode[] gList;

    public BFS(GraphNode[] g,int num) {
        gList=g;  NUM=num;
        visited=new boolean[NUM];
        q=new int[NUM*2];
        order=new int[NUM];
    }

    void startBFS() {
        doBFS(0);
        System.out.println("  ==  BFS  == ");
        for (int i=0;i<NUM;i++)
            System.out.print ( order[i]+"  ");
        System.out.println	("\n============");
    }

    void doBFS(int v) {
        if (visited[v] == false) {
            visited[v] = true;
            order[order_index++]=v;
        }
        // 연결된 정점 중 방문하지 않은 모든 정점을 인큐
        GraphNode p=gList[v];
        while ( p!=null) {
            if (visited[p.v] ==false) {
                q[++enqueue]=p.v;
            }
            p=p.link;
        }
        // 큐가 비어있지 않다면 큐에서 디큐한 정점으로 1)부터 시작
        if (enqueue != dequeue) {
            int v1=q[++dequeue];
            doBFS(v1);
        }
    }
}



class DFS {
    //정점 방문
    final int NUM;
    //방문여부 확인을 위한 배열
    boolean[] visited;
    //방문이 필요한 정점 저장(Stack)
    Stack<Integer> stack=new Stack<Integer>();
    //방문 순서 저장을 위한 배열 order_Index를 위한 변수
    int[] order;
    int order_index;
    GraphNode[] gList;

    public DFS(GraphNode[] g,int num) {
        gList=g;  NUM=num;
        visited=new boolean[NUM];
        order=new int[NUM];
    }

    void startDFS() {
        //0이 아닌 곳부터 시작하면 여기 바꾸면 됨
        doDFS(0);
        System.out.println("  ==  DFS  == ");
        for (int i=0;i<NUM;i++)
            System.out.print ( order[i]+"  ");
        System.out.println	("\n============");
    }

    void doDFS(int v) {
        //정점 방문
        if (visited[v] == false) {
            visited[v] = true;
            order[order_index++]=v;
        }
        GraphNode p=gList[v];
        while ( p!=null) {
            if (visited[p.v] ==false) {
                stack.push(v);
                doDFS(p.v);
            }
            p=p.link;
        }

        if (!stack.isEmpty()) {
            int v1=stack.pop();
            doDFS(v1);
        }
    }
}

public class Ex_graph {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        AdjList g2=new AdjList();
        for (int i=0;i<4;i++)
            g2.insertVertex(i);
        g2.insertEdge(0, 2);
        g2.insertEdge(0, 1);
        g2.insertEdge(1, 3);
        g2.insertEdge(1, 2);
        g2.insertEdge(1, 0);
        g2.insertEdge(2, 3);
        g2.insertEdge(2, 1);
        g2.insertEdge(2, 0);


        g2.insertEdge(3, 1);
        g2.insertEdge(3, 2);
        g2.printGraph();
        g2.doDFS();
        g2.doBFS();

        AdjList g3=new AdjList();
        for (int i=0;i<8;i++)
            g3.insertVertex(i);

        g3.insertEdge(0, 1);
        g3.insertEdge(0, 2);
        g3.insertEdge(1, 3);
        //g3.insertEdge(1, 0);
        g3.insertEdge(2, 0);
        g3.insertEdge(2, 3);
        g3.insertEdge(2, 4);
        g3.insertEdge(3, 5);
        g3.insertEdge(3, 2);
        g3.insertEdge(3, 1);
        g3.insertEdge(4, 2);
        g3.insertEdge(4, 6);
        g3.insertEdge(4, 7);
        g3.insertEdge(5, 3);
        g3.insertEdge(6, 7);
        g3.insertEdge(6, 4);
        g3.insertEdge(7, 4);


        g3.printGraph();
        g3.doDFS();
        g3.doBFS();

    }

}