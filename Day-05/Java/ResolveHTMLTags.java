/*
Given an HTML tag represents raw text. Now Remove all the tags and extract only plain text as output
i/p:<div>HelloWorld</div>
o/p: Hello World
*/
import java.util.*;
class ResolveHTMLTags
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
            if(str.charAt(i)=='<')
            {
                brac=true;
            }
            else if(str.charAt(i)=='>')
            {
                if(i<str.length()-1 && str.charAt(i+1)!='<')
                System.out.print(" ");
                brac=false;
            }
            else if(!brac)
            {
                System.out.print(str.charAt(i));
            }
            i++;
        }
    }
}
