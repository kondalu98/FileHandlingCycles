import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import  java.util.List;

public class task {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter op=new PrintWriter(new File("C:\\Users\\PYK\\Downloads\\one.csv"));
        StringBuilder sb=new StringBuilder();
        sb.append("player");
        sb.append(",");
        sb.append("Team1");
        sb.append(",");
        sb.append("Team2");
        sb.append(",");
        sb.append("\r\n");


        ArrayList<String>t1=new ArrayList<>();
        ArrayList<String>t2=new ArrayList<>();
        Random r =new Random();
        for(int i=0;i<10;i++)
        {
            int p=r.nextInt(2);
            if(p==0)
            {
                t1.add("head");
                t2.add("tail");
            }
            else{
                t1.add("tail");
                t2.add("head");
            }
        }
        System.out.println(t1);
        System.out.println(t2);
//        int[] c1=new int[10];
//        int c2=0;
        int l1=t1.stream().filter(x->
         x.equals("head")
     ).collect(Collectors.toList()).size();

        int l2=t2.stream().filter(x->
                x.equals("head")
        ).collect(Collectors.toList()).size();

        System.out.println(l1);
        System.out.println(l2);
        String s="";
        if(l1!=l2) {
            s = (l1 > l2) ? "team1 " : "team2";
            System.out.println(s);

        }
        else{
            s="tieup the match";
        }

       for(int i=0;i<=9;i++)
       {
           sb.append("Round"+(i+1));
           sb.append(",");
           sb.append(t1.get(i));
           sb.append(",");
           sb.append(t2.get(i));
           sb.append("\r\n");
       }
       sb.append("winner");
       sb.append(",");
       sb.append(l1);
       sb.append(",");
       sb.append(l2);
       sb.append(",");
       sb.append(",");
       sb.append(s);
       op.write(sb.toString());
       op.close();



    }
}
