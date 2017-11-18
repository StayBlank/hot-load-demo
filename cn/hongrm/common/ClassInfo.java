package hongrm.common;

import hongrm.classloader.MyClassLoader;
import hongrm.po.BaseManager;

/**
 * 类加载的信息类
 * created by hongrm on 2017/11/18 11:13
 */
public class ClassInfo {
    private MyClassLoader myClassLoader;
    private long loadTime;
    private BaseManager manager;

    public ClassInfo(MyClassLoader myClassLoader, long loadTime) {
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}
