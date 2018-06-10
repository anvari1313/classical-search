package com.github.anvari1313.classicalsearch.problem.rubixcube;

import com.github.anvari1313.classicalsearch.problem.ProblemAction;

public class RubixCubeProblemAction extends ProblemAction {
    public enum RubixCubeProblemActions {
        T,      // Rotate upper side clockwise
        TC,     // Rotate upper side counter clockwise
        F,      // Rotate front side clockwise
        FC,     // Rotate front side counter clockwise
        R,      // Rotate right side clockwise
        RC      // Rotate right side counter clockwise
    }

    private RubixCubeProblemActions action;

    public RubixCubeProblemAction(RubixCubeProblemActions a){
        this.action = a;
    }

    public RubixCubeProblemActions getAction() {
        return action;
    }

    @Override
    public String toString() {
        return action.toString();
    }
}
