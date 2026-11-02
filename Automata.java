package TOC;

import java.util.Set;

public class Automata {
	static DFA startCodon() {
        final int Q0 = 0, Q1 = 1, Q2 = 2, Q3 = 3, Q4 = 4;
        int[][] d = {
           {Q1, Q4, Q4, Q4, Q4},
           {Q4, Q4, Q4, Q2, Q4},
           {Q4, Q4, Q3, Q4, Q4},
           {Q3, Q3, Q3, Q3, Q4},  
           {Q4, Q4, Q4, Q4, Q4}  
        };
        
        return new DFA("Start Codon DFA", "ACGT",
                new String[]{"q0", "q1", "q2", "q3", "q4"},
                d, Q0, Set.of(Q3));
    }
	static DFA validation() {
        final int Q5 = 0, Q6 = 1;
        int[][] d = {
          {Q5, Q5, Q5, Q5, Q6},
          {Q6, Q6, Q6, Q6, Q6}    
        };
        return new DFA("Validation DFA (Σ = {A,C,G,T})", "ACGT",
                new String[]{"q5", "q6"},
                d, Q5, Set.of(Q5));
    }

	static DFA minimizedDFA() {
	
	    final int DEAD = 10;
	
	    // Columns: A, C, G, T, Invalid
	    int[][] d = {
	        {1, DEAD, DEAD, DEAD, DEAD},     // q0
	        {DEAD, DEAD, DEAD, 2, DEAD},     // q1
	        {DEAD, DEAD, 3, DEAD, DEAD},     // q2
	        {4, DEAD, DEAD, DEAD, DEAD},     // q3
	        {DEAD, DEAD, DEAD, 5, DEAD},     // q4
	        {4, DEAD, DEAD, 6, DEAD},        // q5
	        {7, DEAD, 8, DEAD, DEAD},        // q6
	        {9, DEAD, 9, DEAD, DEAD},        // q7
	        {9, DEAD, DEAD, DEAD, DEAD},     // q8
	        {DEAD, DEAD, DEAD, DEAD, DEAD},  // q9 - Final
	        {DEAD, DEAD, DEAD, DEAD, DEAD}   // q10 - Dead
	    };
	
	    String[] states = {
	        "q0", "q1", "q2", "q3", "q4",
	        "q5", "q6", "q7", "q8",
	        "qFinal", "qDead"
	    };
	
	    return new DFA(
	        "Minimized DNA Pattern DFA",
	        "ACGT",
	        states,
	        d,
	        0,
	        Set.of(9)
	    );
	}
	

}
