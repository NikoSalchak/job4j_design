package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Niko";
        int age = 33;
        float laptopSize = 15.6F;
        double monitorSize = 24.5;
        byte completeTasks = 127;
        short requiredTasks = 32767;
        long desiredSalary = 300000L;
        boolean achieved = false;
        char avScore = 'c';
        LOG.debug("User info name : {}, age : {}, laptop size : {}", name, age, laptopSize);
        LOG.debug("monitor size : {}, completed tasks : {}, required tasks : {}", monitorSize, completeTasks, requiredTasks);
        LOG.debug("desired salary : {}, Did you achieve your goal ? {}, average score : {}", desiredSalary, achieved, avScore);
    }
}
