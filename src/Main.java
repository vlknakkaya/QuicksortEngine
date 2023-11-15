import com.quicksortengine.engine.QuicksortEngine;
import com.quicksortengine.engine.SortJob;
import com.quicksortengine.generator.CarGenerator;
import com.quicksortengine.util.Util;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CarGenerator.generate(Util.LIST_NUMBER);

        QuicksortEngine quicksortEngine = new QuicksortEngine();

        for (int i = 0; i < 10; i++) {
            quicksortEngine.addJob(new SortJob("cars-" + i + ".txt"));
        }

        Thread.sleep(10000);

        for (int i = 5; i < Util.LIST_NUMBER; i++) {
            quicksortEngine.addJob(new SortJob("cars-" + i + ".txt"));
        }

        quicksortEngine.terminate();

    }

}
