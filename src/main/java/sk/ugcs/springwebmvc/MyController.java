package sk.ugcs.springwebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/test")
public class MyController {

    private final TestClass testClass;

    public MyController(TestClass testClass) {
        this.testClass = testClass;
    }

    @GetMapping("/testmvc")
    @ResponseBody
    public String test(HttpServletRequest req) {
        return "method: " + req.getMethod() + ", value: " + testClass.test();
    }

    @GetMapping("/person")
    @ResponseBody
    public Person getPerson() {
        return new Person("Miso", 37);
    }

    @GetMapping("/jsp")
    public String jspShowcase(Model model) {
        model.addAttribute("name", "miso");
        return "/WEB-INF/myjsp.jsp";
    }

    @PostMapping("/test2")
    public String test2() {
        return "test 2";
    }
}
