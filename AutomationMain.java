package TOC;

import java.util.*;

public class AutomationMain {

	public static void main(String[] args) {

		DFA start = Automata.startCodon();
	    DFA valid = Automata.validation();

        //PART B
        //-----------------------------------------------------------------------------------------------------------//
        // All Part B machines are built here, before the program asks for input,
        // so they are ready to use inside the input loop below.

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

        //END OF PART B MACHINES
        //-----------------------------------------------------------------------------------------------------------//

	    Scanner in = new Scanner(System.in);
	    //System.out.println("Please enter a  DNA sequence :");
	    //System.out.println("To run default inputs enter 'tests', and enter 'quit' to exit.\n");


	    while (true) {
			System.out.println("\n=== DNA Sequence Pattern Analyzer ===");
	        System.out.println("1. Enter DNA sequence");
	        System.out.println("2. Run default test cases");
	        System.out.println("3. Exit");
	        System.out.print("Choose an option: ");

	        if (!in.hasNextLine()) {
	            break;
	        }
	        String choice = in.nextLine().trim();

	        if (choice.equals("3")) {
	            break;
	        }

	        if (choice.equals("2")) {
	            runTests(start, "ATG", "ATGA", "ATGCCTA", "ATGTAA", "AT", "A", "", "TAG", "ATC", "GATG", "atg", "ATGX");
				runTests(valid, "A", "G", "C", "T", "AGT", "ACGT", "AAAA", "", "ATGX", "x", "ATGCCTA", "AT G");
				MinimizedDFA.runTests();
	            continue;
	        }
	        if (!choice.equals("1")) {
	            System.out.println("Invalid option. Please try again.");
	            continue;
	        }

	        System.out.print("Enter DNA sequence: ");

	        if (!in.hasNextLine()) {
	            break;
	        }

	        String line = in.nextLine().trim().toUpperCase();

	           /* System.out.print("Sequence> ");
	            if (!in.hasNextLine()) break;
	            String line = in.nextLine();

	            if (line.equalsIgnoreCase("quit")) break;

	            if (line.equalsIgnoreCase("tests")) {
	                runTests(start, "ATG", "ATGA", "ATGCCTA", "ATGTAA", "AT", "A", "", "TAG", "ATC", "GATG", "atg", "ATGX");
	                runTests(valid, "A", "G", "C", "T", "AGT", "ACGT", "AAAA", "", "ATGX", "x", "ATGCCTA", "AT G");
	                runTests(combined, "ATGATTAA", "ATGATTAG", "ATGATTGA", "ATGATATTAA", "ATGTAA", "ATGATAA", "ATGATCTAG");
	                continue;
	            }*/

	            System.out.println("Step 1 - " + valid.getName());
            boolean legal = valid.trace(line);

            if (!legal) {
                System.out.println("Result: INVALID sequence (contains a symbol outside {A,C,G,T}).\n");
                continue;
            }

            // Split the sequence: first 3 letters = start codon, last 3 = stop codon, the rest = middle
            String head = line.length() >= 3 ? line.substring(0, 3) : line;
            String tail = line.length() >= 3 ? line.substring(line.length() - 3) : line;
            String middle = line.length() > 6 ? line.substring(3, line.length() - 3) : "";

            System.out.println("Step 2 - " + start.getName() + " on first 3 letters \"" + head + "\"");
            boolean hasStart = start.trace(head);
            System.out.println("Result: " + (hasStart
                    ? "begins with the start codon ATG.\n"
                    : "does NOT begin with the start codon ATG.\n"));

            System.out.println("Step 3 - Stop codon DFAs on last 3 letters \"" + tail + "\"");
            System.out.println("------------Checking against End Codon 'TAA'------------");
            boolean stopTAA = TAA.accepts(tail);
            System.out.println("------------------------");
            System.out.println("------------Checking against End Codon 'TAG'------------");
            boolean stopTAG = TAG.accepts(tail);
            System.out.println("------------------------");
            System.out.println("------------Checking against End Codon 'TGA'------------");
            boolean stopTGA = TGA.accepts(tail);
            System.out.println("------------------------");
            boolean hasStop = stopTAA || stopTAG || stopTGA;
            System.out.println("Result: " + (hasStop
                    ? "ends with a valid stop codon (TAA, TAG or TGA).\n"
                    : "does NOT end with a valid stop codon (TAA, TAG or TGA).\n"));

            System.out.println("Step 4 - Middle motif DFA on middle \"" + middle + "\"");
            boolean hasMotif = MotifDFA.accepts(middle);
            System.out.println("Result: " + (hasMotif
                    ? "middle is a valid (AT)^n, n >= 1 motif.\n"
                    : "middle is NOT a valid (AT)^n, n >= 1 motif.\n"));

            System.out.println("Step 5 - ε-NFA on full sequence");
            boolean nfaAccepted = ENFA.accepts(line);
            System.out.println("Result: " + (nfaAccepted
                    ? "the ε-NFA accepts the sequence.\n"
                    : "the ε-NFA rejects the sequence.\n"));

            System.out.println("Step 6 - Minimized DFA");

            boolean accepted = MinimizedDFA.simulate(line);
            System.out.println("Result: " + (accepted
                    ? "DNA sequence matches the complete pattern.\n"
                    : "DNA sequence does NOT match the complete pattern.\n"));


            // EQUIVALENCE CHECK: the minimized DFA (Step 6) and the ε-NFA (Step 5) must agree
            if (accepted == nfaAccepted) {
                System.out.println("Equivalence check: AGREE (both the ε-NFA and minimized DFA " + (accepted ? "accept" : "reject") + " the sequence)\n");
            } else {
                System.out.println("Equivalence check: MISMATCH (minimized DFA says " + accepted + ", ε-NFA says " + nfaAccepted + ")\n");
            }
        }

        System.out.println("Goodbye.");
	    }

	    static void runTests(DFA dfa, String... inputs) {
	        System.out.println("=== " + dfa.getName() + " ===");
	        for (String s : inputs) dfa.trace(s);
	        System.out.println();
	    }

	}
