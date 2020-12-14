package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/***
 *  Internal iteration vs external iteration
 */
public class Stream1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<100;i++)
                list.add(i);
        Stream<Integer> sequentialStream = list.stream();
        Stream<Integer> parallelStream = list.parallelStream();
        Stream<Integer> highNums = sequentialStream.filter(p->p>90);
        highNums.forEach(p->System.out.println("Seq Stream "+p));
        Stream<Integer> highNumParallel = parallelStream.filter(p->p>90);
        highNumParallel.forEach(p->System.out.println("Parallel Stream "+p));
    }

    private static int sumSteam(List<Integer> list){
        return list.stream().filter(p->p>90).mapToInt(i->i).sum();
    }

}
