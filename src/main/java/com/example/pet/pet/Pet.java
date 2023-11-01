package com.example.pet.pet;

import com.example.pet.Animation.AnimationLoop;

import javax.swing.*;

public class Pet {

    PetRenderer petRenderer;
    PetBehaviour petBehaviour;
    AnimationLoop animLoop;

    boolean active;
    boolean hide;

    int movingSpeed;
    int runningSpeed;
    PetState state;
    Direction dir;

    public Pet(JFrame parent) {
        this.active = true;
        this.hide = false;

        petRenderer = new PetRenderer(parent, 4);
        petBehaviour = new PetBehaviour(this);
        animLoop = new AnimationLoop();

        this.movingSpeed = 200; //Pixels per Second or p/s
        this.runningSpeed = 300;
        setPetState(PetState.Idle, Direction.Right);
    }

    public void setActive(boolean active) {
        this.active = active;
        if(this.active) {
            setPetState(PetState.Sleeping, Direction.Right);
            petRenderer.setLocation(0, 0);
            if(!this.hide) {
                petRenderer.showPet();
                petBehaviour.startBehaviour();
            }
        } else {
            animLoop.stopAnimation();
            petRenderer.hidePet();
        }
    }

    public void setHidden(boolean hidden) {
        this.hide = hidden;
    }

    public boolean getHidden() {
        return this.hide;
    }

    public boolean getActive() {
        return this.active;
    }

    public PetRenderer getPetRenderer() {
        return petRenderer;
    }

    public int getMovingSpeed() {
        return this.movingSpeed;
    }

    public int getRunningSpeed() {
        return this.runningSpeed;
    }

    public void setPetState(PetState newState, Direction newDirection) {
        //Handle Animations
        this.state = newState;
        this.dir = newDirection;

        //ANIMATIONS
        animLoop.startAnimation(this);
    }

    public PetState getPetState() {
        return this.state;
    }

    public Direction getDir() {
        return this.dir;
    }
}

