package hongrm.startup;

import hongrm.task.HotLoadTask;

import java.io.File;

/**
 * created by hongrm on 2017/11/18 13:19
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new HotLoadTask()).start();
    }
}
