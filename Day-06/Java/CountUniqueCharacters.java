import java.util.*;
class CountUniqueCharacters
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter String:");
        String s=sc.next();
        LinkedHashSet<Character> hs=new LinkedHashSet<>();
        for(char x:s.toCharArray())
        {
            if(Character.isLetter(x))
            hs.add(x);
        }
        System.out.println("Count:"+hs.size());
        for(char x:hs)
        {
            System.out.print(x+" ");
        }
    }
}
