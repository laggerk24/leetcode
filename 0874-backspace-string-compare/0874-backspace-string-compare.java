class Solution {
    public boolean backspaceCompare(String s, String t) {
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '#' && l1.size()>0){
                l1.remove(l1.size()-1);
            }
            else if(s.charAt(i) != '#'){
                l1.add(s.charAt(i));
            }
        }

        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == '#' && l2.size()>0){
                l2.remove(l2.size()-1);
            }
            else if(t.charAt(i) != '#'){
                l2.add(t.charAt(i));
            }
        }
        if(l1.size() != l2.size()) return false;
        for(int i=0;i<l1.size();i++){
            if(l1.get(i) != l2.get(i)) return false;
        }
        return true;
    }
}