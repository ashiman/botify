package botify;

import java.io.*;
import java.util.*;

public class chatbot extends Botify{
	
	final static int maxInput = 1;
	final static int maxResp = 3;
	final static String delim = "?!.;";
	
/*	static String[][] KnowledgeBase = {
			{"WHAT IS YOUR NAME", 
			 "MY NAME IS CHATTERBOT3.",
			 "YOU CAN CALL ME CHATTERBOT3.",
			 "WHY DO YOU WANT TO KNOW MY NAME?"
			},

			{"HI", 
			 "HI THERE!",
			 "HOW ARE YOU?",
			 "HI!"
			},
			
			{"HOW ARE YOU",
			 "I'M DOING FINE!",
			 "I'M DOING WELL AND YOU?",
			 "WHY DO YOU WANT TO KNOW HOW AM I DOING?"
			},

			{"WHO ARE YOU",
			 "I'M AN A.I PROGRAM.",
			 "I THINK THAT YOU KNOW WHO I'M.",
			 "WHY ARE YOU ASKING?"
			},

			{"ARE YOU INTELLIGENT",
			 "YES,OFCORSE.",
			 "WHAT DO YOU THINK?",
			 "ACTUALY,I'M VERY INTELLIENT!"
			},

			{"ARE YOU REAL",
			 "DOES THAT QUESTION REALLY MATERS TO YOU?",
			 "WHAT DO YOU MEAN BY THAT?",
			 "I'M AS REAL AS I CAN BE."
			}
		};*/
	
	static boolean isPunc(char ch) {
		return delim.indexOf(ch) != -1;
	}
	
	// removes punctuation and redundant
	// spaces from the user's input
	static StringBuffer cleanString(String str) {
		StringBuffer temp = new StringBuffer(str.length());
		char prevChar = 0;
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) == ' ' && prevChar == ' ' ) {
				continue;
			} else if(!isPunc(str.charAt(i))) {
				temp.append(str.charAt(i));
			}
			prevChar = str.charAt(i);
		}
		return temp;
	}
	
	static String preProcessInput(String str) {
		StringBuffer temp = new StringBuffer(str.toUpperCase());
		temp = cleanString(temp.toString());
		return temp.toString();
	}
	
	/*static Vector<String> findMatch(String str) {
		Vector<String> result = new Vector<String>(maxResp);
		for(int i = 0; i < KnowledgeBase.length; ++i) {
			// there has been some improvements made in
			// here in order to make the matching process
			// a littlebit more flexible
			if(str.indexOf(KnowledgeBase[i][0]) != -1) {
				for(int j = maxInput; j <= maxResp; ++j) {
					result.add(KnowledgeBase[i][j]);
				}
				break;
			}
		}
		return result;
	}*/

	
}