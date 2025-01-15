package demo.zjm._04多线程._16生产者消费者问题;

class ProductStack {
    private int productNum = 0;

    synchronized void produce() {
        if (productNum < 30) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " produced " + ++productNum + " !");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void consume() {
        if (productNum > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " consumed " + productNum-- + " !");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private ProductStack productStack;

    public Producer(ProductStack productStack) {
        this.productStack = productStack;
    }

    @Override
    public void run() {
        while (true)
            productStack.produce();
    }
}

class ConSumer implements Runnable {
    private ProductStack productStack;

    public ConSumer(ProductStack productStack) {
        this.productStack = productStack;
    }

    @Override
    public void run() {
        while (true)
            productStack.consume();
    }
}

public class Main {
    public static void main(String[] args) {
        ProductStack productStack = new ProductStack();
        Thread producter = new Thread(new Producer(productStack), "producter1");
        Thread consumer = new Thread(new ConSumer(productStack), "consumer1");
        producter.start();
        consumer.start();
    }
}
