package recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class RatIInMaze {
    public static void main(String[] args) {
        int M=4,N=4;
        int[][] mat=new int[][]{{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        List<String> op=new ArrayList<>();
        StringBuilder currStr=new StringBuilder();
        ratDFS(0,0,mat,op,currStr);
        printOP(op);
    }

    private static void ratDFS(int row, int col, int[][] mat, List<String> op, StringBuilder currStr) {
        if(row<0 || col<0 || row>=mat.length || col>=mat[0].length || mat[row][col]==0){
            return;
        }
        if(row==mat.length-1 && col==mat[0].length-1){
            //found a solution
            op.add(currStr.toString());
            return;
        }

        mat[row][col]=0;
        currStr.append('D');
        ratDFS(row+1,col,mat,op,currStr);
        currStr.deleteCharAt(currStr.length()-1);
        currStr.append('L');
        ratDFS(row,col-1,mat,op,currStr);
        currStr.deleteCharAt(currStr.length()-1);
        currStr.append('R');
        ratDFS(row,col+1,mat,op,currStr);
        currStr.deleteCharAt(currStr.length()-1);
        currStr.append('U');
        ratDFS(row-1,col,mat,op,currStr);
        currStr.deleteCharAt(currStr.length()-1);
        mat[row][col]=1;
    }

    private static void printOP(List<String> op) {
        System.out.println("All Possible directions are");
        for(String str:op){
            System.out.println(str);
        }
    }
}
