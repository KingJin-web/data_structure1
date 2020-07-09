import java.util.*;

class ListDemo1 {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("java01");
        a.add("java02");
        a.add("java03");
        ListIterator t = a.listIterator();
        for (; t.hasNext(); ) {
            System.out.println(t.next());
        }
        for (; t.hasPrevious(); ) {
            System.out.println(t.previous());
        }
		/*ListIterator t=a.listIterator();
		while (t.hasNext())
		{
			System.out.println(t.next());
		}
		while (t.hasPrevious())
		{
			System.out.println(t.previous());
		}*/

    }
}
/*for (int x=0;x<v.size() ;x++ )
{
	System.out.println(v.get(x));
}*///（不用迭代器，对ArrayList集合中元素的取出）