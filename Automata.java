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

}
