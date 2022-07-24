package Part1.Week1.Percolation;

import Part1.Week1.UnionFind.QuickUnionImproved;

public class Percolation {

    private boolean[][] grid;
    private final int dim;
    private int numOfOpenSites;
    private QuickUnionImproved uf;
    private final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        } else {
            dim = n;
            grid = new boolean[dim][dim];
            numOfOpenSites = 0;
            uf = new QuickUnionImproved((int) Math.pow(dim, 2) + 2);
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    grid[i][j] = false;
                }
            }
        }
    }

    public void open(int r, int c) {
        if (isOnGrid(r, c)) {
            if (!grid[r - 1][c - 1]) {
                grid[r - 1][c - 1] = true;
                numOfOpenSites ++;
                for (int i = 0; i < directions.length; i++) {
                    int neighbor_r = r + directions[i][0];
                    int neighbor_c = c + directions[i][1];
                    if (isOnGrid(neighbor_r, neighbor_c)) {
                        if (isOpen(neighbor_r, neighbor_c)) {
                            uf.union(nodeNumber(r, c), nodeNumber(neighbor_r,  neighbor_c));
                        }
                    }
                }
                if (r == 1) {uf.union(0, nodeNumber(r, c));}
                if (r == dim) {uf.union(nodeNumber(r, c), (int) Math.pow(dim, 2) + 1);}
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOpen(int r, int c) {
        if (isOnGrid(r, c)) {
            return grid[r - 1][c - 1];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isFull(int r, int c) {
        if (isOnGrid(r, c)) {
            return uf.connected(0, nodeNumber(r, c));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int numOfOpenSites() {
        return numOfOpenSites;
    }

    public boolean percolates() {
        return uf.connected(0, (int) Math.pow(dim, 2) + 1);
    }

    private boolean isOnGrid(int r, int c) {
        return (1 <= r) && (r <= dim) && (1 <= c) && (c <= dim);
    }

    private int nodeNumber(int r, int c) {
        return ((r - 1) * dim) + c;
    }

    public void visualizeGrid() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (grid[i][j]) {System.out.print("O" + " ");}
                else {System.out.print("X" + " ");}
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) {
        Percolation percolation = new Percolation(20);
        percolation.visualizeGrid();
    }

}
