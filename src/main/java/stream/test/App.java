package stream.test;

import stream.test.producer.Producer;
import stream.test.stream.StreamService;

public class App {

    public static void main(String[] args) {

        Producer producer = new Producer();
        producer.produce();
        StreamService streamService = new StreamService();
        streamService.start();
    }
}
