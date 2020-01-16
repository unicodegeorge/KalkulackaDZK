import java.util.ArrayList;
import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Kalkulacka {
    String stringNum = "";
    Scanner sc = new Scanner(System.in);
    ArrayList<String> operations = new ArrayList<String>();
    ArrayList<Integer> results = new ArrayList<Integer>();
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");
   
    public static void main(String[] args) {
       
     
        Kalkulacka op = new Kalkulacka();
        op.run();

      

        }

    

        public void run() {
            for(int x = 0; x<1000; x++) {
                System.out.println("");
            } 
           

           for(String operation : operations) {
               System.out.println(operation);
           }
            System.out.println("[ Kalkulacka - DZK - George Dvorak ]");
            System.out.println(stringNum);
            System.out.println("[7] [8] [9]");
            System.out.println("[4] [5] [6]");
            System.out.println("[1] [2] [3]");
            System.out.println("[*] [/] [+]");
            System.out.println("[  0  ] [-]");
            System.out.println("[    =    ]");

    
            System.out.println("Zadejte jake tlacitko chcete stisknout : ");
            char clickedBtn = sc.next().charAt(0);
            
            if(Character.isDigit(clickedBtn) || clickedBtn == '/' || clickedBtn == '+' || clickedBtn == '-' || clickedBtn == '*' ) {
                addNumToString(clickedBtn);
            } else if(clickedBtn == '='){
               eval();
            }
          

    
    }

    public void addNumToString(char num) {
        stringNum +=""+ num;
        run();
        
    }

    public void eval() {
        try {
            Object result = engine.eval(stringNum);

        stringNum = stringNum + " = "+result;
        operations.add(stringNum);
        stringNum="";
         run();
        } catch (Exception e) {
            System.out.println(e.getCause());
            
        }
        
    }
}