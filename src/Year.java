/**
 * Created by fengy on 2017/8/13.
 */
public class Year {
    public int getMost(int[][] board) {
        int max=0;
        int[][] dp=new int[board.length][board[0].length];
        dp[0][0]=board[0][0];
        for(int i=1;i<6;i++){
            dp[0][i]=board[0][i]+dp[0][i-1];
        }
        for(int i=1;i<6;i++){
            dp[i][0]=board[i][0]+dp[i-1][0];
        }
        for(int i=1;i<6;i++){
            for(int j=1;j<6;j++){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[5][5];
    }
}
