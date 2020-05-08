package helper.randomListHelper;

import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class RandomListHelper {
    private static Logger log = LoggerHelper.getLogger(RandomListHelper.class);

    public static void getRandomElement(ArrayList<String> list, HashSet<Integer> hashSet)
    {
        Random rand = new Random();
        hashSet.add(rand.nextInt(list.size()));
        rand.nextInt(list.size());
    }
    public static String getRandomList() throws FileNotFoundException {
        HashSet<Integer> hashSet = new HashSet<>(5);
        Scanner sc = new Scanner(new File(ResourceHelper.getResourcePath("/src/main/resources/configFile/movies.txt")));
        ArrayList<String> movies = new ArrayList<>();

        while (sc.hasNext()) {
            movies.add(sc.next());
        }
        while(hashSet.size()<3){
            RandomListHelper.getRandomElement(movies,hashSet);
        }
        if (movies.size() == 0 || movies.size() < 5) {
            log.info("Movies list is empty or less than 5 movies");
        } else {
            for (Integer integer : hashSet) {
                log.info("List of movies --> "+ movies.get(integer));
                return (movies.get(integer));
            }
        }
        return null;
    }
}
