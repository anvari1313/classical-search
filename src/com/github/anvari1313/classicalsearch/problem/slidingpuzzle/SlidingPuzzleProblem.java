package com.github.anvari1313.classicalsearch.problem.slidingpuzzle;

import com.github.anvari1313.classicalsearch.problem.Problem;

import java.util.HashSet;
import java.util.List;

public class SlidingPuzzleProblem extends Problem<SlidingPuzzleProblemState, SlidingPuzzleProblemAction> {
    @Override
    public SlidingPuzzleProblemState getInitState() {
        return null;
    }

    @Override
    public HashSet<SlidingPuzzleProblemAction> getActions(SlidingPuzzleProblemState s) {
        return null;
    }

    @Override
    public SlidingPuzzleProblemState getResult(SlidingPuzzleProblemState s, SlidingPuzzleProblemAction a) {
        return null;
    }

    @Override
    public boolean goalTest(SlidingPuzzleProblemState s) {
        return false;
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
