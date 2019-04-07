package classwork.apr7;

import java.util.*;

import static javafx.scene.input.KeyCode.T;

public class GenericDemo
{
    public static void main(String[] args)
    {
        //#1
        List<Parent> list = new ArrayList<>();
        list.add(new Parent());
        list.add(new Child());

        //#2
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        Iterator<Integer> it = set.iterator();

        //#3
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        Iterator<Integer> iter = linkedHashSet.iterator();

        //#4
        Set<Integer> treeSet = new TreeSet<>();
        set.add(2);
        set.add(1);
        Iterator<Integer> treeSetIter = treeSet.iterator();

        //#5
        Storage<Number, String> storage = new Storage<>();
        storage.addToStorage(1);
        storage.addToStorage(1.0);
        storage.addToStorage("test");

    }

    private static class Parent
    {
    }

    private static class Child extends Parent
    {
    }

    private static class Storage<T extends Number, T2 extends String>
    {
        List<T> innerStore_;
        List<T2> innerStoreStr_;

        public void addToStorage(T valueToAdd)
        {
            innerStore_.add(valueToAdd);
        }

        public void addToStorage(T2 valueToAdd)
        {
            innerStoreStr_.add(valueToAdd);
        }

        public <T2> void printObj(T2 param)
        {

            System.out.println(innerStoreStr_.get(0));
        }
    }

}
