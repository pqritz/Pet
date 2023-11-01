package com.example.pet.util;

import java.awt.*;
import java.util.Random;

public class MathHelper {

    public double lerp(double a, double b, double f) {
        f = Math.max(0, Math.min(1, f));
        return a + f * (b - a);
    }

    public int randomNumberInRange(int min, int max) { //including both lowest and highest [min, max]
        return (int) ((Math.random() * (max - min) + 1) + min);
    }

    public float timeForDistanceWithSpeed(Point start, Point end, float speed) {
        double distance = Math.sqrt((Math.pow((start.x - end.x), 2) + Math.pow((start.y - end.y), 2)));
        return (float) (distance / speed);
    }

    public int randomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }
}
