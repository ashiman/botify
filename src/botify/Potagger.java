package botify;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Potagger {
    public static void main(String[] args) throws java.lang.Exception,IOException,ClassNotFoundException {
         
    String s=new String(" ");
    
    String noun[]=new String[10];
    MaxentTagger tagger = new MaxentTagger("C:\\Users\\user\\Documents\\NetBeansProjects\\botify\\taggers/english-left3words-distsim.tagger");
         
  
    BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
    while ((s = inp.readLine()) != null) {
   
      String[] words = s.split(" ");  //string is tokenized
    for(int i=0;i<words.length;i++)
    {
       // System.out.println(words[i]);  //printing tokenized string array
    }
     for(int j=0;j<words.length;j++)
     {
          String tagged = tagger.tagString(words[j]);
          //System.out.println(tagged);
          int index=tagged.indexOf("_");
         // System.out.println(index);
          //System.out.println(tagged.substring(index+1));
          if(tagged.substring(index+1).compareTo("NNS")>0||tagged.substring(index+1).compareTo("NNP")>0)
          {   
          
              noun[j]=words[j];
          }
          
       //System.out.println(noun[j]);
     }
    
        
    for(int j=0;j<noun.length;j++)
     {
         System.out.println(noun[j]);
     }

}
}
}



  
