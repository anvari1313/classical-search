package com.github.anvari1313.classicalsearch.search;

import com.github.anvari1313.classicalsearch.problem.Problem;
import com.github.anvari1313.classicalsearch.problem.ProblemAction;
import com.github.anvari1313.classicalsearch.problem.ProblemState;

import java.util.*;


public class BFS extends Search{


    public BFS(Problem p) {
        super(p);

    }

    @Override
    public List<ProblemAction> solve() {
        List<ProblemAction> result = new ArrayList<>();

        ProblemState state = super.problem.getInitState();
        Queue<ProblemState> openList = new LinkedList<>();

        openList.add(state);

        problem.visitState(state);


        while (! openList.isEmpty()) {
            state = openList.remove();

            HashSet<ProblemAction> validActions = problem.getActions(state);

            for (ProblemAction action :
                    validActions) {
                ProblemState s = problem.getResult(state, action);
                if (! problem.isVisited(s)){
                    problem.visitState(s);
                    System.out.println(s);
                    openList.add(s);
                }
            }

        }

        return result;
    }
}
