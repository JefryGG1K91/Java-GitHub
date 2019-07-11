package prototype;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jgutierrez
 */
public class Registry {
    
    private final Map<String,Item> items = new HashMap<>();

    public Registry() {
        loadItems();
    }
    
    public Item createItem(String type){
        Item  item = null;
        
        try {
            item = (Item)(items.get(type)).clone();
        } catch (CloneNotSupportedException e) {
            
        }
    
        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Princes of Persia");
        movie.setPrice(24.65);
        movie.setRuntime("2 hours");
        movie.setUrl(new StringBuilder("/"+movie.getTitle()).toString());
        items.put("Movie", movie);
        
        Book book = new Book();
        book.setNumberOfPages(365);
        book.setPrice(20.56);
        book.setTitle("Otelo");
        book.setUrl(new StringBuilder("/"+book.getTitle()).toString());
        items.put("Book", book);
    }
    
    
    
}
