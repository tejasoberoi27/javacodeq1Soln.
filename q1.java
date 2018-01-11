import static java.lang.Math.abs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

public class q1{

    
public static int sort(int a[],int p )
     {
       int n=a.length;
     for(int i =0; i< n ;i++)//n-1 passes
        {
            for(int j=0;j < n-1-i;j++)// i elements have already been sorted
            {
                if (a[j]>a[j+1])
                    {
                        int t=a[j];
                        a[j]=a[j+1];
                        a[j+1]=t;
                    }
            }
        }

    

        return f(a,p,0,n-1,abs(a[0]-p));
        
     }

    public static int f(int a[],int n ,int low,int high,int min)
    {
         /*Given an array arr[] and an integer number N. Find the number nearest to the number N in the
array arr[]. [Hint: You can make your algorithm faster by using one of the algorithms discussed
in the class.]
*/          
    //     for(int el:a)
    // {
    //     System.out.print(el+",");
    // }
    
        // System.out.println(" h="+high+" l="+ low);
        if(a.length==1)
        {
            return a[0];   
        }

        int mid = (low+high)/2;
        min= abs(n-a[mid]);

        if(high-low<=2)
        {   
            int x=a[mid];
            mid = (high+low)/2; 
            int d1=abs(n-a[high]);
            int d2=abs(n-a[low]);
            int dm=abs(n-a[mid]);
            if (d1<min)
            {
                min=d1;
                x=a[high];
            }

            if (d2<min)
            {
                min=d2;
                x=a[low];
            }
            if(dm<min)
            {
                min=dm;
                x=a[dm];
            }

            return x;
            
        }
       
        
        
        if (a[mid]==n)
        {
            return a[mid];
        }
        else if (n>a[mid])
        {   
            return f(a,n,mid+1,high,min);
        }

        if(n<a[mid])
        {
            return f(a,n,mid,high-1,min);   
        }
        else return 0;
    }
    public static void main(String[] args) throws IOException{
        
        Reader.init(System.in);
        int s = Reader.nextInt();
        int a[]= new int[s];

        for (int i=0;i<s;i++)
        {
            a[i]= Reader.nextInt();
        }
        int n= Reader.nextInt();
        System.out.println();
        int c=sort(a,n);
        System.out.println(c);
    }
}