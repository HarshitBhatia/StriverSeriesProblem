package Interview;

public class BroadgridgePractical {

    public static void main(String[] args) {
//        int [] arr=new int[]{-1,0,1,2,3,5,7,8,1,2,3,6,70,71};
//        int[] arr=new int[]{1, 2, 3, 4, 2, 3};
        int[] arr=new int[]{1,2,3,4,5,3,4,5,6};
        int len=arr.length;
        int count=0;
        for(int i=0;i<len;i++){
            int prevEle=arr[i];
            boolean found=false;
            int j;
            for(j=i+1;j<len;j++){
                if(prevEle+1==arr[j]){
                    found=true;
                    prevEle=arr[j];
                }
                else {
                    i=j-1;
                    break;
                }
            }
            count+=found?1:0;
            if(j==len) break;
        }
        System.out.println(count);

    }
}
