/**
 * Created by fengy on 2017/8/13.
 *

 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 测试样例：
 2,2
 返回：2
 */
public class Robot {
    public static void main(String[] args){
        Robot r=new Robot();
        int res=r.countWays(1,11);
        System.out.print(res);
    }
    public int countWays(int x, int y) {
        // write code here
        int max=0;
        int[][] dp=new int[x][y];
        dp[0][0]=1;
        for(int i=1;i<y;i++){
            dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<x;i++){
            dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[x-1][y-1];
    }

}
