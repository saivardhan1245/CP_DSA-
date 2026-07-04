package RecursionBacktracking.RecursionProblems;

public class FloodFIll {
    public static void printFloodFill(int r,int c ,int[][] mat,boolean[][] vis,String asf){
        if(r==mat.length && c == mat[0].length){
            System.out.println(asf);
            return;
        }
        if(r<0 || c<0 ||vis[r][c] || mat[r][c]==1 || r>=mat.length || c>=mat[0].length){
            return;
        }
        vis[r][c] = true;
        //tldr
        printFloodFill(r-1,c,mat,vis,asf+"t");
        printFloodFill(r,c-1,mat,vis,asf+"l");
        printFloodFill(r+1,c,mat,vis,asf+"d");
        printFloodFill(r,c+1,mat,vis,asf+"r");
        vis[r][c] = false; //backtracking
    
    }
    public static void main(String[] args){
        int[][] matrix = {{},{},{}};
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        printFloodFill(0,0,matrix,vis,"");
    }
}
