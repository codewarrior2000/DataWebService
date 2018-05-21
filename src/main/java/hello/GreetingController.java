package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*********************************************************************
 *
 * The Resource Controller
 *
 * In Spring’s approach to building RESTful web services, HTTP requests are
 * handled by a controller. These components are easily identified by the
 * @RestController annotation, and the GreetingController below handles
 * GET requests for "/greeting" by returning a new instance of the Greeting class.
 *
 * @RestController annotation marks the class as a controller where every method
 * returns a domain object instead of a view. It’s shorthand for @Controller and
 * @ResponseBody rolled together.
 *
 * The @RequestMapping below does not specify GET vs. PUT, POST, and so forth,
 * because @RequestMapping maps all HTTP operations by default.
 * Use @RequestMapping(method=GET) to narrow this mapping.
 *
 */

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /******************************************************************************************
     *
     * The method body creates and returns a new Greeting object with id and content attributes
     * based on the next value from the counter, and formats the given name by using the greeting
     * template.
     *
     * @RequestParam binds the value of the query string parameter name into the name parameter
     * of the greeting() method. If the name parameter is absent in the request, the defaultValue
     * ("World") is used.
     *
     *
     * @param name
     * @return
     */

    @RequestMapping("/greeting")      // annotation ensures that HTTP requests to /greeting are mapped to this method.
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("COUNTER IS: " + counter + " name is: " + name);
        return new Greeting(counter.getAndIncrement(),
                String.format(template, name));
    }





}
