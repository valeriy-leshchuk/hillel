package hw.twenty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.*;

/**
 * @param <K> key that will be stored
 * @param <V> value that will be stored
 */
@Log4j
public class HashStorage<K, V> implements IHashStorage<K, V>
{
    /**
     * Number of buckets that will be created upon storage creating.
     */
    private static final int INIT_CAPACITY = 4;

    /**
     * Coefficient that is used for resizing (always increasing the size) of storage.
     * Storage will be resized and rebalanced when it's load is more than that.
     */
    private static final double loadFactor = 0.75;

    /**
     * Stores the number of entities which is the threshold for resizing the storage.
     * If after adding entity amount of existing entities is greater than this number - storage will get resized and rebalanced.
     */
    private int resizeWhenSize;

    /**
     * Number of currently existing buckets in storage.
     */
    private int currentCapacity;

    /**
     * Number of added K,V pairs
     */
    private int currentlyAddedEntities;

    /**
     * Actual array for storing buckets.
     */
    private ArrayList<Bucket> buckets = new ArrayList<>(INIT_CAPACITY);

    public HashStorage()
    {
        currentCapacity = INIT_CAPACITY;
        resizeWhenSize = (int) (INIT_CAPACITY * loadFactor);
        fillNullBuckets();
    }

    /**
     * Once storage is created or resized, some of buckets don't exist. This method initialize them empty.
     */
    private void fillNullBuckets()
    {
        int amountOfBucketsToAdd = currentCapacity - buckets.size();
        for (int i = 0; i < amountOfBucketsToAdd; i++)
        {
            buckets.add(new Bucket());
        }
    }

    /**
     * @param hash is a hashCode of the key (<K>)
     * @return index of bucket where given key should be added of searched for.
     */
    private int defineBucket(int hash)
    {
        return hash % currentCapacity;
    }

    /**
     * This method performs resizing storage and rebalancing entities among buckets.
     */
    private void resizeAndRebalanceStorage()
    {
        ArrayList<Bucket> tmp = new ArrayList<>(buckets);
        buckets = new ArrayList<>(currentCapacity);
        currentlyAddedEntities = 0;
        fillNullBuckets();
        tmp.forEach(bucket -> bucket.getEntities().forEach(entity -> add(entity.getKey(), entity.getValue())));
    }

    /**
     * Public method for adding a pair of key and value (K,V) to storage.
     * @param key   key that is going to be added.
     * @param value value that is going to be added.
     * @return true if pair was added, false otherwise. In current implementation key can't be null.
     */
    @Override
    public boolean add(K key, V value)
    {
        if (key == null)
        {
            return false;
        }
        int hashValueOfKey = key.hashCode();
        int shouldBePlacedToBucket = defineBucket(hashValueOfKey);

        buckets.get(shouldBePlacedToBucket).add(key, value);
        currentlyAddedEntities++;

        if (currentlyAddedEntities >= resizeWhenSize)
        {
            currentCapacity = currentCapacity * 2;
            resizeWhenSize = (int) (currentCapacity * loadFactor);
            resizeAndRebalanceStorage();
        }
        return true;
    }

    /**
     * @param key is key for which the value should be returned.
     * @return found value or null is the given key is null.
     */
    @Override
    public V get(K key)
    {
        if (key == null)
        {
            return null;
        }
        int hashValueOfKey = key.hashCode();
        int shouldBeSearchedInBucket = defineBucket(hashValueOfKey);
        return buckets.get(shouldBeSearchedInBucket).getValueByKey(key);
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("HashStorage:");
        buckets.forEach(bucket ->
        {
            sb.append("\nBucket: ");
            bucket.getEntities().forEach(entity -> sb.append(entity));
        });
        return sb.toString();
    }

    /**
     * Private class which represents a node of storage.
     */
    private class Bucket
    {
        /**
         * List of pairs key,value (K,V) that are added bucket.
         */
        @Getter
        private List<Entity> entities = new LinkedList<>();

        /**
         * Keeps hashes of keys that are added to bucket.
         */
        private List<Integer> hashesOfEntities = new LinkedList<>();

        /**
         * Method for adding pair of key and value (K,V) to bucket.
         *
         * @param key   is key of pair that is intended to be added.
         * @param value is value of pair that is intended to be added.
         */
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
                if (existingEntityWithKey == null)
                {
                    entities.add(new Entity(key, value));
                }
                else
                {
                    existingEntityWithKey.setValue(value);
                }
            }
        }

        /**
         * Method for getting entire entity from bucket by given key.
         *
         * @param key is the key of entity that is searched for.
         * @return found entity or null is one is not found.
         */
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

        /**
         * @param key is the key for which the value should be found.
         * @return the value if found, null otherwise.
         */
        public V getValueByKey(K key)
        {
            if (!hashesOfEntities.contains(key.hashCode()))
            {
                return null;
            }
            Entity foundEntity = findEntityByKey(key);
            return foundEntity != null ? foundEntity.getValue() : null;
        }

        /**
         * Represent a pair of key and value (K,V) as a single entity.
         */
        @AllArgsConstructor
        public class Entity
        {
            @Getter private K key;
            @Getter @Setter private V value;

            @Override
            public String toString()
            {
                return "[" + key + " : " + value + ']';
            }
        }
    }
}
