package array.mid;

public class PrintMatrixInSpiralOrder {
    public static void main(String[] args) {
        int[][] sqrmats = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] nonsqrMats = new int[][]{{1,2,3,4},{5,6,7,8}};
        printMatrix(nonsqrMats);
        System.out.println();
//        printSpiralOrder(nonsqrMats);
        printSpiralOrderUsingSeenArray(nonsqrMats);

        //printMatrix(mats);

    }

    private static void printSpiralOrderUsingSeenArray(int[][] mats) {
        if(mats ==null || mats.length==0){
            return ;
        }
        int rowL=mats.length,colL=mats[0].length;
        boolean[][] seen = new boolean[rowL][colL];
        int[] dr=new int[]{0,1,0,-1};
        int[] dc=new int[]{1,0,-1,0};
        int row=0,col=0,di=0;
        for(int i=0;i<rowL*colL;i++){
            System.out.print(mats[row][col]+ " ");
            seen[row][col]=true;
            //Calculating next row and col
            int nr=row+dr[di];
            int nc=col+dc[di];
            if(nr>=0 && nr<rowL && nc>=0 && nc<colL && !seen[nr][nc]){
                row=nr;
                col=nc;
            }
            else{
               di=(di+1)%4;
               row+=dr[di];
               col+=dc[di];
            }
        }
    }

    private static void printSpiralOrder(int[][] mats) {
        if(mats == null || mats.length==0){
            return ;
        }
        int rowL=mats.length,colL=mats[0].length;
        int left=0,right=colL-1,bottom=rowL-1,top=0;
        while(top<=bottom && left<=right){
            //Print the row from left to right
            for(int i=left;i<=right;i++){
                System.out.print(mats[top][i]+" ");
            }
            top++;
            //Traverse from top to bottom
            for(int i=top;i<=bottom;i++){
                System.out.print(mats[i][right]+" ");
            }
            right--;
            //Traverse from right to left
            if(top<=bottom)
                for(int i=right;i>=left;i--){
                    System.out.print(mats[bottom][i]+" ");
                }
            bottom--;
            //Traverse from bottom to top
            if(left<=right)
                for(int i=bottom;i>=top;i--){
                    System.out.print(mats[i][left]+" ");
                }
            left++;
        }
    }

    private static void printMatrix(int[][] nums) {
        //Print Matrix
        int m=nums.length;
        int n=nums[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }


}
