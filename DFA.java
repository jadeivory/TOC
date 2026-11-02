package TOC;
import java.util.*;

public class DFA {
	 private final String name;
	    private final String alphabet;      
	    private final int[][] delta;        
	    private final int start;
	    private final Set<Integer> accepting;
	    private final String[] stateNames;
	    
	    DFA(String name, String alphabet, String[] stateNames, int[][] delta,
	            int start, Set<Integer> accepting) {
	            this.name = name;
	            this.alphabet = alphabet;
	            this.stateNames = stateNames;
	            this.delta = delta;
	            this.start = start;
	            this.accepting = accepting;
	        }

	    private int column(char c) {
	        int i = alphabet.indexOf(c);
	        return (i >= 0) ? i : alphabet.length();
	    }
	    boolean accepts(String input) {
	        int state = start;
	        for (char c : input.toCharArray()) {
	            state = delta[state][column(c)];
	        }
	        return accepting.contains(state);
	    }
	    boolean trace(String input) {
	        int state = start;
	        StringBuilder sb = new StringBuilder(stateNames[state]);
	        for (char c : input.toCharArray()) {
	            state = delta[state][column(c)];
	            sb.append(" -").append(c).append("-> ").append(stateNames[state]);
	        }
	        boolean ok = accepting.contains(state);
	        System.out.printf("  %-8s %s  => %s%n", "\"" + input + "\"", sb, ok ? "ACCEPT" : "REJECT");
	        return ok;
	    }

	    String getName() { return name; }
	
}
