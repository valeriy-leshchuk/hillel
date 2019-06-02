package hw.eighteen.xml;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class WorkersContainer implements Iterable<Worker>
{
    private static final Set<Worker> workers = new HashSet<>();
    private static final WorkersContainer instance = new WorkersContainer();

    private WorkersContainer()
    {}

    public static WorkersContainer getInstance()
    {
        return instance;
    }

    public void addWorker(String login, String position, String company, int sinceYear)
    {
        workers.add(new Worker(login, position, company, sinceYear));
    }

    @Override
    public Iterator<Worker> iterator()
    {
        return workers.iterator();
    }
}
