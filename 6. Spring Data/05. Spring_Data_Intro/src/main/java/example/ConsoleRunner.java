package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import example.services.StudentService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    //@Autowired
    //private StudentService studentService;

    //@Autowired
    //private MajorService majorService;

    @Override
    public void run(String... strings) throws Exception {
    //   Major major = new Major("Java DB Fundamentals");
    //  Student student = new Student("John",new Date(), major);
    //    majorService.create(major);
    //studentService.register(student);
    }
}