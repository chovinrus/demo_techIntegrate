package demo.zjm.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @program: demo_techIntegrate
 * @ClassName: MyApplicationRunner
 * @description:
 * @author: AlanMa
 * @create: 2024-04-07 22:35
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner executed with command-line arguments: " + args.getOptionNames() + args.getOptionValues("name"));
    }
}
