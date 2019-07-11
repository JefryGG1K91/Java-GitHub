/*
One benefit of Factory Method design pattern is that it decouples 
the calling class from the target class, resulting in less coupling
and highly unified code. JDBC is really a perfect example of this design
pattern; software program does not have to understand which database to choose,
so now it really does n’t know which database-specific driver classes to choose.
It utilises factory methods instead to connect with the database..
 */
package factory;

/**
 *
 * @author jgutierrez
 */
public class JavaFactoryPatternExample {

    public static void main(String[] args) {
        // create a small dog
        Dog dog = DogFactory.getDog(DogTypeEnum.small);
        dog.speak();

        // create a big dog
        dog = DogFactory.getDog(DogTypeEnum.big);
        dog.speak();

        // create a working dog
        dog = DogFactory.getDog(DogTypeEnum.working);
        dog.speak();
    }
}
