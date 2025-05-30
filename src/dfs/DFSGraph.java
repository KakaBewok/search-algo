import java.util.*;

public class DFSGraph {

    private final LinkedList<Integer>[] adj; // Adjacency List
    private final int V; // Jumlah Vertex/Node

    public DFSGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Fungsi rekursif DFS
    // Sekarang mencari targetNode (indeks node)
    private boolean DFSUtil(int v, boolean visited[], int targetNode, List<String> path) {
        visited[v] = true;
        path.add(getNodeName(v)); // Tambahkan nama node ke path

        System.out.println("Mengunjungi Node " + getNodeName(v));

        if (v == targetNode) { // Cek apakah node saat ini adalah targetNode
            System.out.println("-------------------------------------");
            System.out.println("TARGET DITEMUKAN: " + getNodeName(targetNode) + " (Node " + targetNode + ")");
            System.out.println("Path yang dilalui: " + path);
            System.out.println("-------------------------------------");
            return true; // Target ditemukan
        }

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                if (DFSUtil(n, visited, targetNode, path)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1); // Backtrack
        return false;
    }

    // Fungsi utama DFS
    public void DFS(int startNode, int targetNode) {
        boolean visited[] = new boolean[V];
        List<String> path = new ArrayList<>(); // Path menyimpan nama node
        System.out.println("Memulai DFS dari Node: " + getNodeName(startNode) + " untuk mencari Node: " + getNodeName(targetNode));
        if (!DFSUtil(startNode, visited, targetNode, path)) {
            System.out.println("TARGET " + getNodeName(targetNode) + " TIDAK DITEMUKAN dari Node " + getNodeName(startNode));
        }
    }

    private String getNodeName(int index) {
        return "a" + (index + 1);
    }

    public static void main(String args[]) {
        DFSGraph g = new DFSGraph(7); // 7 node

        g.addEdge(0, 1); // a1 -> a2
        g.addEdge(0, 2); // a1 -> a3
        g.addEdge(1, 3); // a2 -> a4
        g.addEdge(2, 4); // a3 -> a5
        g.addEdge(2, 5); // a3 -> a6
        g.addEdge(3, 6); // a4 -> a7
        g.addEdge(4, 6); // a5 -> a7

        System.out.println("Graf telah dibuat:");
        System.out.println("a1(0) -> a2(1), a3(2)");
        System.out.println("a2(1) -> a4(3)");
        System.out.println("a3(2) -> a5(4), a6(5)");
        System.out.println("a4(3) -> a7(6)");
        System.out.println("a5(4) -> a7(6)");
        System.out.println("\n");

        int targetNode1 = 6; // Mencari a7 (node 6)
        g.DFS(0, targetNode1); // Mulai dari a1 (node 0)

        System.out.println("\n-------------------------------------\n");

        int targetNode2 = 99; // Target node yang tidak ada
        g.DFS(0, targetNode2); // Mulai dari a1 (node 0)
    }
}