package classwork.mar31;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo
{
    public static void main(String[] args)
    {
        Map workerStore = new HashMap();

        Worker w1 = new Worker("1", "name1");
        Worker w2 = new Worker("2", "name2");

        workerStore.put(w1.getId(), w1);
        workerStore.put(w2.getId(), w2);

        Worker w3 = (Worker) workerStore.get(w1.getId());

    }

    private static class Worker
    {
        private String id_;
        private String name_;

        public Worker(String id, String name)
        {
            id_ = id;
            name_ = name;
        }

        public String getId()
        {
            return id_;
        }

        public String getName()
        {
            return name_;
        }

        public void setId(String id)
        {
            id_ = id;
        }

        public void setName(String name)
        {
            name_ = name;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Worker worker = (Worker) o;
            return Objects.equals(getId(), worker.getId()) &&
                Objects.equals(getName(), worker.getName());
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(getId(), getName());
        }
    }
}