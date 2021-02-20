package name.cmkimberlin.exercises.organisms;

import java.util.ArrayList;
import java.util.List;

/**
 * Comp Sci 2261
 * Project 5
 * This program creates instances of each type of organism within lists and displays said lists at runtime
 * @author Caleb Kimberlin
 */
public class ClassifyOrganism {

    public static void main(String[] args) {
        List<Plant> plantList = new ArrayList<>();
        plantList.add(new Plant("Rose"));
        plantList.add(new Plant("Sunflower"));

        System.out.println("Here are the plants and some info:");
        for(Plant P:plantList) {
            System.out.println(P);
        }

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Cat"));
        animalList.add(new Animal("Penguin"));

        System.out.println("\nHere are the animals and some info:");
        for(Animal A:animalList) {
            System.out.println(A);
        }

        List<Fungi> fungiList = new ArrayList<>();
        fungiList.add(new Fungi("Sac fungi"));
        fungiList.add(new Fungi("Chytrids"));

        System.out.println("\nHere are the fungi and some info:");
        for(Fungi F:fungiList) {
            System.out.println(F);
        }
    }
}
