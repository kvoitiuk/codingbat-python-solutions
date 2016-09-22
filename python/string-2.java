
# ------------- String-2: -------------------

#double_char
#Given a string, return a string where for every char in the original, there are two chars.
def double_char(str):
  outString = ""
  for char in str:
    outString += 2*char
  return outString


#count_hi
#Return the number of times that the string "hi" appears anywhere in the given string.
def count_hi(str):
  count = 0
  for i in range(len(str)-1):
    if(str[i:i+2] == "hi"):
      count +=1
  return count


#cat_dog
#Return True if the string "cat" and "dog" appear the same number of times in the given string.
def cat_dog(str):
  count = 0
  for i in range(len(str)-2):
    if str[i:i+3] == "cat":
      count +=1
    if str[i:i+3] == "dog":
      count -=1
  return count == 0


#count_code
#Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
def count_code(str):
  count = 0
  for i in range(0,len(str)-3):
    if (str[i:i+2] == "co" and str[i+3] == "e"):
      count += 1
  return count


#end_other
#Given two strings, return True if either of the strings appears at the very end of the other string, ignoring upper/lower
#case differences (in other words, the computation should not be "case sensitive"). Note: s.lower() returns the lowercase
#version of a string.
def end_other(a, b):
  a = a.lower()
  b = b.lower()
  return a.endswith(b) or b.endswith(a)

#or just return (a.lower() == b[-len(a):].lower()) or (b.lower() == a[-len(b):].lower())

