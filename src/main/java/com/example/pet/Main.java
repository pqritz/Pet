package com.example.pet;

import com.example.pet.menu.MenuButton;
import com.example.pet.overlay.Overlay;
import com.example.pet.pet.Pet;

public class Main {

    static Main instance;

    Overlay overlay;
    MenuButton menuButton;
    Pet pet;

    public Main() {
        handleLoop();
    }


    private void handleLoop() {
        instance = this;
        overlay = new Overlay();
        menuButton = new MenuButton(overlay.getFrame());
        pet = new Pet(overlay.getFrame());

    }

    public Pet getPet() {
        return this.pet;
    }

    public static Main getInstance() {
        return instance;
    }
}
