package name.cmkimberlin.exercises.organisms;

/**
 * Implements Creature class of type Animal with info on mode of reproduction and how they eat food
 */
class Animal extends Creature implements Reproduction {

    public Animal(String name) {
        super(name);
    }

    @Override
    public String eatFood() {
        return "ingestion";
    }

    @Override
    public String modeOfReproduction() {
        return "sexual reproduction";
    }

    @Override
    public String toString() {
        return "The animal " + name + " uses " + modeOfReproduction() + " to reproduce and eats using " + eatFood();
    }
}
