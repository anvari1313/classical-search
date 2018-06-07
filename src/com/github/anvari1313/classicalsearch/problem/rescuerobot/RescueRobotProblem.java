package com.github.anvari1313.classicalsearch.problem.rescuerobot;

import com.github.anvari1313.classicalsearch.problem.Problem;
import com.github.anvari1313.classicalsearch.problem.ProblemAction;
import com.github.anvari1313.classicalsearch.problem.ProblemState;

import java.util.List;

public class RescueRobotProblem implements Problem {
    private int[][] enviroment;

    public RescueRobotProblem(){

    }

    @Override
    public ProblemState getInitState() {
        return null;
    }

    @Override
    public List<ProblemAction> getActions(ProblemState s) {
        return null;
    }

    @Override
    public ProblemState getResult(ProblemState s, ProblemAction a) {
        return null;
    }

    @Override
    public boolean goalTest(ProblemState s) {
        return false;
    }

    @Override
    public double pathCost(ProblemState initState, List<ProblemAction> actions) {
        return 0;
    }

    @Override
    public double stepCost(ProblemState state, ProblemAction action) {
        return 0;
    }

    @Override
    public double heuristic(ProblemState s) {
        return 0;
    }
}

class UnConnectedNeighbourCell{
    private int col1;
    private int row1;
    private int col2;
    private int row2;

    public UnConnectedNeighbourCell(int c1, int r1, int c2, int r2){
        this.col1 = c1;
        this.col2 = c2;
        this.row1 = r1;
        this.row2 = r2;
    }
}