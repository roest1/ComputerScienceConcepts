import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Riley Oest
 * roest1
 * 89-9859039
 */

public class Lexer {
     
     public static final Map<String, String> ID_TOKENS = new HashMap<String, String>() {
          {
               put("if", "IF");
               put("for", "FOR");
               put("while", "WHILE");
               put("procedure", "PROC");
               put("return", "RETURN");
               put("int", "INT");
               put("else", "ELSE");
               put("do", "DO");
               put("break", "BREAK");
               put("end", "END");
               put("=", "ASSIGN");
               put("+", "ADD_OP");
               put("-", "SUB_OP");
               put("-", "SUB_OP");
               put("*", "MUL_OP");
               put("/", "DIV_OP");
               put("%", "MOD_OP");
               put(">", "GT");
               put("<", "LT");
               put(">=", "GE");
               put("<=", "LE");
               put("++", "INC");
               put("(", "LP");
               put(")", "RP");
               put("{", "LB");
               put("}", "RB");
               put("|", "OR");
               put("&", "AND");
               put("==", "EE");
               put("!", "NEG");
               put(",", "COMMA");
               put(";", "SEMI");
          }
     };

     public static ArrayList<String> tokens = new ArrayList<>();

     public static Character currentToken;

     public static void lex(BufferedReader br) throws IOException {
          currentToken = (char) br.read();
     }
     
     public static String lexeme = "";

     public static void Tokenize(String fileName) throws IOException {
          BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
          int c = 0;
          while ((c = br.read()) != -1) {
               currentToken = (char) c;
               
               while(Character.isLetter(currentToken) || Character.isDigit(currentToken)) {
                    lexeme += currentToken;
                    lex(br);
               }
               
               if (!ID_TOKENS.containsKey(lexeme)) {
                    try {
                         Integer.parseInt(lexeme);
                         tokens.add("INT_CONST");
                         lexeme = "";
                    } catch (NumberFormatException nfe) {

                    }
               }
               

               if (!ID_TOKENS.containsKey(lexeme) && lexeme.length() >= 1 && Character.isLetter(lexeme.charAt(0))) {
                    tokens.add("IDENT");
                    lexeme = "";
               }
               if(ID_TOKENS.containsKey(lexeme)) {
                    tokens.add(ID_TOKENS.get(lexeme));
                    lexeme = "";
               }
               if (ID_TOKENS.containsKey(currentToken.toString())) {
                   
                    if (currentToken == '<') {
                         lex(br);
                         if (currentToken == '=') {
                              tokens.add("LE");
                         }
                         else {
                              tokens.add("LT");
                         }
                    }
                    else if (currentToken == '>') {
                         lex(br);
                         if (currentToken == '=') {
                              tokens.add("GE");
                         }
                         else {
                              tokens.add("GT");
                         }
                    }
                    else if (currentToken == '+') {
                         lex(br);
                         if (currentToken == '+') {
                              tokens.add("INC");
                         }
                         else{
                              tokens.add("ADD_OP");
                         }
                    }
                    else if(currentToken == '=') {
                         lex(br);
                         if (currentToken == '=') {
                              tokens.add("EE");
                         }
                         else {
                              tokens.add("ASSIGN");
                         }
                    }
                    else {
                         tokens.add(ID_TOKENS.get(currentToken.toString()));
                    }
                    lexeme = "";
               }
               if (lexeme == "") {
                    continue;
               }
               else {
                    tokens.add("SYNTAX ERROR: INVALID IDENTIFIER NAME");
                    break;
               }
               
          }
          for(int i = 0; i < tokens.size(); i++) {
               System.out.println(tokens.get(i));
          }
          
     }
}
