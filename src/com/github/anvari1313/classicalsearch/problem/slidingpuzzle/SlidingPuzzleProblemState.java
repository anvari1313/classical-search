package com.github.anvari1313.classicalsearch.problem.slidingpuzzle;

import com.github.anvari1313.classicalsearch.problem.ProblemAction;
import com.github.anvari1313.classicalsearch.problem.ProblemState;

import java.util.List;

public class SlidingPuzzleProblemState extends ProblemState {
    private int [][] table;
    private int zeroCol;
    private int zeroRow;

    private void initTable(int [][]table){
        this.table = new int[SlidingPuzzleProblem.PUZZLE_SIZE][SlidingPuzzleProblem.PUZZLE_SIZE];
        for (int i = 0; i < SlidingPuzzleProblem.PUZZLE_SIZE; i++) {
            System.arraycopy(table[i], 0, this.table[i], 0, SlidingPuzzleProblem.PUZZLE_SIZE);
            for (int j = 0; j < SlidingPuzzleProblem.PUZZLE_SIZE; j++) {
                if (table[i][j] == 0){
                    zeroCol = j;
                    zeroRow = i;
                }
            }
        }
    }

    public SlidingPuzzleProblemState(int [][]table){
        super();
        initTable(table);
    }

    public SlidingPuzzleProblemState(int [][]table, List<ProblemAction> parentActionSequence){
        super(parentActionSequence);
        initTable(table);
    }

    @Override
    public boolean equalityCheck(ProblemState o) {
        if (o instanceof SlidingPuzzleProblemState) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] != ((SlidingPuzzleProblemState) o).table[i][j])
                        return false;
                }

            }

            return true;
        } else
            return false;
    }

    public int getZeroCol() {
        return zeroCol;
    }

    public int getZeroRow() {
        return zeroRow;
    }

    public int[][] getTable() {
        return table;
    }
}
