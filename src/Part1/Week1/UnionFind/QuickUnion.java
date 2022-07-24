package Part1.Week1.UnionFind;

// initialize - time complexity: O(n)
// union - time complexity: O(n)
// connected - time complexity: O(n)

public class QuickUnion {

    int[] nodes;

    public QuickUnion(int n) {
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
    }

    public void union(int firstNode, int secondNode) {
        nodes[rootNode(firstNode)] = nodes[rootNode(secondNode)];
    }

    public Boolean connected(int firstNode, int secondNode) {
        return rootNode(firstNode) == rootNode(secondNode);
    }

    private int rootNode(int node) {
        int currentNode = node;
        int currentNodeValue = nodes[node];
        while (currentNode != currentNodeValue) {
            currentNode = currentNodeValue;
            currentNodeValue = nodes[currentNode];
        }
        return currentNode;
    }

}
