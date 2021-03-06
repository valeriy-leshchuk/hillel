package hw.seventeen;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Log4j
public class JsonApp
{
    public static void main(String[] args) throws IOException
    {
        //read json to map
        ObjectMapper om = new ObjectMapper();
        InputStream is = JsonApp.class.getResourceAsStream("testObj.json");
        Map<String, Number> initMap = (Map<String, Number>) om.readValue(is, Map.class);

        //calculate sum of values in map
        Double sum = initMap.values().stream().mapToDouble(Number::doubleValue).sum();
        log.info("Sum of values in initial map is '" + sum + "'");

        //create new map where values are multiplied by sum
        Map<String, Double> multipleidMap = new HashMap<>();
        initMap.entrySet().stream().forEach(entry -> multipleidMap.put(entry.getKey(), entry.getValue().doubleValue() * sum));
        log.info("Multiplied map (where each value is multiplied by '" + sum + "': " + multipleidMap);

        //count unique values in map
        long numOfDiffValues = initMap.values().stream().distinct().count();
        log.info("Number of different values is '" + numOfDiffValues + "'");

        //generate list of 100k integer numbers; find min, max, unique values
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++)
        {
            list.add(rand.nextInt());
        }
        int max = list.stream().mapToInt(i -> i).max().getAsInt();
        int min = list.stream().mapToInt(i -> i).min().getAsInt();
        long uniquesInList = list.stream().distinct().count();
        log.info("List contains " + uniquesInList + " unique values in range [" + min + ";" + max + "]");

        //convert json to object and print it
        ObjectMapper om2 = new ObjectMapper();
        InputStream is2 = JsonApp.class.getResourceAsStream("test2.json");
        TestObj testObj = om2.readValue(is2, TestObj.class);
        log.info("Object has been created from json: " + testObj.toString());
    }
}
