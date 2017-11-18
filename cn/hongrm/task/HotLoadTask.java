package hongrm.task;

import hongrm.po.BaseManager;
import hongrm.po.ManagerFactory;

/**
 * created by hongrm on 2017/11/18 13:16
 */
public class HotLoadTask implements Runnable{
    @Override
    public void run() {
        while (true){
            BaseManager manager = ManagerFactory.getBaseManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
