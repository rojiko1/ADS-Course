package Part1.Week1.Project2;

// initialize - time complexity: O(n)
// union - time complexity: O(lg* n)
// connected - time complexity: O(lg* n)

//explanation of time complexity: lg = log base 2; lg* = # of times to take lg to get to 1

public class QuickUnionImproved {

    int[] nodes;
    int[] sizes;

    public QuickUnionImproved(int n) {
        nodes = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int firstNode, int secondNode) {
        int firstRoot = rootNode(firstNode);
        int secondRoot = rootNode(secondNode);
        if (firstRoot != secondRoot) {
            if (sizes[firstRoot] <= sizes[secondRoot]) {
                nodes[firstRoot] = nodes[secondRoot];
                sizes[secondRoot] += sizes[firstRoot];
            } else {
                nodes[secondRoot] = nodes[firstRoot];
                sizes[firstRoot] += sizes[secondRoot];
            }
        }
    }

    public Boolean connected(int firstNode, int secondNode) {
        return rootNode(firstNode) == rootNode(secondNode);
    }

    private int rootNode(int node) {
        while (node != nodes[node]) {
            nodes[node] = nodes[nodes[node]]; // every node points directly to grandparent
            node = nodes[node];
        }
        return node;
    }

}
