package com.github.anvari1313.classicalsearch.problem.rescuerobot;

import com.github.anvari1313.classicalsearch.problem.ProblemState;

public class RescueRobotProblemState extends ProblemState {
    private int currentRow;
    private int currentCol;

    public RescueRobotProblemState(int currentCol, int currentRow){
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
}
