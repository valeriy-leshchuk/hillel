package hw.ten;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestApp
{
    public static void main(String[] args)
    {
        //1
        System.out.println("#1");
        AnyObjectStore1<Integer> store = new AnyObjectStore1<>();
        store.addElement(1);
        store.addElement(2);
        System.out.println("Store is: " + Arrays.toString(store.getStore().toArray()));
        store.removeElement(2);
        System.out.println("Store is: " + Arrays.toString(store.getStore().toArray()));
        System.out.println(store.contains(1));
        System.out.println(store.contains(2));
        //store.addElement("123"); //not allowed

        //2
        System.out.println("\n\n#2");
        AnyObjectStore2.addElement(1);
        AnyObjectStore2.addElement("test");
        System.out.println(AnyObjectStore2.getStore(String.class));
        System.out.println(AnyObjectStore2.getStore(Integer.class));
        AnyObjectStore2.removeElement(1);
        System.out.println(AnyObjectStore2.getStore(String.class));
        System.out.println(AnyObjectStore2.getStore(Integer.class));
        System.out.println(AnyObjectStore2.contains("test"));
        System.out.println(AnyObjectStore2.contains(3));

        //3
        System.out.println("\n\n#3");
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("z");
        list.add("e");
        list.add("y");
        list.add("m");
        list.add("f");
        list.add("b");
        list.add("o");
        list.add("q");
        list.add("t");
        list.add("s");
        System.out.println(ArrayAndListUtils.findMaxElementInListWithinRange(list, 2, 4));

        String[] array = new String[]{"a", "b", "c", "d", "e", "f"};
        System.out.println(Arrays.toString(ArrayAndListUtils.swapElements(array, 2, 5)));

        //4
        System.out.println("\n\n#4");
        DataStructure ds = new DataStructure();
        Iterator<Integer> it = ds.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
