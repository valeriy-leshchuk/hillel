package hw.twenty;

import lombok.extern.log4j.Log4j;

@Log4j
public class App
{
    public static void main(String[] args)
    {
        IHashStorage<Integer, String> storage = new HashStorage<>();
        storage.add(1, "one");
        storage.add(2, "two");
        storage.add(3, "three");
        storage.add(4, "four");
        storage.add(4, "four four");

        log.debug(storage.get(1));
        log.debug(storage.get(5));
        log.debug(storage.get(3));
        log.debug(storage.get(4));
    }
}
