package Java8Lambda;

public class RunnableLambda {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Implemented");
            }
        });
        thread.run();
        Thread thread1 = new Thread(()->System.out.println("Lambda"));
        thread1.run();
    }
}
