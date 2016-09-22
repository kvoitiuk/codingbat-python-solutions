// String-3:


// countYZ
// Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
public int countYZ(String str) {
  int count=0;
  for(int i=0;i<str.length();i++){
    if(str.charAt(i)=='y'|| str.charAt(i)=='z' || str.charAt(i)=='Y' || str.charAt(i)=='Z'){
      if (i==str.length()-1 || (i<str.length()-1 && !Character.isLetter(str.charAt(i+1)))) count++;
  }
  }
  return count;
}


// withoutString
// Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
public String withoutString(String base, String remove) {
  String result="";
  String chunk = "";
  String rem = remove.toLowerCase();
  for(int i=0;i<base.length();i++){
    if(base.length()>=i+remove.length()){
    chunk = base.substring(i,i+remove.length()).toLowerCase();
    if(chunk.equals(rem)) i+=remove.length()-1;
    else result+=base.charAt(i); 
    }else result+=base.charAt(i); 
  }
  return result;
}


// equalIsNot
// Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive).
public boolean equalIsNot(String str) {
  int count =0;
  for(int i=0;i<str.length()-1;i++) if(str.substring(i,i+2).equals("is")) count++;
  for(int i=0;i<str.length()-2;i++) if(str.substring(i,i+3).equals("not")) count--;
  return count==0;
}


// gHappy
// We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy.
public boolean gHappy(String str) {
  for(int i=0;i<str.length();i++){
    if(str.charAt(i)=='g' && !(((i>0 && str.charAt(i-1)=='g')) || 
    (i<str.length()-1 && str.charAt(i+1)=='g'))) return false;
  }
  return true;
}


// countTriple
// We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap.
public int countTriple(String str) {
  int count=0;
  for(int i=0;i<str.length()-2;i++){
    if(str.charAt(i)==str.charAt(i+1) && str.charAt(i)==str.charAt(i+2)) count++;
  }
  return count;
}


// sumDigits
// Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
public int sumDigits(String str) {
  int sum=0;
  for(int i=0;i<str.length();i++){
    if(Character.isDigit(str.charAt(i)))sum+= Integer.parseInt(str.substring(i,i+1));
    }
  return sum;
}


// sameEnds
// Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. For example, sameEnds("abXab") is "ab".
public String sameEnds(String string) {
  String subs="";
  for(int i=0;i<string.length();i++){
    if(string.substring(0,i).equals(string.substring(string.length()-i, string.length())) && i<=string.length()/2) subs=string.substring(0,i);
  }
  return subs;
}


// mirrorEnds
// Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
public String mirrorEnds(String string) {
  String subs="";
  for(int i=0;i<string.length();i++){
    if (string.charAt(i)==string.charAt(string.length()-1-i))   subs = string.substring(0,i+1);
    else break;
  }
  return subs;
}


// maxBlock
// Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
public int maxBlock(String str) {
  int block=1;
  int max=0;
  for(int i=0;i<str.length()-1;i++){
    if(str.charAt(i)==str.charAt(i+1)) block++;
    else block=1;
    max = Math.max(max,block);
  }
  return max;
}


// sumNumbers
// Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
public int sumNumbers(String str) {
  String number="0";
  int sum=0;
  for(int i=0;i<str.length();i++){
    if(!Character.isDigit(str.charAt(i))){
      sum+= Integer.parseInt(number); 
      number="0";
    } else number+=str.charAt(i);
  }
  return sum+Integer.parseInt(number);
}


// notReplace
// Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char) tests if a char is a letter.)
public String notReplace(String str) {
  String result="";
  for(int i=0;i<str.length();i++){
    result += str.charAt(i);
    if(i>=1 && str.charAt(i-1)=='i' && str.charAt(i)=='s' && (i==str.length()-1 
    || !Character.isLetter(str.charAt(i+1))) && (i<2 || !Character.isLetter(str.charAt(i-2))))
      result+=" not";

  }
  return result;
}


