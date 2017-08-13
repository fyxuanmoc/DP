import java.util.Scanner;

/**
 * Created by fengy on 2017/8/13.
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？

 输入描述:

 第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)


 输出描述:

 一行输出答案。
 */
public class Crimes {
    public static void main(String[] args){
        Crimes m=new Crimes();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int t=sc.nextInt();
            int c=sc.nextInt();
            int[] crimes=new int[n];
            for(int i=0;i<n;i++){
                crimes[i]=sc.nextInt();
            }
            int res=m.ChooseNum(crimes,c,t,n);
            System.out.println(res);
        }
    }

    private int ChooseNum(int[] crimes, int c, int t, int n) {
        int res=0;
        for(int i=0;i<n-c+1;i++){
            int sum=0;
            for(int j=0;j<i+c;j++){
                sum=sum+crimes[j];
            }
            if(sum<t){
                res++;
            }
        }
        return res;
    }
}
