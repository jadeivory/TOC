package TOC;
import java.util.*;

public class MapDFA {
    private String start;
    private Set<String> accept;
    private Map<String, Map<Character, String>> delta = new HashMap<>();

    public MapDFA(String start, Set<String> accept){
        this.start = start;
        this.accept = accept;
    }

    public void addTransition(String from, char symbol, String to){
        delta.computeIfAbsent(from, k -> new HashMap<>()).put(symbol, to);
    }

    public boolean accepts(String input){
        String current = start;
        for(char c : input.toCharArray()){
            //shows each step
            System.out.println(current + " --" + c + "--> " + delta.get(current).get(c));
            current = delta.get(current).get(c); //from current state, read input, goes to next state, so effectively moving to the next state
        }

        boolean result = accept.contains(current);

        if (result) {
            System.out.println(input + " is Accepted");
        } else {
            System.out.println(input + " is Rejected");
        }

        return result;
    }
}
