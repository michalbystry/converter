package pl.michal.Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 2015-03-01.
 */
public class TimeCalculation {

    private long start;
    private long finish;

    private List<Long> timeArray = new ArrayList <>();

    public void setStart() {
        this.start = System.currentTimeMillis();
    }
    public void setFinish() {
        this.finish = System.currentTimeMillis();
        timeArray.add(finish - start);
    }
    public long calculateAverage() {
        long sum = 0;
        if (!timeArray.isEmpty()) {
            for (Long times : timeArray) {
                sum += times;
            }
            return sum / timeArray.size();
        }
        return sum;
    }

    public void printAverageTime() {
        System.out.println(calculateAverage());
    }
}