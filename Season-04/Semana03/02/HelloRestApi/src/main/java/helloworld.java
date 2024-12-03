@RestController
public class helloworld {

    @RequestMapping(method = RequestMethod.GET, value = "api/hello")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return "Hello " + str;
    }

}
