package DesignPatterns.Creational;

public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

class GFG{
    private GFG(){

    }

    private static class InnerClass{
        private static final GFG INSTANCE = new GFG();
    }

    public static GFG getInstance(){
        return InnerClass.INSTANCE;
    }
}