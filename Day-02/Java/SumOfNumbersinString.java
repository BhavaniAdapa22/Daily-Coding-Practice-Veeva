import java.util.*;
class SumOfNumbersinString
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);;
        System.out.println("Enter String:");
        String s=sc.nextLine();
        char[] num=s.toCharArray();
        int sum=0;
        int total=0;
        int i=0;
        int count=0;
        while(i<s.length())
        {
            if(!Character.isDigit(num[i]) &&  sum!=0)
            {
                total=total+sum;
                count++;
                sum=0;
            }
            else if(Character.isDigit(num[i]))
            {
                sum=10*sum+(num[i]-'0');
            }
            i++;
        }  
        if(sum!=0)
        {
            total=total+sum;
            count++;
        }
        System.out.println("Count:"+count); 
        System.out.println("Total:"+total);  
    }
}
