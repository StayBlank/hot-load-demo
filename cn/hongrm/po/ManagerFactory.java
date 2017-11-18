package hongrm.po;

import hongrm.classloader.MyClassLoader;
import hongrm.common.ClassInfo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by hongrm on 2017/11/18 11:45
 */
public class ManagerFactory {
    public static final Map<String,ClassInfo> classMap = new ConcurrentHashMap<>();
    public static final String MY_MANAGER = "hongrm.po.impl.MyManager";
    public static final ManagerFactory managerFactory = new ManagerFactory();
    public  static BaseManager getBaseManager(String className){
        String classPath = managerFactory.getClass().getResource("/").getPath();
        File loadedFile = new File(classPath+className.replaceAll("\\.","/")+".class");
        long lastModified = loadedFile.lastModified();
        if(classMap.get(className) == null){
            load(classPath,className,lastModified);
        }else if (classMap.get(className).getLoadTime() != lastModified){
            load(classPath,className,lastModified);
        }
        return classMap.get(className).getManager();
    }

    private static void load(String classPath, String className,long lastModified){
        MyClassLoader classLoader = new MyClassLoader(classPath);
        Class<?> loadClass = null;
        try {
            loadClass = classLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        ClassInfo classInfo = new ClassInfo(classLoader,lastModified);
        classInfo.setManager(manager);
        classMap.put(className,classInfo);
    }

    private static BaseManager newInstance(Class<?> loadClass) {

        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
