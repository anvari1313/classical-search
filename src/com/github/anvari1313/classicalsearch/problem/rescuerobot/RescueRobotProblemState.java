package com.github.anvari1313.classicalsearch.problem.rescuerobot;

import com.github.anvari1313.classicalsearch.problem.ProblemAction;
import com.github.anvari1313.classicalsearch.problem.ProblemState;

import java.util.List;

public class RescueRobotProblemState extends ProblemState {
    private int currentRow;
    private int currentCol;

    public RescueRobotProblemState(int currentCol, int currentRow){
        this.currentCol = currentCol;
        this.currentRow = currentRow;
    }

    public RescueRobotProblemState(int currentCol, int currentRow, List<ProblemAction> parentActionSequence){
        super(parentActionSequence);
        this.currentCol = currentCol;
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    @Override
    public boolean equals(ProblemState o) {
        return o instanceof RescueRobotProblemState &&
                (((RescueRobotProblemState) o).currentRow == this.currentRow) &&
                (((RescueRobotProblemState) o).currentCol == this.currentCol);
    }

    @Override
    public String toString() {
        return String.format("State (%d, %d)", this.currentRow, this.currentCol);
    }

    @Override
    public int hashCode() {
        return this.currentCol + this.currentRow * 5000;
    }
}
