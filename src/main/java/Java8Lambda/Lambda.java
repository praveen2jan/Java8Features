package Java8Lambda;

/***
 * Enables functional programming - more readable code
 * readable and concise code
 * Easier to use APIs and libs
 * Enable support for parallel processing
 *
 * behavior passed as an argument in functional programming
 *
 * Lambda -> Type inference
 *
 */

public class Lambda {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.greet(new HelloWorldGreeting());



        Greeting greeting = ()->System.out.println("Hello World!");
        greeting.perform();

        Greeting greeting1 = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hellow World");
            }
        };
        greeting1.perform();

    }
}


/*
greetingFunction = ()-> sysout("hello!");
type ??
greet(greetingFunction)
 */
