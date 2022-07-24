package Part1.Week1.UnionFind;

// initialize - time complexity: O(n)
// union - time complexity: O(n)
// connected - time complexity: O(1)

public class QuickFind {

    int[] nodes;

    public QuickFind(int n) {
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
    }

    public void union(int firstNode, int secondNode) {
        int firstNodeValue = nodes[firstNode];
        int secondNodeValue = nodes[secondNode];
        if (firstNodeValue != secondNodeValue) {
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] == firstNodeValue) {
                    nodes[i] = secondNodeValue;
                }
            }
        }
    }

    public Boolean connected(int firstNode, int secondNode) {
        return nodes[firstNode] == nodes[secondNode];
    }

}
