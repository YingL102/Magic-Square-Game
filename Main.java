import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validNumInput = false;
        boolean validSwapInput = false;
        int numSize = 0;

        while(validNumInput == false){
            System.out.print("Enter an odd number to generate the magic square: ");
            String size = scanner.nextLine();

            try{
                numSize = Integer.valueOf(size);
                if (numSize % 2 == 1){
                    validNumInput = true;
                }
                else{
                    System.out.println("Invalid input");
                }
            }

            catch (NumberFormatException e){
                System.out.println("Invalid input");
            }
        }

        MSGame msGame = new MSGame(numSize);
        msGame.randomiseMagicSquare();

        while(msGame.completedGame() != true){

            validSwapInput = false;
            msGame.displayRandomisedSquare();
    
            //Loops until a valid instruction input is made
            while(validSwapInput==false){
                System.out.print("Type in value you want to swap (row col dir e.g. 1 1 R): ");
                String swapInput = scanner.nextLine();

                validSwapInput = msGame.getInput(swapInput);
    
              if(validSwapInput == false){
                System.out.println("Invalid Input");
              }
    
            }
          }
        scanner.close();
    
  
    }

}
