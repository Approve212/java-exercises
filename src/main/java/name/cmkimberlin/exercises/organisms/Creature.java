package name.cmkimberlin.exercises.organisms;

/**
 * Abstract class that defines how to obtain an organism's method of processing food
 */
abstract class Creature {

    protected final String name;

    /**
     * Returns String that contains type of food an organism eats
     * @return String that contains type of food an organism eats
     */
    abstract String eatFood();

    /**
     * Takes in String name of creature being passed in
     * @param name of creature being passed in
     */
    public Creature(String name) {
        this.name = name;
    }
}
