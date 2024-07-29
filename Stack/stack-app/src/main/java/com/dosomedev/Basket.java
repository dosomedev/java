package com.dosomedev;

import java.util.Stack;

public class Basket {
    
    private Stack<String> plates = new Stack<>();

    public void addPlate(String plate) {
        this.plates.push(plate);
        System.out.println("Added plate: " + plate + ". Total number of plates: " + this.plates.size());
    }

    public String takePlate() {
        if (!this.plates.empty()) {
            String plate = this.plates.pop();
            System.out.println("Took plate: " + plate + ". Total number of plates: " + this.plates.size());
            return plate;
        } else {
            System.out.println("Tried to take plates, but no plates left.");
            return null;
        }
    }

    public void listPlates() {
        System.out.println("List of plates:");
        if (this.plates.size() > 0) {
            for (int i=this.plates.size()-1; i>=0; i--) {
                System.out.println("[" + i + "] " + this.plates.get(i));
            }
        } else {
            System.out.println("[] No plates left.");
        }
    }

    public String lookAtTopPlate() {
        if (!this.plates.empty()) {
            String plate = this.plates.peek();
            System.out.println("Look at top plate: " + plate);
            return plate;
        } else {
            System.out.println("Tried to look at the top plate, but no plates left.");
            return null;
        }
    }

    public void emptyBasket() {
        this.plates.clear();
        System.out.println("Emptied the basket.");
    }
}
