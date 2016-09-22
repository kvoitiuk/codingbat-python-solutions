// String-2:


// doubleChar
// Given a string, return a string where for every char in the original, there are two chars.
public String doubleChar(String str) {
  String outstr="";
  for(int i=0;i<str.length();i++){
    outstr = outstr + str.charAt(i) + str.charAt(i);
  }
  return outstr;
}

// countHi
// Return the number of times that the string "hi" appears anywhere in the given string.
public int countHi(String str) {
  int count=0;
  for(int i=0; i<str.length()-1; i++){
    if(str.substring(i,i+2).equals("hi")) count++;
  }
  return count;
}



// catDog
// Return true if the string "cat" and "dog" appear the same number of times in the given string.
public boolean catDog(String str) {
  int cat=0;
  int dog=0;
  for(int i=0; i<str.length()-2;i++){
    if(str.substring(i,i+3).equals("dog")) dog++;
    if(str.substring(i,i+3).equals("cat")) cat++;
  }
  return cat == dog;
}



// countCode
// Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
public int countCode(String str) {
  int count=0;
  for(int i=0; i<str.length()-3; i++){
    if(str.substring(i,i+2).equals("co") && str.charAt(i+3)=='e') count++;
  }
  return count;
  
}


// endOther
// Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
public boolean endOther(String a, String b) {
  a = a.toLowerCase();
  int alen = a.length();
  b = b.toLowerCase();
  int blen= b.length();
  if(alen>=blen) return (a.substring(alen-blen).equals(b)); 
  return (b.substring(blen-alen).equals(a));
}


// xyzThere
// Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
public boolean xyzThere(String str) {
  for(int i=0;i<str.length()-2; i++){
    if(str.substring(i,i+3).equals("xyz")){
      if(i==0) return true;
      if(i>0 && str.charAt(i-1) != '.') return true;
    }
  }
  return false;
}


// bobThere
// Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
public boolean bobThere(String str) {
  for(int i=0; i<str.length()-2; i++){
    if(str.charAt(i)=='b' && str.charAt(i+2)=='b') return true;
  }
  return false;
}


// xyBalance
// We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
public String mixString(String a, String b) {
  String result = "";
  int i;
  int len = Math.min(a.length(),b.length()); 
  for(i=0; i<len; i++) result = result + a.charAt(i) + b.charAt(i);
  if(a.length()<b.length()) return result + b.substring(i);
  return result + a.substring(i);
}



// repeatEnd
// Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You may assume that n is between 0 and the length of the string, inclusive.
public String repeatEnd(String str, int n) {
  String outstr = "";
  for(int i=0; i<n; i++ ){
    outstr += str.substring(str.length()-n);
  }
  return outstr;
}


// repeatFront
// Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
public String repeatFront(String str, int n) {
  String outstr="";
  for(; n>0;n--){
    outstr += str.substring(0,n);
  }
  return outstr;
}



// repeatSeparator
// Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.
public String repeatSeparator(String word, String sep, int count) {
  String outstr="";
  for(int i=0;i<count;i++){
    outstr += word;
    if(i<count-1) outstr+= sep;
  }
  return outstr;
}


// prefixAgain
// Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().
public boolean prefixAgain(String str, int n) {
  String pre = str.substring(0,n);
  for(int i=n;i<=str.length()-n;i++){
    if(str.substring(i,i+n).equals(pre)) return true; 
  }
  return false;
}

// xyzMiddle
// Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
public boolean xyzMiddle(String str) {
  int mid = (str.length()-3)/2;
  if(str.length()<3) return false;
  if((str.length()-3)%2 !=0){
    if(str.substring(mid+1,mid+4).equals("xyz")) return true;
  }
  return (str.substring(mid,mid+3).equals("xyz"));
}

// getSandWich
// A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
public String getSandwich(String str) {
  for(int i=0; i<str.length()-4;i++){
    if(str.substring(i,i+5).equals("bread")){
      for(int j=str.length(); j>i+5; j--){
        if(str.substring(j-5,j).equals("bread")) return str.substring(i+5,j-5); 
      }
    }
  }
  return "";
}

// sameStarChar
// Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.
public boolean sameStarChar(String str) {
  for(int i=1; i<str.length()-1;i++){
    if(str.charAt(i) =='*' && str.charAt(i-1) != str.charAt(i+1)) return false;
  }
  return true;
  
}

// oneTwo
// Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
public String oneTwo(String str) {
  String outstr="";
  for(int i=0; i<str.length()-2;i+=3){
    outstr = outstr+ str.substring(i+1,i+3) + str.charAt(i);
  }
  return outstr;
}

// zipZap
// Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
public String zipZap(String str) {
  String outstring="";
  if (str.length()<3) return str;
  for(int i=0; i<str.length();i++){
    if(str.charAt(i)=='z' && str.charAt(i+2)=='p'){
      outstring = outstring + "z" + "p";
      i+=2;
    }else{
      outstring += str.charAt(i);
    }
  }
  return outstring;
}


// starOut
// Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
public String starOut(String str) {
  String result = "";
  for(int i=0; i<str.length(); i++){
    if(str.charAt(i) == '*') continue;
    if(i+1<str.length() && str.charAt(i+1)== '*') continue;
    if(i>0 && str.charAt(i-1) == '*') continue;
    result += str.charAt(i);
  }
  return result;
}



// plusOut
// Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
public String plusOut(String str, String word) {
  String outstring="";
  for(int i=0; i<str.length(); i++){
    if(i+word.length()<=str.length() && str.substring(i,i+word.length()).equals(word)){
      outstring += word;
      i+=word.length()-1;
    }else{
    outstring += "+";
    }
  }
  return outstring;
}



// wordEnds
// Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.
public String wordEnds(String str, String word) {
  String result = "";
  int chunk = word.length();
  for(int i=0; i<=str.length(); i++){
    if(i+chunk<=str.length() && str.substring(i,i+chunk).equals(word)){
      if(i>0) result += str.charAt(i-1);
      if(i+chunk<str.length()) result += str.charAt(i+chunk);
}
  }
  return result;
}


