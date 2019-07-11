package factory;

/**
 *
 * @author jgutierrez
 */
public class DogFactory {

    public static Dog getDog(DogTypeEnum criteria) {
        
        switch (criteria) {
            case small:
                return new Poodle();
            case big:
                return new Rottweiler();
            case working:
                return new SiberianHusky();
            default:
                break;
        }
        return null;
    }

}
