package name.cmkimberlin.exercises.organisms;

/**
 * Implements Creature class of type Plant with info on mode of reproduction and how they eat food
 */
class Plant extends Creature implements Reproduction {

    public Plant(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "The plant " + name + " uses the " + modeOfReproduction() + " mode of reproduction and eats using " + eatFood();
    }

    @Override
    public String eatFood() {
        return "sunlight (aka photosynthesis)";
    }

    @Override
    public String modeOfReproduction() {
        return "seeds";
    }
}
