package TOC;
import java.util.*;

public class EpsilonNFA {
    public static final char EPSILON = 'ε';
    private String start;
    private Set<String> accept;
    private Map<String, Map<Character, Set<String>>> delta = new HashMap<>();

    public EpsilonNFA(String start, Set<String> accept){
        this.start = start;
        this.accept = accept;
    }

    public void addTransition(String from, char symbol, String to){
        delta.computeIfAbsent(from, k -> new HashMap<>()).computeIfAbsent(symbol, k -> new HashSet<>()).add(to);
    }

    public Set<String> epsilonClosure(Set<String> states){
        Set<String> closure = new HashSet<>(states);
        Deque<String> pending = new ArrayDeque<>(states);

        while (!pending.isEmpty()) {
            String state = pending.removeFirst();
            Map<Character, Set<String>> transitions = delta.get(state);
            if (transitions == null) {
                continue;
            }

            Set<String> epsilonTransitions = transitions.get(EPSILON);
            if (epsilonTransitions != null) {
                for (String next : epsilonTransitions) {
                    if (closure.add(next)) {
                        pending.addLast(next);
                    }
                }
            }
        }

        return closure;
    }

    
    public boolean accepts(String input){
        Set<String> current = epsilonClosure(Collections.singleton(start));
        for(char c : input.toCharArray()){
            Set<String> nextStates = new HashSet<>();
            for (String state : current) {
                Map<Character, Set<String>> transitions = delta.get(state);
                if (transitions != null && transitions.get(c) != null) {
                    nextStates.addAll(transitions.get(c));
                }
            }
            current = epsilonClosure(nextStates);
            //System.out.println(current);
            System.out.println("read " + c + " -> " + new TreeSet<>(current));
        }

        boolean result = !Collections.disjoint(accept, current);

        if (result) {
            System.out.println(input + " is Accepted");
        } else {
            System.out.println(input + " is Rejected");
        }

        return result;
    }
    
}
