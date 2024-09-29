package Graphs;
import java.util.*;
public class FindEventualSafeStates802 {
    public static void main(String[] args) {

    }
    // Approach 1: Using dfs topsort

    private boolean dfs(int u, int[][] graph, boolean[] visited, boolean[] recStack){
        visited[u] = true;
        recStack[u] = true;

        for(int v : graph[u]){
            if(!visited[v] && dfs(v, graph, visited, recStack)){
                return true;
            } else if(recStack[v]){
                return true;
            }
        }
        recStack[u] = false;
        return false;
    }


    // Approach 2: Using Kahn's algorithm i.e. bfs topsort

    private List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // using kahn's algorithm

        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            revAdj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int v: adj.get(i)){
                revAdj.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        boolean[] safeNodes = new boolean[V];

        while(!q.isEmpty()){
            int u = q.poll();
            safeNodes[u] = true;

            for(int v : revAdj.get(u)){
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }

        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(safeNodes[i]){
                res.add(i);
            }
        }
        return res;

    }

    /*
    *
    * Why Reverse the Graph?

        Identifying Terminal Nodes Easily:
            Original Graph: Terminal nodes are nodes with no outgoing edges.
            Reversed Graph: These same terminal nodes become nodes with no incoming edges.
            Advantage: Nodes with no incoming edges in the reversed graph are straightforward to identify and process first.

        Facilitating Topological Sorting:
            Topological Sorting: This is a linear ordering of nodes where for every directed edge u → v, node u comes before v in the ordering.
            In the Reversed Graph: By reversing the edges, you can perform a topological sort starting from terminal nodes (which now have zero incoming edges).
            Process:
                Start with nodes that have no incoming edges (originally terminal nodes).
                Iteratively remove these nodes and reduce the indegree of their predecessors.
                Nodes whose indegree drops to zero during this process are also safe nodes.

        Simplifying Dependency Management:
            Original Graph: Determining if a node is safe involves checking all its outgoing paths for cycles, which can be complex.
            Reversed Graph: By reversing the edges, the problem transforms into identifying nodes that can be "safely" reached from terminal nodes without encountering cycles.
        *
        *
        * */
}
