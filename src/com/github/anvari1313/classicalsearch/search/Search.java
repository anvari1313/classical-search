package com.github.anvari1313.classicalsearch.search;

import com.github.anvari1313.classicalsearch.problem.Problem;
import com.github.anvari1313.classicalsearch.problem.ProblemAction;
import com.github.anvari1313.classicalsearch.problem.ProblemState;

import java.util.List;

public abstract class Search{
    protected Problem<ProblemState, ProblemAction> problem;

    protected boolean graphSearch;

    public Search(Problem p){
        this.problem = p;
        this.graphSearch = true;    // Enable graph search by default
    }

    public abstract List<ProblemAction> solve();

    public void setGraphSearch(boolean graphSearch) {
        this.graphSearch = graphSearch;
    }
}
