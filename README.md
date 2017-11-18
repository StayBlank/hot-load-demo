# hot-load-demo
热加载实现的demo

### 启动类
Main.java

### 监控类的改变并进行热加载
HotLoadTask.java

### 核心类加载器
MyClassLoader.java

### 类加载信息
ClassInfo.java

### 类加载工厂,类似于 IOC 容器
ManagerFactory.java

### 受监控的类
实现BaseManager接口的子类,可在类加载工厂进行配置(后期有时间再改成注解扫描的方式)

