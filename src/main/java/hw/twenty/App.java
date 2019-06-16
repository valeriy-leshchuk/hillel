package hw.twenty;

import lombok.extern.log4j.Log4j;

@Log4j
public class App
{
    public static void main(String[] args)
    {
        IHashStorage<Integer, String> storage = new HashStorage<>();

        storage.add(1,"one");
        storage.add(5,"five");
        log.debug(storage);
        storage.add(9,"nine");
        log.debug(storage);
    }
}
