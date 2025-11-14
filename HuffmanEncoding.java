import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class HuffmanEncoding {

    public static void printCode(HuffmanNode root, String s)
    {
        if(root.left == null && root.right == null && Character.isLetter(root.c))
        {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    //main method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume endline

        char[] charArray = new char[n];
        int[] charfreq = new int[n];

        System.out.println("Enter the characters (space separated or one per line):");
        for (int i = 0; i < n; i++) {
            String token = sc.next();
            // take first character of the token
            charArray[i] = token.charAt(0);
        }

        System.out.println("Enter their frequencies (space separated or one per line):");
        for (int i = 0; i < n; i++) {
            charfreq[i] = sc.nextInt();
        }

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for(int i=0; i<n; i++) {
            //creating object
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        HuffmanNode root = null;

        while(q.size()>1) {
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        printCode(root,"");

        sc.close();
    }
}

//HuffmanNode class
class HuffmanNode{
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

//Comparator: comparing the node x and y of Huffman tree
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {
        return x.data - y.data;
    }
}
