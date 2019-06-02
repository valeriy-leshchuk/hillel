package hw.twenty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.*;

@Log4j
public class HashStorage<K, V> implements IHashStorage<K, V>
{
    private static final int INIT_CAPACITY = 16;
    private static final double loadFactor = 0.75;

    private int currentCapacity;
    private int currentlyAddedEntities;
    private int resizeWhenSize;

    private ArrayList<Bucket> buckets = new ArrayList<>(INIT_CAPACITY);

    public HashStorage()
    {
        currentCapacity = INIT_CAPACITY;
        resizeWhenSize = (int) (INIT_CAPACITY * loadFactor);
        fillNullBuckets();
    }

    private void fillNullBuckets()
    {
        for (int i = 0; i < currentCapacity; i++)
        {
            try
            {
                buckets.get(i);
            }
            catch (IndexOutOfBoundsException ex)
            {
                buckets.add(new Bucket());
            }
        }
    }

    private int defineBucket(int hash)
    {
        return hash % currentCapacity;
    }

    @Override
    public boolean add(K key, V value)
    {

        int hashValueOfKey;
        try
        {
            hashValueOfKey = key.hashCode();
        }
        catch (NullPointerException ex)
        {
            return false;
        }
        int shouldBePlacedToBucket = defineBucket(hashValueOfKey);

        buckets.get(shouldBePlacedToBucket).add(key, value);
        currentlyAddedEntities++;

        if (currentlyAddedEntities>=resizeWhenSize)
        {
            currentCapacity *=2;
            resizeWhenSize = (int)(currentCapacity*loadFactor);
            fillNullBuckets();
        }
        return true;
    }

    @Override
    public V get(K key)
    {
        int hashValueOfKey;
        try
        {
            hashValueOfKey = key.hashCode();
        }
        catch (NullPointerException ex)
        {
            return null;
        }
        int shouldBeSearchedInBucket = defineBucket(hashValueOfKey);
        return buckets.get(shouldBeSearchedInBucket).getValueByKey(key);
    }

    private class Bucket
    {
        private List<Entity> entities = new LinkedList<>();
        private List<Integer> hashesOfEntities = new LinkedList<>();

        public void add(K key, V value)
        {
            int hashOfKey = key.hashCode();
            hashesOfEntities.add(hashOfKey);
            if (!hashesOfEntities.contains(hashOfKey))
            {
                hashesOfEntities.add(hashOfKey);
                entities.add(new Entity(key, value));
            }
            else
            {
                Entity existingEntityWithKey = findEntityByKey(key);
                if (existingEntityWithKey==null)
                {
                    entities.add(new Entity(key, value));
                }
                else
                {
                    existingEntityWithKey.setValue(value);
                }
            }
        }

        private Entity findEntityByKey(K key)
        {
            for (Entity e : entities)
            {
                if (e.getKey().equals(key))
                {
                    return e;
                }
            }
            return null;
        }

        public V getValueByKey(K key)
        {
            if (!hashesOfEntities.contains(key.hashCode()))
            {
                return null;
            }
            Entity foundEntity = findEntityByKey(key);
            return foundEntity!=null ? foundEntity.getValue() : null;
        }

        @AllArgsConstructor
        private class Entity
        {
            @Getter private K key;
            @Getter @Setter private V value;

        }
    }
}
