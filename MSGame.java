import java.util.*;

public class MSGame extends MagicSquare{
    private int[][] randArray;
    private Random random;
    private int numMoves;

    public MSGame (int n) {
        super(n);
        randArray = new int[n][n];
        random = new Random();
        numMoves = 0;
    }

    //Shuffling the magic square into a new shuffled array
    public void randomiseMagicSquare(){

        // Copy the elements from the original array to the shuffled array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                randArray[i][j] = array[i][j];
            }
        }

        int i = 0;
        while(i < n * n) {
            int randX = random.nextInt(n);
            int randY = random.nextInt(n);

            int[] numbers = {1, -1, 0};
            int randomIndex = random.nextInt(numbers.length);
            int randX2 = randX + randomIndex;
            randomIndex = random.nextInt(numbers.length);
            int randY2 = randY + randomIndex;

            //Checks the number is in the square
            if(randX2 > -1 && randX2 < n && randY2 < n && randY2 > -1){
                //Swaps the two elements in the shuffled array
                int temp = randArray[randX][randY];
                randArray[randX][randY] = randArray[randX2][randY2];
                randArray[randX2][randY2] = temp;
 
                i++;
            }
        }
    }

    public boolean getInput(String input){
        try{
            String[] inputArray = input.split(" ");

            if (inputArray.length < 3) {
                return false; 
            }

            String row = inputArray[0];
            String col = inputArray[1];
            String dir = inputArray[2];
    
            int rowVal = Integer.valueOf(row)-1;
            int colVal = Integer.valueOf(col)-1;
    
            int newRow = rowVal;
            int newCol = colVal;
    
            // Determine new position based on direction
            if (dir.equals("U")) {
                newRow--;
            } 
            else if (dir.equals("D")) {
                newRow++;
            } 
            else if (dir.equals("L")) {
                newCol--;
            } 
            else if (dir.equals("R")) {
                newCol++;
            }
    
            // Check if new position is valid
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                // Swap the elements
                int temp = randArray[rowVal][colVal];
                randArray[rowVal][colVal] = randArray[newRow][newCol];
                randArray[newRow][newCol] = temp;
                numMoves++;
                return true;
            }   
            else{
                return false;
            }
        }
        catch(NumberFormatException e){
            return false;
        }

    }

    public boolean completedGame(){
        int size = randArray.length;
        int magicNumber = 0;
    
        // Calculate the magic number using the first row
        for (int j = 0; j < size; j++) {
            magicNumber += randArray[0][j];
        }
    
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += randArray[i][j];
                colSum += randArray[j][i];
            }
            if (rowSum != magicNumber || colSum != magicNumber) {
                return false;
            }
        }
    
        // Check one diagonal
        int firstDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            firstDiagonalSum += randArray[i][i];
        }
        if (firstDiagonalSum != magicNumber) {
            return false;
        }
    
        // Check secondary diagonal
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            secondaryDiagonalSum += randArray[i][size - 1 - i];
        }
        if (secondaryDiagonalSum != magicNumber) {
            return false;
        }
    

        System.out.println("The magic square has been finished in " + numMoves + " moves");
        return true;
        
    }

    public void displayRandomisedSquare(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(randArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
