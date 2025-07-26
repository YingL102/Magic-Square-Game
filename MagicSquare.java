public class MagicSquare {
    protected int[][] array;
    protected int n;

    //Create a constructor that takes n as the number of rows and columns
    public MagicSquare(int num){
        n = num;
        array = new int[n][n];
        zeroArray();
        generateMagicSquare();
    }

    //Intialise the values in the array to 0
    private void zeroArray(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                array[i][j] = 0;
            }
        }
    }

    //Generating the Magic Square
    public void generateMagicSquare(){
        int x = 0;
        int y = ((n + 1) / 2) - 1;
        array[x][y] = 1;

        for (int i = 2; i < (n * n) + 1; i++){
            
            // Checking to see if x or y is a negative value outside the array that needs to be wrapped around
            int wrapX;
            int wrapY;

            if (x == 0) {
                wrapX = n - 1;
            } 
            else{ 
                wrapX = x - 1;
            }

            if (y == 0) {
                wrapY = n - 1;
            }
            else{
                wrapY = y - 1;
            }

            //Wraps around to the previous row or column if the cell is occupied
            if(array[wrapX][wrapY] == 0){
                x = wrapX;
                y = wrapY;
            }
            else{
                x = (x + 1) % n; 
            }
            
            array[x][y] = i;
        }
    }

    public void displayMagicSquare(){

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(array[i][j] + " " );
            }

            System.out.println();

        }
    }
}