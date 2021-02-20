package name.cmkimberlin.exercises.organisms;

/**
 * Implements Creature class of type Fungi with info on mode of reproduction and how they eat food
 */
class Fungi extends Creature implements Reproduction {

    public Fungi(String name) {
        super(name);
    }

    @Override
    public String eatFood() {
        return "external digestion with hyphae";
    }

    @Override
    public String modeOfReproduction() {
        return "spores";
    }

    @Override
    public String toString() {
        return "The fungi " + name + " uses " + modeOfReproduction() + " to reproduce and eats using " + eatFood();
    }
}
