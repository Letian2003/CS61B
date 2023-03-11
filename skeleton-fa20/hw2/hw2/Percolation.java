package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    int [][] grid; 
    /*
     * 0~n-1 格子
     * n:顶
     * n+1:下
     */
    UnionFind uni;
    int N;

    public Percolation(int n){
        if(n<=0){
            throw new java.lang.IllegalArgumentException();
        }
        N=n;
        grid = new int[n][n];
        uni = new UnionFind(n*n);
    }

    public int getId(int row,int col){
        return row*N+col;
    }

    public boolean isOpen(int row,int col){
        if(row<0 || col<0 || row>=N || col>=N)
            throw new java.lang.IndexOutOfBoundsException();
        return grid[row][col]!=0;
    }

    public boolean isFull(int row,int col){
        if(row<0 || col<0 || row>=N || col>=N)
            throw new java.lang.IndexOutOfBoundsException();
        return grid[row][col]==2;
    }

    public void open(int row,int col){
        if(row<0 || col<0 || row>=N || col>=N)
            throw new java.lang.IndexOutOfBoundsException();
        if(isOpen(row,col)) return;
        int id=getId(row,col);
        grid[row][col] = 1;
        if(row==0)
            grid[row][col]=2;
        if(row-1>=0)
            Uni.connect
    }

}
