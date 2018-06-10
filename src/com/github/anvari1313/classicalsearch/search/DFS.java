package com.github.anvari1313.classicalsearch.search;

import com.github.anvari1313.classicalsearch.problem.Problem;
import com.github.anvari1313.classicalsearch.problem.ProblemAction;
import com.github.anvari1313.classicalsearch.problem.ProblemState;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static java.util.Collections.*;

public class DFS extends Search{
    public DFS(Problem p) {
        super(p);
    }

    @Override
    public List<ProblemAction> solve() {
        ArrayList<ProblemState> expandedStates = new ArrayList<>();  // This list will contains visitedStates

        ProblemState state = super.problem.getInitState();      // Set the current state to init state

        expandedStates.add(state);                              // Add current state to visited list

        if (super.problem.goalTest(state))
            return state.getActionSequence();

        Stack<ProblemState> openStack = new Stack<>();

        openStack.push(state);
        while (! openStack.empty()){
            state = openStack.pop();
            System.out.println(state);
            if (problem.goalTest(state))
            {
                List<ProblemAction> actionList = state.getActionSequence();
//                Collections.reverse(actionList);
                return actionList;
            }

            for (ProblemAction a : problem.getActions(state)){
                ProblemState nextState = problem.getResult(state, a);
                System.out.print("a = " + a);
                System.out.print(" expandedStates = " + expandedStates);
                System.out.print(" nextState = " + nextState);
                System.out.println(" expandedStates.contains(nextState) = " + expandedStates.contains(nextState));
                if (! expandedStates.contains(nextState)) {
                    expandedStates.add(nextState);
                    openStack.push(nextState);
                }
            }
        }

        return null;
    }
}
