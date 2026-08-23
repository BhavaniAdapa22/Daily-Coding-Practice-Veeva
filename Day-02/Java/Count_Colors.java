import java.util.*;
class Count_colors
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s1=sc.nextLine();    
        LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();
        StringBuilder sb=new StringBuilder();
        String s=s1.toLowerCase();
        for(int i=0;i<s.length();i++)
        {
            if(Character.isLetter(s.charAt(i)))
            {
                sb.append(s.charAt(i));
            }
            else if(sb.length()!=0)
            {
                lhm.put(sb.toString(),lhm.getOrDefault(sb.toString(),0)+1);
                sb.setLength(0);
            }
        }
        if(sb.length()!=0)
        {
            lhm.put(sb.toString(),lhm.getOrDefault(sb,0)+1);
        }
        int total=0;
        for(String x:lhm.keySet())
        {
            int freq=lhm.get(x);
            System.out.println(x+"\t"+freq);
            total=total+freq;
        }
        System.out.println("Total Number of colors: "+total);
    }
}
