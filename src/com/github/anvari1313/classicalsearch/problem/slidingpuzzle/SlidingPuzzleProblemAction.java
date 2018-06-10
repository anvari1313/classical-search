package com.github.anvari1313.classicalsearch.problem.slidingpuzzle;

import com.github.anvari1313.classicalsearch.problem.ProblemAction;

public class SlidingPuzzleProblemAction extends ProblemAction {
    public enum SlidingPuzzleProblemActions {
        R,  // Stands for move to right
        U,  // Stands for move to up
        L,  // Stands for move to left
        D   // Stands for move to down
    };

    private SlidingPuzzleProblemActions action;

    public SlidingPuzzleProblemAction(SlidingPuzzleProblemActions a){
        this.action = a;
    }

    public SlidingPuzzleProblemActions getAction() {
        return action;
    }

    @Override
    public String toString() {
        return action.toString();
    }
}
