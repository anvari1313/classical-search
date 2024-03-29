package com.github.anvari1313.classicalsearch.problem;

import java.util.LinkedList;
import java.util.List;

public abstract class ProblemState {
    private List<ProblemAction> actionSequence;

    public ProblemState() {
        actionSequence = new LinkedList<>();
    }

    public ProblemState(List<ProblemAction> parentActionSequence) {
        this();
        this.actionSequence.addAll(parentActionSequence);
    }

    public void addActionSequence(ProblemAction action){
        this.actionSequence.add(action);
    }

    public List<ProblemAction> getActionSequence() {
        return actionSequence;
    }

    public abstract boolean equalityCheck(ProblemState o);

    @Override
    public boolean equals(Object o) {
        if (o instanceof ProblemState)
            return this.equalityCheck((ProblemState) o);
        else
            return false;
    }
}
