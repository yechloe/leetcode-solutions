class Solution {
    static Map<Character, Character> bracketsMap = new HashMap<>();
    static {
        bracketsMap.put('(',')');
        bracketsMap.put('[',']');
        bracketsMap.put('{','}');
    }
    public boolean isValid(String s) {
        Stack<Character> recordStack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            Character single = s.charAt(i);
            if (bracketsMap.containsKey(single)) {
                recordStack.push(single);
            } else if (bracketsMap.containsValue(single)){
                if (recordStack.isEmpty()) {
                    return false;
                }
                Character lastRecord = recordStack.pop();
                if (bracketsMap.get(lastRecord) != single) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return recordStack.isEmpty();
    }
}