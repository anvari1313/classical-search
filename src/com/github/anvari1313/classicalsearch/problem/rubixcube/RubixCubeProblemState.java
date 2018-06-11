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
    private final int TOP_SIDE = 0;
    private final int FRONT_SIDE = 1;
    private final int BOTTOM_SIDE = 2;
    private final int BACK_SIDE = 3;
    private final int LEFT_SIDE = 4;
    private final int RIGHT_SIDE = 5;

    private RubixCubeSlideColors[][][] cubeValues;

    /**
     * Constructor for making the init state
     * @param colorsStream
     */
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

    public RubixCubeSlideColors[][][] rotateTopClockwise(){
        RubixCubeSlideColors[][][] result = new RubixCubeSlideColors[6][SIDE_DIMENSION_SIZE][SIDE_DIMENSION_SIZE];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                    result[i][j][k] = cubeValues[i][j][k];
                }
            }
        }
        RubixCubeSlideColors temp;

        // Rotating top side
        temp = result[TOP_SIDE][1][0];
        result[TOP_SIDE][1][0] = result[TOP_SIDE][1][1];
        result[TOP_SIDE][1][1] = result[TOP_SIDE][0][1];
        result[TOP_SIDE][0][1] = result[TOP_SIDE][0][0];
        result[TOP_SIDE][0][0] = temp;

        // Rotating left, front, right, back sides
        // Row 0
        temp = result[RIGHT_SIDE][0][0];
        result[RIGHT_SIDE][0][0] = result[RIGHT_SIDE][0][1];
        result[RIGHT_SIDE][0][1] = result[FRONT_SIDE][0][0];
        result[FRONT_SIDE][0][0] = result[FRONT_SIDE][0][1];
        result[FRONT_SIDE][0][1] = result[LEFT_SIDE][0][0];
        result[LEFT_SIDE][0][0] = result[LEFT_SIDE][0][1];
        result[LEFT_SIDE][0][1] = result[BACK_SIDE][1][0];
        result[BACK_SIDE][1][0] = result[BACK_SIDE][1][1];
        result[BACK_SIDE][1][1] = temp;

        // Row 1
        temp = result[RIGHT_SIDE][1][0];
        result[RIGHT_SIDE][1][0] = result[RIGHT_SIDE][1][1];
        result[RIGHT_SIDE][1][1] = result[FRONT_SIDE][1][0];
        result[FRONT_SIDE][1][0] = result[FRONT_SIDE][1][1];
        result[FRONT_SIDE][1][1] = result[LEFT_SIDE][1][0];
        result[LEFT_SIDE][1][0] = result[LEFT_SIDE][1][1];
        result[LEFT_SIDE][1][1] = result[BACK_SIDE][0][0];
        result[BACK_SIDE][0][0] = result[BACK_SIDE][0][1];
        result[BACK_SIDE][0][1] = temp;

        // Rotating bottom side
        temp = result[BOTTOM_SIDE][0][0];
        result[BOTTOM_SIDE][0][0] = result[BOTTOM_SIDE][0][1];
        result[BOTTOM_SIDE][0][1] = result[BOTTOM_SIDE][1][1];
        result[BOTTOM_SIDE][1][1] = result[BOTTOM_SIDE][1][0];
        result[BOTTOM_SIDE][1][0] = temp;

        return result;
    }
    public RubixCubeSlideColors[][][] rotateTopCounterClockwise(){
        RubixCubeSlideColors[][][] result = new RubixCubeSlideColors[6][SIDE_DIMENSION_SIZE][SIDE_DIMENSION_SIZE];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                    result[i][j][k] = cubeValues[i][j][k];
                }
            }
        }

        return result;
    }
    public RubixCubeSlideColors[][][] rotateFrontClockwise(){
        RubixCubeSlideColors[][][] result = new RubixCubeSlideColors[6][SIDE_DIMENSION_SIZE][SIDE_DIMENSION_SIZE];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                    result[i][j][k] = cubeValues[i][j][k];
                }
            }
        }

        return result;
    }
    public RubixCubeSlideColors[][][] rotateFrontCounterClockwise(){
        RubixCubeSlideColors[][][] result = new RubixCubeSlideColors[6][SIDE_DIMENSION_SIZE][SIDE_DIMENSION_SIZE];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                    result[i][j][k] = cubeValues[i][j][k];
                }
            }
        }

        return result;
    }
    public RubixCubeSlideColors[][][] rotateRightClockwise(){
        RubixCubeSlideColors[][][] result = new RubixCubeSlideColors[6][SIDE_DIMENSION_SIZE][SIDE_DIMENSION_SIZE];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                    result[i][j][k] = cubeValues[i][j][k];
                }
            }
        }

        return result;
    }
    public RubixCubeSlideColors[][][] rotateRightCounterClockwise(){
        RubixCubeSlideColors[][][] result = new RubixCubeSlideColors[6][SIDE_DIMENSION_SIZE][SIDE_DIMENSION_SIZE];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < SIDE_DIMENSION_SIZE; j++) {
                for (int k = 0; k < SIDE_DIMENSION_SIZE; k++) {
                    result[i][j][k] = cubeValues[i][j][k];
                }
            }
        }

        return result;
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
