import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NQueens {
    public boolean isSafe(int row ,int col, char[][] bo){
        //horizonatl
        for(int j = 0 ; j < bo.length;j++){
            if (bo[row][j] == 'Q') {
                return false;                
            }
        }
        
        //vertical        
        for(int j = 0 ; j < bo.length;j++){
            if (bo[j][col] == 'Q') {
                return false;                
            }
        }
        // upper left
        for(int c = col,r=row ;c>=0 && r>=0 ;c--,r--){
            if (bo[r][c] == 'Q') {
                return false;                
            }
        }
        
        //upper right
        for(int c = col,r=row ;c<bo.length && r>=0 ;c++,r--){
            if (bo[r][c] == 'Q') {
                return false;                
            }
        }

        //lower right
        for(int c = col,r=row ;r<bo.length && c>=0 ;c--,r++){
            if (bo[r][c] == 'Q') {
                return false;                
            }
        }


        for(int c = col,r=row ;c<bo.length && r<bo.length ;c++,r++){
            if (bo[r][c] == 'Q') {
                return false;                
            }
        }

        return true;
    }

    public void save(char[][] bo ,List<List<String>> allB ){
        List<String> Newbo = new ArrayList<>();

        for(int i = 0;i<bo.length;i++){
            String row = "";
            for(int j = 0 ; j<bo.length;j++){
                if (bo[i][j] == 'Q') {
                    row += 'Q';
                }else{
                    row += '.';
                }
            }
            Newbo.add(row);
        }
        allB.add(Newbo);
    }

    public void nqueen(char[][] bo,List<List<String>> allB,int col){
        if (col == bo.length) {
            save(bo,allB);
            return;
        }
        for(int row = 0; row < bo.length;row++){
            if (isSafe(row,col,bo)) {
                bo[row][col] = 'Q';
                nqueen(bo, allB, col+1);
                bo[row][col] = '.';

            }
        }
    }

    public List<List<String>> solveNQueens(int  n){
        List<List<String>> allB = new ArrayList<>();
        char[][] board = new char[n][n];
        nqueen(board, allB, 0);
        return allB;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter n : ");
        int n = sc.nextInt();
        NQueens solver = new NQueens();
        List<List<String>> sol = solver.solveNQueens(n);
        System.out.println("\n Total solution found are : "+sol.size());
        System.out.println("=====================\n");

        for(int i = 0 ; i< sol.size(); i++){
            System.out.println("solution "+ (i+1)+ " : ");

            List<String> currb = sol.get(i);

            for(String row : currb){
                String newr = row.replace("", " ").trim();
                System.out.println(newr);
            }
            System.out.println("\n-------------------------------------\n");
        }
    }
  
}
