import java.util.Scanner;

/**
 * Created by fengy on 2017/8/13.
 * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。
 *  比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
 测试样例：
 [2,7,9,4,1],5
 返回：14
 */
public class Square {
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Square s=new Square();
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] square=new int[n];
            for(int i=0;i<n;i++){
                square[i]=sc.nextInt();
            }
            int res=s.mostNum(square,n);
            System.out.println(res);
        }
    }
//[281,179,386,165,88,500],6
    private int mostNum(int[] s, int n) {
        int res=0;
        int max=0;
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+2-i;j++){
                dp[i][j]=Math.max(dp[i][j-1],min(A,i,j)*i);
            }
            for(int j=n+2-i;j<n+1;j++){
                dp[i][j]=dp[i][j-1];
            }
        }
        for(int i=1;i<n+1;i++){
            max=Math.max(dp[i][n],max);
        }
        return max;
    }
//找出i个中最小的一个数
    private int min(int[] s, int i,int j) {
        int min=Integer.MAX_VALUE;
        //i表示宽度，j表示从s的第几个元素开始

        for(int m=j-1;m<Math.min(j+i-1,s.length);m++){
            min=Math.min(s[m],min);
        }
        return min;
    }
}
