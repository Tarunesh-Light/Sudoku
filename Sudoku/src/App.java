public class App {
    public static void main(String[] args) throws Exception {
        int [][] sudoku = {
            {3,0,6,5,0,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,0,6,3,0,0}
        };



        boolean checkrows(int[][] sudoku,int row,int number){
              
            for(int i=0;i<9;i++){
                if(number==sudoku[row][i]){
                    return false;
                }
            } return  true;
        }

        boolean checkcol(int[][] sudoku,int col,int number){
              
            for(int i=0;i<9;i++){
                if(number==sudoku[i][col]){
                    return false;
                }
            } return  true;
        }

        boolean gridbox(int[][] sudoku,int number,int row,int column){
            int gridrow = row - row%3;
            int gridcol = column - column%3;

            for(int i=gridrow;i<gridrow+3;i++){
                for(int j=gridcol;j<gridcol+3;j++){
                    if(sudoku[i][j]==number){
                        return false;
                    }
                }
            } return true;
        }

        boolean checking(int[][] sudoku,int number,int row,int column){
            return checkrows(sudoku,row,number) &&
            checkcol(sudoku,column,number) &&
            gridbox(sudoku,number,row,column);
        }

        boolean check(int[][] sudoku){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(sudoku[i][j]==0){
                        for(int no=1;no<=9;no++){
                            if(checking(sudoku,no,i,j)){
                            sudoku[i][j] = no;

                            if(check(sudoku)){
                                return true;
                            }
                            sudoku[i][j] = 0;
                        }
                    }
                    
                }return false; 
            }
        }
        return true; 
    }

}
