import java.util.*;
class ClosestDistance
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        long[] a=new long[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextLong();
        }
        Arrays.sort(a);
        long mindist=-1;
        if(n>=2)
        mindist=Integer.MAX_VALUE;
        for(int i=1;i<n;i++)
        {
            long dist=Math.abs((long)a[i]-a[i-1]);
            if(dist<mindist)
            mindist=dist;
        }
        System.out.println("Closest Distance:"+mindist);
    }
}
