package botify;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Random;

public class Botify {
    
public static void main(String args[])
{  chatbot c=new chatbot();
   String sResponse = "";
   String sInput = "";
    int id = 0;
   int count=0;
   int cnt=0;
   int nSelection=0;
    try
    {    
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot","root","anu30@radha");
        Statement stmt = con.createStatement();
        
       ResultSet rs=stmt.executeQuery("select ques from chatbot.question");
       
       while(rs.next())
            count++;
       while(true)
       {
       System.out.print(">");
			String sPrevInput = sInput;
			String sPrevResponse = sResponse;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			sInput = in.readLine();
                       // System.out.println(sInput);
                        sInput = c.preProcessInput(sInput);
                        //System.out.println(sInput);
                        String qry = "select qid from chatbot.question where upper(ques) like '" + sInput + "'"; 
                        //System.out.println(qry);
                        String sqlquery=qry;
                        //System.out.println(sqlquery);
                        PreparedStatement pstmt= con.prepareStatement(sqlquery);
                        
                        ResultSet rs1= pstmt.executeQuery();
                       // System.out.println(rs1.getInt(1));
                       // System.out.println(rs1.eof());
                        //while(rs1.next())
                        //rs1.first();
                        if(rs1.next())
                        id=rs1.getInt(1);
                        
                        String sqlquery1="select ans from chatbot.answer where answer.qid="+id+"";
                        PreparedStatement pstmt1=con.prepareStatement(sqlquery1);
                        
                        ResultSet rs2=pstmt1.executeQuery();
                        
                         //System.out.println(rs2.getString(2));
                        while(rs2.next())
                        {  
                            String sqlstring="insert into chatbot.temp(ans_selected)values('"+rs2.getString("ans")+"')";
                            
                            // stmt.executeUpdate(sqlstring);
                          // System.out.println(sqlstring.valueOf(c1));
                            
                            PreparedStatement pstmt2=con.prepareStatement(sqlstring);
                        
                           pstmt2.executeUpdate();
                       
                            cnt++;
                            
                            
                        } 
                      if(sPrevInput.equalsIgnoreCase(sInput) && sPrevInput.length() > 0) {
				// controling repetitions made by the user
				System.out.println("YOU ARE REPEATING YOURSELF.");
			} else if(sInput.equalsIgnoreCase("BYE")) {
				System.out.println("IT WAS NICE TALKING TO YOU USER, SEE YOU NEXT TIME!");
				break;
			} else if(cnt == 0) {
				// handles the case when the program doesn't understand what the user is talking about	
				System.out.println("I'M NOT SURE IF I UNDERSTAND WHAT YOU ARE TALKING ABOUT.");
			} else {
				//Random generator = new Random();
				nSelection = 0 + (int)(Math.random() * cnt);
                                //System.out.println(cnt);
                                //System.out.println(nSelection);
                                String sqlquery2="select ans_selected from chatbot.temp where temp.tid="+nSelection;
                                 PreparedStatement pstmt3=con.prepareStatement(sqlquery2);
                        
                             ResultSet rs3=pstmt3.executeQuery();
                             
                                if(rs3.next())
                                {   
                                sResponse=rs3.getString("ans_selected");
                              // System.out.println(sResponse);
                                }
                                
                                
                                
                                
				//sResponse = responses.elementAt(nSelection);
				// avoids repeating the same response
				if(sResponse == sPrevResponse) {
					//responses.removeElementAt(nSelection);
                                       String sqlquery3="delete from chatbot.temp where temp.tid="+nSelection;
                                        PreparedStatement pstmt4=con.prepareStatement(sqlquery3);
                                        
                                        pstmt4.executeUpdate(sqlquery3);
					nSelection =0 + (int)(Math.random() * cnt);
					String sqlquery4="select ans_selected from chatbot.temp where temp.tid="+nSelection;
                                        PreparedStatement pstmt5=con.prepareStatement(sqlquery4);
                                        ResultSet rs4=pstmt5.executeQuery();
                                        if(rs4.next())
                                        sResponse=rs4.getString(2);
                                
				}
                                
                       System.out.println(sResponse);
                       
                   }
                         
                    // String sqlquery5="delete from chatbot.temp";
                    // PreparedStatement pstmt6=con.prepareStatement(sqlquery5);
                    // pstmt6.executeUpdate(sqlquery5);
                     //if(i>0)
                     // System.out.println("deleted");
                   

           
			
      
}
    }
   catch(Exception e)
   {
       System.out.println(e);
   }
//  System.out.println(count);

    

}
}