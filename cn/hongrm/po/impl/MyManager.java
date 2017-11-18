package hongrm.po.impl;

import hongrm.po.BaseManager;

/**
 * created by hongrm on 2017/11/18 11:26
 */
public class MyManager implements BaseManager{

    @Override
    public void logic() {
        System.out.println("Hello ! classloader ");
    }
}
