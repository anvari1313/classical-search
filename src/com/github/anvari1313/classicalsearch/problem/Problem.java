package com.github.anvari1313.classicalsearch.problem;

import java.util.HashSet;
import java.util.List;

public abstract class Problem <ProblemState, ProblemAction>{
    protected HashSet<ProblemState> visitedState = new HashSet<>();
    protected HashSet<ProblemState> expandedState = new HashSet<>();

    /**
     * Get the initial state of the problem
     * @return ProblemState class
     */
    public abstract ProblemState getInitState();

    /**
     * Get all available actions in the current state s.
     * @param s A ProblemState
     * @return A list of ProblemActions
     */
    public abstract HashSet<ProblemAction> getActions(ProblemState s);

    /**
     * Returns the result of the current action on state s
     * @param s ProblemState
     * @param a ProblemAction
     * @return ProblemState
     */
    public abstract ProblemState getResult(ProblemState s, ProblemAction a);

    /**
     * Test whether the current state is the goal state or not
     * @param s ProblemState
     * @return A bool indicate goal or not
     */
    public abstract boolean goalTest(ProblemState s);

    /**
     * Calculate the cost of path starting with initState and with actions
     * @param initState ProblemState
     * @param actions Sequence of actions
     * @return Double value of cost
     */
    public abstract double pathCost(ProblemState initState, List<ProblemAction> actions);

    /**
     * Calculate the cost of step on state s and action a
     * @param state ProblemState
     * @param action ProblemAction
     * @return Double value of Cost
     */
    public abstract double stepCost(ProblemState state, ProblemAction action);


    public abstract double heuristic(ProblemState s);

    public void visitState(ProblemState s){
        this.visitedState.add(s);
    }

    public boolean isVisited(ProblemState s){
        return this.visitedState.contains(s);
    }
}
