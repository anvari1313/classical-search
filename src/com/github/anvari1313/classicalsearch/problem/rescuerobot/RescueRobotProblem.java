package com.github.anvari1313.classicalsearch.problem.rescuerobot;

import com.github.anvari1313.classicalsearch.problem.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RescueRobotProblem extends Problem<RescueRobotProblemState, RescueRobotProblemAction> {
    private int[][] enviroment;                             // Just making a storage for saving some values if needed

    private int colCount;
    private int rowCount;

    private List<UnConnectedNeighbourCell> restrictions;

    private RescueRobotProblemState startState;
    private RescueRobotProblemState goalState;


    public RescueRobotProblem(int n, int m, int[][]r, int startPosition[], int goalPosition[]){
        this.rowCount = n;
        this.colCount = m;
        this.enviroment = new int[this.rowCount][this.colCount];
        this.restrictions = new ArrayList<>();
        Arrays.asList(r).forEach(item -> restrictions.add(new UnConnectedNeighbourCell(item)));
        this.startState = new RescueRobotProblemState(startPosition[1], startPosition[0]);
        this.goalState = new RescueRobotProblemState(goalPosition[1], goalPosition[0]);
    }


    @Override
    public RescueRobotProblemState getInitState() {
        return startState;
    }

    @Override
    public HashSet<RescueRobotProblemAction> getActions(RescueRobotProblemState s) {
        HashSet<RescueRobotProblemAction> validActions = new HashSet<>();
        if (s.getCurrentCol() > 0)
            if (!isRestrictMove(s.getCurrentCol() - 1, s.getCurrentRow()))
                validActions.add(new RescueRobotProblemAction(RescueRobotProblemAction.RescueRobotProblemActions.L));

        if (s.getCurrentCol() < this.colCount - 1)
            if (!isRestrictMove(s.getCurrentCol() + 1, s.getCurrentRow()))
                validActions.add(new RescueRobotProblemAction(RescueRobotProblemAction.RescueRobotProblemActions.R));

        if (s.getCurrentRow() > 0)
            if (!isRestrictMove(s.getCurrentCol(), s.getCurrentRow() - 1))
                validActions.add(new RescueRobotProblemAction(RescueRobotProblemAction.RescueRobotProblemActions.U));

        if (s.getCurrentRow() < this.rowCount - 1)
            if (!isRestrictMove(s.getCurrentCol(), s.getCurrentRow() + 1))
                validActions.add(new RescueRobotProblemAction(RescueRobotProblemAction.RescueRobotProblemActions.D));

        return validActions;
    }

    private boolean isRestrictMove(int nextCol, int nextRow){
        /**
         * Check whether the move is in the restricted list
         */
        return this.restrictions.contains(new UnConnectedNeighbourCell(
                this.startState.getCurrentCol(), this.startState.getCurrentRow(),
                nextCol, nextRow
        ));
    }

    @Override
    public RescueRobotProblemState getResult(RescueRobotProblemState s, RescueRobotProblemAction a) {
        RescueRobotProblemState nextState = null;

        switch (a.getAction()){
            case D:
                nextState = new RescueRobotProblemState(s.getCurrentCol(), s.getCurrentRow() + 1, s.getActionSequence());
                break;
            case L:
                nextState = new RescueRobotProblemState(s.getCurrentCol() - 1, s.getCurrentRow(), s.getActionSequence());
                break;
            case R:
                nextState = new RescueRobotProblemState(s.getCurrentCol() + 1, s.getCurrentRow(), s.getActionSequence());
                break;
            case U:
                nextState = new RescueRobotProblemState(s.getCurrentCol(), s.getCurrentRow() - 1, s.getActionSequence());
                break;
        }

        nextState.addActionSequence(a);

        return nextState;
    }

    @Override
    public boolean goalTest(RescueRobotProblemState s) {
        return s.equals(goalState);
    }

    @Override
    public double pathCost(RescueRobotProblemState initState, List<RescueRobotProblemAction> rescueRobotProblemActions) {
        return 0;
    }

    @Override
    public double stepCost(RescueRobotProblemState rescueRobotProblemState, RescueRobotProblemAction rescueRobotProblemAction) {
        return 0;
    }

    @Override
    public double heuristic(RescueRobotProblemState s) {
        return 0;
    }
}

class UnConnectedNeighbourCell{
    private int col1;
    private int row1;
    private int col2;
    private int row2;

    UnConnectedNeighbourCell(int c1, int r1, int c2, int r2){
        /**
         * In this function the values are sorted due to c values of cells
         */
        this.col1 = (c1 < c2) ? c1 : c2;
        this.col2 = (c1 < c2) ? c2 : c1;
        this.row1 = (c1 < c2) ? r1 : r2;
        this.row2 = (c1 < c2) ? r2 : r1;
    }

    UnConnectedNeighbourCell(int []values){
        this(values[0], values[1], values[2], values[3]);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof UnConnectedNeighbourCell) &&
                (((UnConnectedNeighbourCell) o).col1 == this.col1) &&
                (((UnConnectedNeighbourCell) o).col2 == this.col2) &&
                (((UnConnectedNeighbourCell) o).row1 == this.row1) &&
                (((UnConnectedNeighbourCell) o).row2 == this.row2);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d) (%d,%d)", this.row1, this.col1, this.row2, this.col2);
    }
}