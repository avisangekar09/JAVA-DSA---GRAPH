import java.util.*;
  class graph{
    private ArrayList<ArrayList<Integer>> addlist;
    public graph(int v){
        addlist = new ArrayList<>(v);
        for(int i=0;i<v;i++){
            addlist.add(new ArrayList<>());
        }
    }

    public void addedge(int s,int d){
        addlist.get(s).add(d);
        addlist.get(d).add(s);
    }

    public void printgraph(){
        for(int i=0;i<addlist.size();i++){
            System.out.print(i +"-> ");
            for(int vertex : addlist.get(i)){
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start){
        boolean[] vis = new boolean[addlist.size()];
        Queue<Integer> q = new LinkedList<>();

        vis[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int neighbour : addlist.get(curr)){
                if(!vis[neighbour]){
                    vis[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }

    }

    public void dfs(int start){
        boolean[] vis = new boolean[addlist.size()];
        Stack<Integer> st = new Stack<>();

        vis[start]  =true;
        st.push(start);

        while(!st.isEmpty()){
            int curr = st.pop();
            System.out.print(curr+" ");

            for(int nbh : addlist.get(curr)){
                if(!vis[nbh]){
                    vis[nbh] = true;
                    st.push(nbh);
                }
            }
        }
    }
}
 
public class graphimplement{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("enter number of vertices : ");
        int v = s.nextInt();
        graph g = new graph(v);
        System.out.println("enter number of edges");
        int e = s.nextInt();

       

        System.out.println("enter to source to destination");
        for(int i=0;i<e;i++){
            int src = s.nextInt();
            int dest = s.nextInt();
            g.addedge(src,dest);
        }
        System.out.println("Graph : ");
        g.printgraph();

        System.out.print("enter starting index of bfs :");
        int start = s.nextInt();

        System.out.println("BFS traveral : ");
        g.bfs(start);
        System.out.println();
        System.out.print("enter starting index of dfs: ");
        int dfsstart = s.nextInt();
        System.out.println("DFS traversal : ");
        g.dfs(dfsstart);
        s.close();
    }
}