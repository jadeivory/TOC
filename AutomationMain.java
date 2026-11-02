package TOC;

import java.util.Scanner;

public class AutomationMain {

	public static void main(String[] args) {
		 DFA start = Automata.startCodon();
	     DFA valid = Automata.validation();
	     DFA combined = Automata.minimizedDFA();
	        
	     Scanner in = new Scanner(System.in);
	     System.out.println("Please enter a  DNA sequence :");
	     System.out.println("To run default inputs enter 'tests' and enter 'quit' to exit.\n");  
	

	     while (true) {
	            System.out.print("Sequence> ");
	            if (!in.hasNextLine()) break;          
	            String line = in.nextLine();           
	 
	            if (line.equalsIgnoreCase("quit")) break;
	 
	            if (line.equalsIgnoreCase("tests")) {
	                runTests(start, "ATG", "ATGA", "ATGCCTA", "ATGTAA", "AT", "A", "", "TAG", "ATC", "GATG", "atg", "ATGX");
	                runTests(valid, "A", "G", "C", "T", "AGT", "ACGT", "AAAA", "", "ATGX", "x", "ATGCCTA", "AT G");
	                runTests(combined, "ATGATTAA", "ATGATTAG", "ATGATTGA", "ATGATATTAA", "ATGTAA", "ATGATAA", "ATGATCTAG");
	                continue;
	            }
	 
	            
	            System.out.println("Step 1 - " + valid.getName());
	            boolean legal = valid.trace(line);
	 
	            if (!legal) {
	                
	                System.out.println("Result: INVALID sequence (contains a symbol outside {A,C,G,T}).\n");
	                continue;
	            }
	 
	           
	            System.out.println("Step 2 - " + start.getName());
	            boolean hasStart = start.trace(line);
	            System.out.println("Result: valid DNA, " + (hasStart
	                    ? "begins with the start codon ATG.\n"
	                    : "but does NOT begin with the start codon ATG.\n"));
	            System.out.println("Step 3 - " + combined.getName());

	            boolean accepted = combined.trace(line);

	            System.out.println("Result: " +
	                (accepted
	                    ? "DNA sequence matches the complete pattern.\n"
	                    : "DNA sequence does NOT match the complete pattern.\n"));
	        }
	     
	        System.out.println("Goodbye.");
	    }
	 
	    static void runTests(DFA dfa, String... inputs) {
	        System.out.println("=== " + dfa.getName() + " ===");
	        for (String s : inputs) dfa.trace(s);
	        System.out.println();
	    }
	
	}
