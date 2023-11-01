package com.example.pet.pet;

import com.example.pet.util.MathHelper;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PetBehaviour {

    Pet parent;
    MathHelper mathHelper;

    public PetBehaviour(Pet parent) {
        this.parent = parent;
        this.mathHelper = new MathHelper();

        startBehaviour();
    }


    public void startBehaviour() {
        final float[] actionDesire = {0.0f};

        int frameRate = 20;
        double frameDuration = 1000.0 / frameRate;

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if(!parent.getActive()) {
                    timer.cancel();
                }

                actionDesire[0] += 0.05f;
                if(actionDesire[0] >= 1f) {
                    actionDesire[0] = 0.0f;
                    Pet parent = PetBehaviour.this.parent;

                    int rand = mathHelper.randomNumber(1, 100);
                    PetState newPetState = PetState.Idle.getEnumByValue(rand);

                    Dimension petDim = parent.getPetRenderer().getIconDimension();
                    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();

                    switch(newPetState) {
                        case Idle:
                            parent.setPetState(PetState.Idle, Direction.Right);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case Cleaning_Paw:
                            parent.setPetState(PetState.Cleaning_Paw, Direction.Right);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case Cleaning_Ear:
                            parent.setPetState(PetState.Cleaning_Ear, Direction.Right);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case Walking:
                            int newXCoordinate = mathHelper.randomNumberInRange(petDim.width / 2, screenDim.width - petDim.width / 2) - screenDim.width / 2;
                            int newYCoordinate = mathHelper.randomNumberInRange(petDim.height / 2, screenDim.height - petDim.height / 2) - screenDim.height / 2;
                            Point end = new Point(newXCoordinate, newYCoordinate);

                            parent.setPetState(PetState.Walking, getOverallWalkingDir(parent.petRenderer.getLocation(), end));

                            movingAnimation(end, parent.getMovingSpeed());
                            timer.cancel();
                            break;
                        case Running:
                            newXCoordinate = mathHelper.randomNumberInRange(petDim.width / 2, screenDim.width - petDim.width / 2) - screenDim.width / 2;
                            newYCoordinate = mathHelper.randomNumberInRange(petDim.height / 2, screenDim.height - petDim.height / 2) - screenDim.height / 2;
                            end = new Point(newXCoordinate, newYCoordinate);

                            parent.setPetState(PetState.Running, getOverallWalkingDir(parent.petRenderer.getLocation(), end));

                            movingAnimation(end, parent.getRunningSpeed());
                            timer.cancel();
                            break;
                        case Sleeping:
                            parent.setPetState(PetState.Sleeping, Direction.Right);
                            try {
                                Thread.sleep(10_000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case Playing:
                            parent.setPetState(PetState.Playing, Direction.Right);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            parent.setPetState(PetState.Idle, Direction.Right);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;

                    }
                }
            }
        };

        timer.scheduleAtFixedRate(task,  0, (long) frameDuration);
    }

    private void movingAnimation(Point location, int movingSpeed) {
        Point start = new Point(this.parent.getPetRenderer().getLocation().x, this.parent.getPetRenderer().getLocation().y);

        int frameRate = 1000;
        double frameDuration = 1000.0 / frameRate;

        float totalTime = mathHelper.timeForDistanceWithSpeed(this.parent.getPetRenderer().getLocation(), location, movingSpeed);

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            long startTime = System.currentTimeMillis();

            @Override
            public void run() {
                long currentTime = System.currentTimeMillis() - startTime;

                if(!parent.getActive()) {
                    timer.cancel();
                }

                if (currentTime >= totalTime * 1000L) {
                    parent.setPetState(PetState.Idle, Direction.Right);
                    startBehaviour();
                    timer.cancel();
                } else {
                    double t = (double) currentTime / (totalTime * 1000);
                    int newX = (int) mathHelper.lerp(start.x, location.x, t);
                    int newY = (int) mathHelper.lerp(start.y, location.y, t);

                    parent.getPetRenderer().setLocation(newX, newY);
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, (long) frameDuration);
    }

    private Direction getOverallWalkingDir(Point start, Point end) {
        int xChange = end.x - start.x;
        int yChange = end.y - start.y;

        if (xChange < 0) {
            return Direction.Left;
        }
        return Direction.Right;
    }
}
