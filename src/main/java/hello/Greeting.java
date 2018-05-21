package hello;

/**************************************************************************
 *
 * The resource representation class (to model the greeting representation)
 *
 * Spring will use the Jackson JSON library to automatically marshal
 * instances of type Greeting into JSON.
 *
 * The resource controller will serve these Greeting instances.
 */

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}