import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午1:07
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 1;i < N; ++i)
        {
            Comparable now = a[i];
            int j;
            for(j = i; j > 0 && less(now, a[j - 1]); --j)
                a[j] = a[j - 1];
            a[j] = now;
        }
    }
    public static void sort(Comparable[] a, int start, int end)
    {
        for(int i = start + 1; i <= end; ++i)
        {
            Comparable now = a[i];
            int j;
            for(j = i; j > start && less(now, a[j - 1]); --j)
                a[j] = a[j - 1];
            a[j] = now;
        }
    }
    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b)  < 0;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static void show(Comparable[] a)
    {
        StdOut.println(Arrays.toString(a));
    }
    private static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; ++i)
        {
            if(less(a[i], a[i - 1])) return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        String s = StdIn.readLine();
        String[] ss = s.split(" ");
        StdRandom.shuffle(ss);
        show(ss);
        sort(ss);
        assert isSorted(ss);
        show(ss);
    }
}
