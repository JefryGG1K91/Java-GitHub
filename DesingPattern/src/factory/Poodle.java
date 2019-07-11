package factory;
/**
 *
 * @author jgutierrez
 */
class Poodle implements Dog {
    @Override
    public void speak() {
       System.out.println("The poodle says \"arf\"");
    }
}

class Rottweiler implements Dog
{
  @Override
  public void speak()
  {
    System.out.println("The Rottweiler says (in a very deep voice) \"WOOF!\"");
  }
}

class SiberianHusky implements Dog
{
  @Override
  public void speak()
  {
    System.out.println("The husky says \"Dude, what's up?\"");
  }
}

