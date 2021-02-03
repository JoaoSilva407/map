package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
public class Program {

    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        
        Map<String, Integer> votes = new HashMap<>();
        
        System.out.print("Enter file full path: ");
        String path = input.nextLine();
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
               
            String line = br.readLine();
            while(line != null) {
                
                String[] fields = line.split(",");
                String name = fields[0];
                int num = Integer.parseInt(fields[1]);
                
                if(votes.containsKey(name)) {
                    int quantity = votes.get(name);
                    votes.put(name, num + quantity);
                }
                else {
                    votes.put(name, num);
                }
                
                line = br.readLine();
            }
            
            for(String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        input.close();
    }
    
}
