import java.util.*;
class Countnumbers
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter s String:");
        String str=sc.next();
        String[] s=str.split(",");
        int count=0;
        for(int i=0;i<s.length;i++)
        {
            if(Character.isDigit(s[i].charAt(0)))
            {
                count++;
            }
        }
        System.out.println("Count of Numbers:"+count);
    }
}

/*Sample Output
Input:John,36,Doe,Aiice,98,Bob,89,Eve,Smith,78
Output:4
*/
