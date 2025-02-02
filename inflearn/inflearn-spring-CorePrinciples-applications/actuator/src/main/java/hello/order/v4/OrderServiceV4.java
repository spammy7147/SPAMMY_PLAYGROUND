
package hello.order.v4;

import hello.order.OrderService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Timed("my.order")
@Slf4j
public class OrderServiceV4 implements OrderService {


    private AtomicInteger stock = new AtomicInteger(100);


    @Override
//    @Counted("my.order")
    public void order() {
            log.info("주문");
            stock.decrementAndGet();
            sleep(500);
    }



    @Override
//    @Counted("my.order")
    public void cancel() {
            log.info("취소");
            stock.incrementAndGet();
            sleep(200);
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis + new Random().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
