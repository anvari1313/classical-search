package com.github.anvari1313.classicalsearch.problem.rubixcube;

import com.github.anvari1313.classicalsearch.problem.ProblemState;

public class RubixCubeProblemState extends ProblemState {
    public static final int SIDE_DIMENSION_SIZE = 2;

    public enum RubixCubeSlideColors {
        R,      // Stands for red color
        G,      // Stands for green color
        B,      // Stands for blue color
        W,      // Stands for white color
        O,      // Stands for orange color
        Y       // Stands for yellow color
    }

    /**
     * This matrix should hold the value of colors on each side
     * The first dimension of matrix shows the side index and the second and third will
     * dimension of x and of on each side.
     * Sides are in the following order:
     * 0    ->  Top
     * 1    ->  Front
     * 2    ->  Bottom
     * 3    ->  Back
     * 4    ->  Left
     * 5    ->  Right
     */
    private RubixCubeSlideColors[][][] cubeValues;

    public RubixCubeProblemState(RubixCubeSlideColors colorsStream[]){
        cubeValues = new RubixCubeSlideColors[6][SIDE_DIMENSION_SIZE][SIDE_DIMENSION_SIZE];

        int streamIndex = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                    cubeValues[i][j][k] = colorsStream[streamIndex++];
                }
            }
        }


    }

    @Override
    public boolean equalityCheck(ProblemState o) {
        if (o instanceof RubixCubeProblemState){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                    for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                        if (cubeValues[i][j][k] != ((RubixCubeProblemState) o).cubeValues[i][j][k])
                            return false;
                    }
                }
            }
            return true;
        } else
            return false;
    }


    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < SIDE_DIMENSION_SIZE; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res += "  ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res +=  cubeValues[0][i][j] + " ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res += "  ";
            }
            res += "\n";
        }

        for (int i = 0; i < SIDE_DIMENSION_SIZE; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res +=  cubeValues[4][i][j] + " ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res +=  cubeValues[1][i][j] + " ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res +=  cubeValues[5][i][j] + " ";
            }
            res += "\n";
        }

        for (int i = 0; i < SIDE_DIMENSION_SIZE; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res += "  ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res +=  cubeValues[2][i][j] + " ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res += "  ";
            }
            res += "\n";
        }

        for (int i = 0; i < SIDE_DIMENSION_SIZE; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res += "  ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res +=  cubeValues[3][i][j] + " ";
            }
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                res += "  ";
            }
            res += "\n";
        }

        return res;
    }
}
