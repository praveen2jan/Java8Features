package Java8Lambda;

public class TypeInference {
    public static void main(String[] args) {
        printLambda(s -> s.length());
    }

    public static void printLambda(StringLength stringLength){
        System.out.println(stringLength.getLength("Dexter"));
    }

}

interface StringLength{
    int getLength(String s);
}