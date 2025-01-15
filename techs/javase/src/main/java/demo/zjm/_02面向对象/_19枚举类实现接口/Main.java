package demo.zjm._02面向对象._19枚举类实现接口;

enum Season implements Infc {
    SPRING {
        @Override
        public void show() {
            System.out.println("spring");
        }
    },
    SUMMER {
        @Override
        public void show() {
            System.out.println("summer");
        }
    },
    FALL {
        @Override
        public void show() {
            System.out.println("fall");
        }
    },
    WINTER {
        @Override
        public void show() {
            System.out.println("winter");
        }
    };
}

interface Infc {
    void show();
}

public class Main {
    public static void main(String[] args) {
        Season.SUMMER.show();//summer
    }
}
