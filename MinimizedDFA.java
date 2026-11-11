package TOC;

public class MinimizedDFA 
{
	// Minimized DFA has 11 states: q0 to q10
    // q9 is accepting; q10 is the dead state.
    static final int DEAD = 10;
    static final int START = 0;
    static final int ACCEPT = 9;

    // Columns: A, C, G, T, Invalid
    static final int[][] transitions = 
    {
        {1, DEAD, DEAD, DEAD, DEAD},       // q0
        {DEAD, DEAD, DEAD, 2, DEAD},       // q1
        {DEAD, DEAD, 3, DEAD, DEAD},       // q2
        {4, DEAD, DEAD, DEAD, DEAD},       // q3
        {DEAD, DEAD, DEAD, 5, DEAD},       // q4
        {4, DEAD, DEAD, 6, DEAD},          // q5
        {7, DEAD, 8, DEAD, DEAD},          // q6
        {9, DEAD, 9, DEAD, DEAD},          // q7
        {9, DEAD, DEAD, DEAD, DEAD},       // q8
        {DEAD, DEAD, DEAD, DEAD, DEAD},    // q9
        {DEAD, DEAD, DEAD, DEAD, DEAD}     // q10
    };
 // Convert a DNA nucleotide to a transition column.
    static int column(char symbol) 
    {
        switch (symbol) 
        {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return 4;
        }
    }
    
 // Simulate the minimized DFA.
    static boolean simulate(String dna)
    {
        int state = START;

        System.out.println("Starting at q" + state);

        for (int i = 0; i < dna.length(); i++) 
        {
            char symbol = dna.charAt(i);
            int nextState = transitions[state][column(symbol)];

            System.out.println(
                "q" + state + " --" + symbol + "--> q" + nextState
            );

            state = nextState;
        }

        boolean accepted = (state == ACCEPT);

        System.out.println(
            accepted ? "Result: ACCEPTED" : "Result: REJECTED"
        );

        return accepted;
    }
    // Run predefined test cases.
    static void runTests() 
    {
        String[] tests = 
        {
        	"Minimized DFA Test ",
            "ATGATTAA",
            "ATGATTAG",
            "ATGATTGA",
            "ATGATATTAA",
            "ATGTAA",
            "ATGATAA",
            "ATGATCTAG"
        };

        for (String test : tests) {
            System.out.println("\nTesting: " + test);
            simulate(test);
        }
    }

}

