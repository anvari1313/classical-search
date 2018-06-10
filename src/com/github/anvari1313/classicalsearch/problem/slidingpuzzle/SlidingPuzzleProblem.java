package com.github.anvari1313.classicalsearch.problem.slidingpuzzle;

import com.github.anvari1313.classicalsearch.problem.Problem;

import java.util.HashSet;
import java.util.List;

public class SlidingPuzzleProblem extends Problem<SlidingPuzzleProblemState, SlidingPuzzleProblemAction> {
    public static final int PUZZLE_SIZE = 3;
    private SlidingPuzzleProblemState initState;
    private SlidingPuzzleProblemState goalState;

    public SlidingPuzzleProblem(int [][]initStateTable){
        initState = new SlidingPuzzleProblemState(initStateTable);      // Initialize init state
        int [][]goalStateTable = new int[PUZZLE_SIZE][PUZZLE_SIZE];
        int c = 0;
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            for (int j = 0; j < PUZZLE_SIZE; j++) {
                goalStateTable[i][j] = c++;
            }
        }
        goalState = new SlidingPuzzleProblemState(goalStateTable);

    }

    @Override
    public SlidingPuzzleProblemState getInitState() {
        return this.initState;
    }

    @Override
    public HashSet<SlidingPuzzleProblemAction> getActions(SlidingPuzzleProblemState s) {
        HashSet<SlidingPuzzleProblemAction> validActions = new HashSet<>();
        if (s.getZeroCol() != 0)
            validActions.add(new SlidingPuzzleProblemAction(SlidingPuzzleProblemAction.SlidingPuzzleProblemActions.L));
        if (s.getZeroCol() != SlidingPuzzleProblem.PUZZLE_SIZE - 1)
            validActions.add(new SlidingPuzzleProblemAction(SlidingPuzzleProblemAction.SlidingPuzzleProblemActions.R));
        if (s.getZeroRow() != 0)
            validActions.add(new SlidingPuzzleProblemAction(SlidingPuzzleProblemAction.SlidingPuzzleProblemActions.U));
        if (s.getZeroRow() != SlidingPuzzleProblem.PUZZLE_SIZE - 1)
            validActions.add(new SlidingPuzzleProblemAction(SlidingPuzzleProblemAction.SlidingPuzzleProblemActions.D));

        return validActions;
    }

    @Override
    public SlidingPuzzleProblemState getResult(SlidingPuzzleProblemState s, SlidingPuzzleProblemAction a) {
        int zeroCol = s.getZeroCol();
        int zeroRow = s.getZeroRow();
        int swapCol = zeroCol;
        int swapRow = zeroRow;


        int [][]table = new int[PUZZLE_SIZE][PUZZLE_SIZE];
        for (int i = 0; i < SlidingPuzzleProblem.PUZZLE_SIZE; i++) {
            System.arraycopy(s.getTable()[i], 0, table[i], 0, SlidingPuzzleProblem.PUZZLE_SIZE);
        }

        switch (a.getAction()){
            case D:
                swapRow ++;
                break;
            case L:
                swapCol --;
                break;
            case R:
                swapCol ++;
                break;
            case U:
                swapRow --;
                break;
        }

        int swap = table[swapRow][swapCol];
        table[zeroRow][zeroCol] = swap;
        table[swapRow][swapCol] = 0;

        SlidingPuzzleProblemState nextState = new SlidingPuzzleProblemState(table, s.getActionSequence());
        nextState.addActionSequence(a);

        return nextState;
    }

    @Override
    public boolean goalTest(SlidingPuzzleProblemState s) {
        return s.equals(goalState);
    }

    @Override
    public double pathCost(SlidingPuzzleProblemState initState, List<SlidingPuzzleProblemAction> slidingPuzzleProblemActions) {
        return 0;
    }

    @Override
    public double stepCost(SlidingPuzzleProblemState slidingPuzzleProblemState, SlidingPuzzleProblemAction slidingPuzzleProblemAction) {
        return 0;
    }

    @Override
    public double heuristic(SlidingPuzzleProblemState s) {
        return 0;
    }
}
