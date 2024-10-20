class Solution {
    private int index;

    private boolean sol(String s) {
        char exp = s.charAt(index); // Store the current operator
        boolean truePresent = false;
        boolean falsePresent = false;

        index += 2; // Skip the '('

        while (s.charAt(index - 1) != ')') { // Until we hit the closing bracket
            if (s.charAt(index) == 't') {
                truePresent = true;
            } else if (s.charAt(index) == 'f') {
                falsePresent = true;
            } else { // If another operator is present
                boolean rec = sol(s); // Recursive call
                if (rec) truePresent = true;
                else falsePresent = true;
            }
            index += 2; // Skip the ','
        }
        index--; // Move to index after the closing ')'

        if (exp == '|') return truePresent; // OR operator
        if (exp == '&') return !falsePresent; // AND operator
        return !truePresent; // NOT operator
    }

    public boolean parseBoolExpr(String expression) {
        index = 0; // Initialize the index
        return sol(expression);
    }
}
