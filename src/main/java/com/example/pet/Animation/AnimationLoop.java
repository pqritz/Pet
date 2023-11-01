package com.example.pet.Animation;

import com.example.pet.pet.Direction;
import com.example.pet.pet.Pet;

import java.awt.*;


public class AnimationLoop {

    private Thread periodicThread;
    private boolean isRunning = false;
    private long interval = 100;


    public void startAnimation(Pet parent) {
        if(this.isRunning) {
            stopAnimation();
        }
        boolean mirror = parent.getDir() == Direction.Left;
        int spriteY = parent.getPetState().getY();

        int individualFrames = parent.getPetState().getLength() - 1;
        final int[] currentFrame = {0};

        periodicThread = new Thread(() -> {
            this.isRunning = true;
            while(isRunning) {

                parent.getPetRenderer().setTexture(new Point(currentFrame[0], spriteY), mirror);

                currentFrame[0] += 1;
                if(currentFrame[0] > individualFrames) {
                    currentFrame[0] = 0;
                }

                try {
                    Thread.sleep(this.interval);
                } catch(InterruptedException ignored) {
                }
            }
        });
        periodicThread.start();

    }

    public void stopAnimation() {
        this.isRunning = false;
        if (periodicThread != null) {
            periodicThread.interrupt();
            try {
                periodicThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
