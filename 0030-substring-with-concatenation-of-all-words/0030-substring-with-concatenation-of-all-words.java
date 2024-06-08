class Solution {
    //why am i checking this because i am letting the wrong values to be added in map.
    public boolean isMapEqual(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        for (String key : map1.keySet()) {
            if (map1.get(key) != map2.getOrDefault(key, 0))
                return false;
        }
        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;
        HashMap<String, Integer> freqOfWords = new HashMap<>();
        for (int i = 0; i < totalWords; i++) {
            freqOfWords.put(words[i], freqOfWords.getOrDefault(words[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int start = 0; start < wordLength; start++) {
            int i = start;
            HashMap<String, Integer> occurance = new HashMap<>();
            for (int j = i; j+wordLength <= s.length(); j = j + wordLength) {
                String word = s.substring(j, j + wordLength);
                if(freqOfWords.containsKey(word)){
                    occurance.put(word, occurance.getOrDefault(word, 0) + 1);
                    while (occurance.get(word) > freqOfWords.get(word)) {
                        String w = s.substring(i, i + wordLength);
                        occurance.put(w, occurance.getOrDefault(w, 0) - 1);
                        if (occurance.get(w) == 0)
                            occurance.remove(w);
                        i = i + wordLength;
                    }
                    if (j - i + wordLength == totalLength) {
                        ans.add(i);
                    }
                }
                else {
                    i = j+wordLength;
                    occurance.clear();
                }   
            }
        }
        return ans;
    }
}