package TOC;
import java.util.*;

/*
 * Main.java - Part B: Stop Codon DFAs, Middle Motif DFA and the combined ε-NFA
 *
 * Each machine is built from its transition table in the report and then tested.
 * The machines are simulated step by step (no built-in string searching),
 * so every module can be demonstrated on its own.
 *
 * Alphabet Σ = {A, C, G, T}
 */
public class Main {
    public static void main(String[] args) {

        // ===================== MIDDLE MOTIF DFA: (AT)^n, n >= 1 =====================
        // Start state: q0   Accepting state: q2   Dead/trap state: q3
        MapDFA MotifDFA = new MapDFA("q0", Set.of("q2"));
       //from q0 on all inputs
        MotifDFA.addTransition("q0", 'A', "q1");
        MotifDFA.addTransition("q0", 'C', "q3");
        MotifDFA.addTransition("q0", 'G', "q3");
        MotifDFA.addTransition("q0", 'T', "q3");

        //from q1 on all inputs
        MotifDFA.addTransition("q1", 'A', "q3");
        MotifDFA.addTransition("q1", 'C', "q3");
        MotifDFA.addTransition("q1", 'G', "q3");
        MotifDFA.addTransition("q1", 'T', "q2");

        //from q2 on all inputs
        MotifDFA.addTransition("q2", 'A', "q1");
        MotifDFA.addTransition("q2", 'C', "q3");
        MotifDFA.addTransition("q2", 'G', "q3");
        MotifDFA.addTransition("q2", 'T', "q3");

       //from q3 on all inputs
        MotifDFA.addTransition("q3", 'A', "q3");
        MotifDFA.addTransition("q3", 'C', "q3");
        MotifDFA.addTransition("q3", 'G', "q3");
        MotifDFA.addTransition("q3", 'T', "q3");

        // Test: should be accepted (AT repeated twice)
        MotifDFA.accepts("ATAT");

    //---------------------------------------------------------------------------//

        // ===================== STOP CODON DFA 1: TAA =====================
        // Start state: q0   Accepting state: q3   Dead/trap state: q4
        MapDFA TAA = new MapDFA("q0", Set.of("q3"));
       //from q0 on all inputs
        TAA.addTransition("q0", 'A', "q4");
        TAA.addTransition("q0", 'C', "q4");
        TAA.addTransition("q0", 'G', "q4");
        TAA.addTransition("q0", 'T', "q1");

        //from q1 on all inputs
        TAA.addTransition("q1", 'A', "q2");
        TAA.addTransition("q1", 'C', "q4");
        TAA.addTransition("q1", 'G', "q4");
        TAA.addTransition("q1", 'T', "q4");

        //from q2 on all inputs
        TAA.addTransition("q2", 'A', "q3");
        TAA.addTransition("q2", 'C', "q4");
        TAA.addTransition("q2", 'G', "q4");
        TAA.addTransition("q2", 'T', "q4");

       //from q3 on all inputs
        TAA.addTransition("q3", 'A', "q4");
        TAA.addTransition("q3", 'C', "q4");
        TAA.addTransition("q3", 'G', "q4");
        TAA.addTransition("q3", 'T', "q4");
       
        //from q4 on all inputs
        TAA.addTransition("q4", 'A', "q4");
        TAA.addTransition("q4", 'C', "q4");
        TAA.addTransition("q4", 'G', "q4");
        TAA.addTransition("q4", 'T', "q4");

        // Test: should be accepted
        TAA.accepts("TAA");
    //---------------------------------------------------------------------------//

        // ===================== STOP CODON DFA 2: TAG =====================
        // Start state: q0   Accepting state: q3   Dead/trap state: q4
        MapDFA TAG = new MapDFA("q0", Set.of("q3"));
       //from q0 on all inputs
        TAG.addTransition("q0", 'A', "q4");
        TAG.addTransition("q0", 'C', "q4");
        TAG.addTransition("q0", 'G', "q4");
        TAG.addTransition("q0", 'T', "q1");

        //from q1 on all inputs
        TAG.addTransition("q1", 'A', "q2");
        TAG.addTransition("q1", 'C', "q4");
        TAG.addTransition("q1", 'G', "q4");
        TAG.addTransition("q1", 'T', "q4");

        //from q2 on all inputs
        TAG.addTransition("q2", 'A', "q4");
        TAG.addTransition("q2", 'C', "q4");
        TAG.addTransition("q2", 'G', "q3");
        TAG.addTransition("q2", 'T', "q4");

       //from q3 on all inputs
        TAG.addTransition("q3", 'A', "q4");
        TAG.addTransition("q3", 'C', "q4");
        TAG.addTransition("q3", 'G', "q4");
        TAG.addTransition("q3", 'T', "q4");
       
        //from q4 on all inputs
        TAG.addTransition("q4", 'A', "q4");
        TAG.addTransition("q4", 'C', "q4");
        TAG.addTransition("q4", 'G', "q4");
        TAG.addTransition("q4", 'T', "q4");

        // Test: should be accepted
        TAG.accepts("TAG");
    //---------------------------------------------------------------------------//

        // ===================== STOP CODON DFA 3: TGA =====================
        // Start state: q0   Accepting state: q3   Dead/trap state: q4
        MapDFA TGA = new MapDFA("q0", Set.of("q3"));
       //from q0 on all inputs
        TGA.addTransition("q0", 'A', "q4");
        TGA.addTransition("q0", 'C', "q4");
        TGA.addTransition("q0", 'G', "q4");
        TGA.addTransition("q0", 'T', "q1");

        //from q1 on all inputs
        TGA.addTransition("q1", 'A', "q4");
        TGA.addTransition("q1", 'C', "q4");
        TGA.addTransition("q1", 'G', "q2");
        TGA.addTransition("q1", 'T', "q4");

        //from q2 on all inputs
        TGA.addTransition("q2", 'A', "q3");
        TGA.addTransition("q2", 'C', "q4");
        TGA.addTransition("q2", 'G', "q4");
        TGA.addTransition("q2", 'T', "q4");

       //from q3 on all inputs
        TGA.addTransition("q3", 'A', "q4");
        TGA.addTransition("q3", 'C', "q4");
        TGA.addTransition("q3", 'G', "q4");
        TGA.addTransition("q3", 'T', "q4");
       
        //from q4 on all inputs
        TGA.addTransition("q4", 'A', "q4");
        TGA.addTransition("q4", 'C', "q4");
        TGA.addTransition("q4", 'G', "q4");
        TGA.addTransition("q4", 'T', "q4");

        // Test: should be accepted
        TGA.accepts("TGA");
    //---------------------------------------------------------------------------//

        // ===================== COMBINED ε-NFA =====================
        // Built by joining the five DFAs with ε-transitions.
        //   q0-q3   Start codon (ATG)
        //   q4-q6   Middle motif (AT)^n
        //   q7-q10  Stop codon TAA
        //   q11-q14 Stop codon TAG
        //   q15-q18 Stop codon TGA
        // Only the stop codon final states (q10, q14, q18) are accepting.

        EpsilonNFA ENFA = new EpsilonNFA("q0", Set.of("q10", "q14", "q18"));

        // Start codon: A -> T -> G
        ENFA.addTransition("q0", 'A', "q1");

        ENFA.addTransition("q1", 'T', "q2");

        ENFA.addTransition("q2", 'G', "q3");

        // ε-transition: end of start codon (q3) -> start of middle motif (q4)
        ENFA.addTransition("q3", EpsilonNFA.EPSILON, "q4");

        // Middle motif: AT, then A loops back to q5 for each extra AT
        ENFA.addTransition("q4", 'A', "q5");

        ENFA.addTransition("q5", 'T', "q6");

        ENFA.addTransition("q6", 'A', "q5");

        // ε-transitions: end of middle motif (q6) -> start of each stop codon DFA
        ENFA.addTransition("q6", EpsilonNFA.EPSILON, "q7");
        
        ENFA.addTransition("q6", EpsilonNFA.EPSILON, "q11");

        ENFA.addTransition("q6", EpsilonNFA.EPSILON, "q15");

        // Stop codon TAA: TAA (accept at q10)
        ENFA.addTransition("q7", 'T', "q8");

        ENFA.addTransition("q8", 'A', "q9");

        ENFA.addTransition("q9", 'A', "q10");

        // Stop codon TAG: TAG (accept at q14)
        ENFA.addTransition("q11", 'T', "q12");

        ENFA.addTransition("q12", 'A', "q13");

        ENFA.addTransition("q13", 'G', "q14");

        // Stop codon TGA: TGA (accept at q18)
        ENFA.addTransition("q15", 'T', "q16");

        ENFA.addTransition("q16", 'G', "q17");

        ENFA.addTransition("q17", 'A', "q18");

    }
}