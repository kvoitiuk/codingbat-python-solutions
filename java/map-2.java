// Map-2:


// word0
// Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, always with the value 0. For example the string "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
public Map<String, Integer> word0(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  for(int i=0; i<strings.length; i++){
   map.put(strings[i], 0);
  }
  return map;
}


// wordLen
// Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.
public Map<String, Integer> wordLen(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  for(int i=0; i<strings.length; i++){
   map.put(strings[i], (strings[i]).length());
  }
  return map;
}

// pairs
// Given an array of non-empty strings, return a Map<String, String> where for every different string in the array, there is a key of its first character with the value of its last character.
public Map<String, String> pairs(String[] strings) {
  Map<String, String> map = new HashMap<String, String>();
  String first = "";
  String last = "";
  for(int i=0; i<strings.length; i++){
    first = strings[i].substring(0,1);
    last = (strings[i]).substring(strings[i].length()-1);
    map.put(first,last);
  }
  return map;
}


// wordCount
// The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.
public Map<String, Integer> wordCount(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  int atimes;
  for(int i=0; i<strings.length; i++){
    atimes = 0;
    for(int j=0; j<strings.length;j++) if(strings[i].equals(strings[j])) atimes ++;
    map.put(strings[i], atimes);
  }
  return map;
}

// firstChar
// Given an array of non-empty strings, return a Map<String, String> with a key for every different first character seen, with the value of all the strings starting with that character appended together in the order they appear in the array.
public Map<String, String> firstChar(String[] strings) {
  Map<String, String> map = new HashMap<String, String>();
  String first = "";
  String filling = "";
  for(int i=0; i<strings.length; i++){
    first = "" + strings[i].charAt(0);
    filling = map.get(first);
    if(filling == null) map.put(first, strings[i]);
    else map.put(first, (filling + strings[i]));
  }
  return map;
}

// wordAppend
// Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty string no string appears a 2nd time.
public String wordAppend(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  String result = "";
  for(int i=0;i<strings.length;i++){
    if(map.get(strings[i])!=null){
      result += strings[i];
      map.remove(strings[i]);
    }else{
      map.put(strings[i],1);
    }  
  }
  return result;
  
}



// wordMiltiple
// Given an array of strings, return a Map<String, Boolean> where each different string is a key and value is true only if that string appears 2 or more times in the array.
public Map<String, Boolean> wordMultiple(String[] strings) {
  Map<String, Boolean> map = new HashMap<String, Boolean>();
  int count;
  for(int i=0; i<strings.length; i++){
    count = 0;
    for(int j=0; j<strings.length; j++){
     if (strings[i].equals(strings[j])) count ++; 
    }
   map.put(strings[i], count>=2);
  }
  return map;
}
codingbat solution: 
public Map<String, Boolean> wordMultiple(String[] strings) {
  Map<String, Boolean> map = new HashMap();
  for (String s:strings) {
    // plan for stored boolean:
    //   false = seen it once
    //   true = seen it twice or more
    if (!map.containsKey(s)) {
      map.put(s, false);
    }
    else if (map.get(s) == false) {  // works without this test
      map.put(s, true);
    }
  }
  return map;
}


// allSwap
// We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. When a position in the arrays has been swapped, it no longer matches anything. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
public String[] allSwap(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  String temp = "";
  String key = "";
  for(int i=0; i<strings.length;i++){
    if(strings[i]!=null){
      key = strings[i].substring(0,1);
      if(map.containsKey(key)){ //swap
        temp = strings[i];
        strings[i] = strings[map.get(key)];
        strings[map.get(key)] = temp;
        map.remove(key);
      }else{
      map.put(key,i);
      }
    }
  }

  return strings;
}


// firstSwap
// We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. A particular first char can only cause 1 swap, so once a char has caused a swap, its later swaps are disabled. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
public String[] firstSwap(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  Map<String, Integer> ban = new HashMap<String, Integer>();
  String temp = "";
  String key = "";
  for(int i=0; i<strings.length;i++){
    if(strings[i]!=null){
      key = strings[i].substring(0,1);
      if(map.containsKey(key) && !ban.containsKey(key)){ //swap
        temp = strings[i];
        strings[i] = strings[map.get(key)];
        strings[map.get(key)] = temp;
        map.remove(key);
        ban.put(key,i);
      }else{
      map.put(key,i);
      }
    }
  }

  return strings;
}


