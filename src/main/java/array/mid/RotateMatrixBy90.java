package array.mid;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(nums);
        rotateMatrixBy90(nums);
        System.out.println();
        printMatrix(nums);

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

    private static void rotateMatrixBy90(int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int temp=nums[i][j];
                nums[i][j]=nums[j][i];
                nums[j][i]=temp;
            }
        }
    }


}
