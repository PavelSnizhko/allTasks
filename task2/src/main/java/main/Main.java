package main;

import anotation.CallMethod;
import classes.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        QueueArray queue = new QueueArray(4);
        queue.put(3);
        queue.put(4);
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(Main.class.getName());
        Class someClass = queue.getClass();
        logger.info("Name of super class: " + someClass.getSuperclass().getName());


        Method[] methods = someClass.getMethods();
        for(Method method: methods){
            logger.info("Method name " + method.getName());

            for (int j = 0 ; j<method.getAnnotations().length; j++){
                if (method.getAnnotations()[j] instanceof CallMethod){
                    logger.info("Get result of annotation method : " +  method.invoke(queue));
                }
            }

            Parameter[] parameters = method.getParameters();
            for (Parameter parametr: parameters){
                logger.info("Name of parametr: " + parametr.getName() + "Type :" + parametr.getType().getName());
            }
            logger.info("Type of method " + Modifier.toString(method.getModifiers()));
        }
    }
}