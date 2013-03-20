package export;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ScriptRunner {

    public static void main(String args[]) throws JAXBException, IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:context.xml");
        ExportScript exportScript = applicationContext.getBean(ExportScript.class);

        exportScript.run();
    }

}
