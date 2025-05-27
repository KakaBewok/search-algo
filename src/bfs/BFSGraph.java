import java.util.*;

public class BFSGraph {

    private final LinkedList<Integer> adj[]; // Adjacency List
    private final int V; // Jumlah Vertex/Node

    public BFSGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Fungsi utama BFS untuk pencarian
    // Sekarang mencari targetNode (indeks node)
    public void BFS(int startNode, int targetNode) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Memulai BFS dari Node: " + getNodeName(startNode) + " untuk mencari Node: " + getNodeName(targetNode));

        visited[startNode] = true;
        queue.add(startNode);

        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(startNode, -1);

        boolean targetFound = false;

        while (queue.size() != 0) {
            int current = queue.poll();
            System.out.println("Mengunjungi Node " + getNodeName(current));

            if (current == targetNode) { // Cek apakah node saat ini adalah targetNode
                System.out.println("-------------------------------------");
                System.out.println("TARGET DITEMUKAN: " + getNodeName(targetNode) + " (Node " + targetNode + ")");
                System.out.println("Path yang dilalui: " + buildPath(parentMap, startNode, current));
                System.out.println("-------------------------------------");
                targetFound = true;
                break;
            }

            Iterator<Integer> i = adj[current].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    parentMap.put(n, current);
                }
            }
        }

        if (!targetFound) {
            System.out.println("TARGET " + getNodeName(targetNode) + " TIDAK DITEMUKAN dari Node " + getNodeName(startNode));
        }
    }

    private String getNodeName(int index) {
        return "a" + (index + 1);
    }

    // Helper untuk membangun path dari parentMap
    private List<String> buildPath(Map<Integer, Integer> parentMap, int startNode, int endNode) {
        List<String> path = new ArrayList<>();
        int current = endNode;
        while (current != -1) {
            path.add(getNodeName(current)); // Tambahkan nama node, bukan nilai
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String args[]) {
        BFSGraph g = new BFSGraph(7); // 7 node

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
        g.BFS(0, targetNode1); // Mulai dari a1 (node 0)

        System.out.println("\n-------------------------------------\n");

        int targetNode2 = 99; // Target node yang tidak ada
        g.BFS(0, targetNode2); // Mulai dari a1 (node 0)
    }
}