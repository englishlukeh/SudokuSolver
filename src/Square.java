public class Square {

    private char[][] grid;
    private char[][] solution;
    private int dimension;
    private Boolean solved;

    public Square(int n){
        grid = new char[n][n];
        dimension = n;
    }

    public char[][] getGrid(){
        return this.grid;
    }

    public int getDimension(){
        return this.dimension;
    }

    public void initialize(String s){

        solved = false;

        for (int row = 0; row < dimension; row++){
            for (int col = 0; col < dimension; col++){
                grid[row][col] = s.charAt(row*dimension + col);
            }
        }
    }

    public void printOut(){
        for (int row = 0; row < this.dimension; row++){
            for (int col = 0; col < this.dimension; col++){
                System.out.print(this.grid[row][col]);
            }
            System.out.println();
        }
    }

    public Boolean rowContains(int row, char n){

        Boolean result = false;

        for (int i = 0; i < dimension; i++){
            if (getGrid()[row][i] == n){
                result = true;
            }
        }

        return result;
    }

    public Boolean colContains(int col, char n){
            Boolean result = false;

        for (int i = 0; i < dimension; i++){
            if (getGrid()[i][col] == n){
                result = true;
            }
        }

        return result;
    }

    public void solve(){
        solve(grid, 0);
    }

    public void solve(char[][] grid, int num){
        System.out.println(num);

        if (num == 0){
            if (grid[0][0] == ' ') {
                //solve first square
                for (int i = 1; i <= dimension; i++){
                    if (rowContains(0, Character.forDigit(i,10))){
                        continue;
                    }
                    if (colContains(0, Character.forDigit(i,10))){
                        continue;
                    }
                    grid[0][0] = Character.forDigit(i,10);
                    solve(grid, 1);
                }
            }
            else{
                solve(grid,1);
            }
        }

        else if (num == (this.dimension*this.dimension)-1){

            if (grid[this.dimension-1][this.dimension-1] != ' '){
                solved = true;
                this.grid = grid;
            }

            //solve last square and printout
            else{

                for (int i = 1; i <= dimension; i++) {
                    if (rowContains(0, Character.forDigit(i, 10))) {
                        continue;
                    }
                    if (colContains(0, Character.forDigit(i, 10))) {
                        continue;
                    }
                    grid[this.dimension - 1][this.dimension - 1] = Character.forDigit(i, 10);
                    solved = true;
                    this.grid = grid;
                    break;
                }
            }
        }

        else{
            if (grid[num/dimension][num%dimension] != ' '){
                solve(grid, num+1);
            }

            //solve next square
            else {
                for (int i = 1; i <= dimension; i++) {
                    System.out.println(i);
                    System.out.println("ne");
                    if (rowContains(0, Character.forDigit(i, 10))) {
                        continue;
                    }
                    if (colContains(0, Character.forDigit(i, 10))) {
                        continue;
                    }
                    System.out.println("found");
                    grid[num/dimension][num%dimension] = Character.forDigit(i, 10);

                    solve(grid, num + 1);

                }
            }
        }
    }

}
