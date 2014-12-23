public class CC150_4_2 {
    
    // graph BST is a little different from tree BST in the while loop
    public static boolean search(Graph g, Node start, Node end) {
        Queue<Node> q = new LinkedList<Node>();
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.offer(start);
        Node u;
        while (!q.empty()) {
            u = q.poll();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.offer(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
