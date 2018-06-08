package com.github.anvari1313.classicalsearch.problem.rubixcube;

import com.github.anvari1313.classicalsearch.problem.Problem;

import java.util.HashSet;
import java.util.List;

public class RubixCubeProblem extends Problem<RubixCubeProblemState,RubixCubeProblemAction> {
    @Override
    public RubixCubeProblemState getInitState() {
        return null;
    }

    @Override
    public HashSet<RubixCubeProblemAction> getActions(RubixCubeProblemState s) {
        return null;
    }

    @Override
    public RubixCubeProblemState getResult(RubixCubeProblemState s, RubixCubeProblemAction a) {
        return null;
    }

    @Override
    public boolean goalTest(RubixCubeProblemState s) {
        return false;
    }

    @Override
    public double pathCost(RubixCubeProblemState initState, List<RubixCubeProblemAction> rubixCubeProblemActions) {
        return 0;
    }

    @Override
    public double stepCost(RubixCubeProblemState rubixCubeProblemState, RubixCubeProblemAction rubixCubeProblemAction) {
        return 0;
    }

    @Override
    public double heuristic(RubixCubeProblemState s) {
        return 0;
    }
}
