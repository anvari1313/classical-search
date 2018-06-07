package com.github.anvari1313.classicalsearch.problem.rescuerobot;

import com.github.anvari1313.classicalsearch.problem.ProblemAction;

public class RescueRobotProblemAction extends ProblemAction {
    public enum RescueRobotProblemActions {
        R,  // Stands for move to right
        U,  // Stands for move to up
        L,  // Stands for move to left
        D   // Stands for move to down
    };

    private RescueRobotProblemActions action;

    public RescueRobotProblemAction(RescueRobotProblemActions a){
        this.action = a;
    }

    public RescueRobotProblemActions getAction() {
        return action;
    }
}
