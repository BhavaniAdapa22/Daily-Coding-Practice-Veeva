/*
Given a Standard server log string. Extract only Date and time from the log string.
"[2026-08-28 10:54:02] Info: System Initialized"
o/p:2026-08-28
10:54:02
*/

import java.util.*;
class RetrieveDateandTime
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter s String:");
        String str=sc.nextLine();
        boolean brac=false;
        int i=0;
        while(i<str.length())
        {
            if(str.charAt(i)=='[')
            {
                brac=true;
            }
            else if(str.charAt(i)==']')
            {
                System.out.println();
                brac=false;
            }
            else if(brac)
            {
                System.out.print(str.charAt(i));
            }
            i++;
        }
    }
}
