package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.security.SecureRandom;

public class RandomList {

    List<String> firstQuestions = new ArrayList<>();
    List<String> secondQuestions = new ArrayList<>();
    List<String> thirdQuestions = new ArrayList<>();


    public static final SecureRandom rand = new SecureRandom();


    public  List examList(final List firstObject, final List secondObject, final List thirdObject, final int sizeOfList) {
        List<List<String>> questions = new ArrayList<>();
        for (int i = 0; i < sizeOfList; i++) {
            List<String> strings = new ArrayList<>();
            strings.add((String) firstObject.get(rand.nextInt(sizeOfList)));
            strings.add((String) secondObject.get(rand.nextInt(sizeOfList)));
            strings.add((String) thirdObject.get(rand.nextInt(sizeOfList)));
            questions.add(strings);
        }
        return questions;

    }



    public static List fullListRandomValues(List object, int sizeOfList, int position){
        for(int i = 0 ; i < sizeOfList; i++){
            object.add(position + rand.nextInt(sizeOfList));
        }
        return object;
    }


    public void fullListKeyboardsValues(List stringArray, String[] array){

        Collections.addAll(stringArray, array);


    }


    public static void main(String[] args){
        RandomList tests = new RandomList();

        tests.fullListKeyboardsValues(tests.firstQuestions, new String[]{"1.ds43sdsadadsa", "2dskfjksdfksdfsdfsd", "3fs343sdfsd", "4fsdfsdfsd" , "fsdfsdfsd","dfssdfsdf","dsfsdfsdfsdfs"});
        tests.fullListKeyboardsValues(tests.secondQuestions, new String[]{"1.dsa4322sdsadadsa", "2dskfj43ksdfsdfsd", "3fs432232sdfsd", "4fsdfsdfsd" , "fsdf4324dfsd"});
        tests.fullListKeyboardsValues(tests.thirdQuestions, new String[]{"1.d534dasdsadadsa", "2dskfjksdfk43sdfsd", "3fsdfsdfsd", "4fsdfsdf43" , "fsdfsdfsd"});
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(RandomList.class.getName());
        logger.info("First questions: " + tests.firstQuestions);
        logger.info("Second questions: " + tests.secondQuestions);
        logger.info("Third questions: " + tests.thirdQuestions);
        logger.info("Examine questions: " + tests.examList(tests.firstQuestions,tests.secondQuestions,tests.thirdQuestions,5));
    }
}
