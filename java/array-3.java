
// Array-3:


// maxSpan
// Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
public int maxSpan(int[] nums) {
  if (nums.length==0) return 0;
  int max=0;
  int span=0;
  for(int j=0; j<nums.length;j++){
    for(int i=0;i<nums.length;i++){
      if(nums[i]==nums[j]){
        span=i-j;
        if(span>max) max=span;
      }
    }
  }

  return max+1;
}



// fix34
// Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may move. The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3 or 4, and a 3 appears in the array before any 4.
public int[] fix34(int[] nums) {
  int temp=0;
  for(int i=0;i<nums.length;i++){
    if(nums[i]==3){
      temp=nums[i+1];
      nums[i+1]=4;
      for(int j=0; j<nums.length;j++){
        if(nums[j]==4 && (j==0 || nums[j-1]!=3)) nums[j]=temp;
      }
    }
  }
  return nums;
}




// fix45
// (This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers as the given array, but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, but every other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4. In this version, 5's may appear anywhere in the original array.
public int[] fix45(int[] nums) {
  int temp=0;
  for(int i=0;i<nums.length;i++){
    if(nums[i]==4){
      temp=nums[i+1];
      nums[i+1]=5;
      for(int j=0; j<nums.length;j++){
        if(nums[j]==5 && (j==0 || nums[j-1]!=4)) nums[j]=temp;
      }
    }
  }
  return nums;
}





// canBalance
// Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
public boolean canBalance(int[] nums) {
  for(int i=0;i<nums.length;i++){
    if(sum(0,i,nums)==sum(i,nums.length,nums)) return true;
  }
  return false;
}

int sum(int start, int end, int[] nums){
  int total=0;
  for(int i=start; i<end; i++) total+= nums[i];
  return total;
}


// linearIn
// Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.
public boolean linearIn(int[] outer, int[] inner) {
  for(int i=0;i<inner.length;i++){
    for(int j=0; j<outer.length;j++){
      if(outer[j]==inner[i]) break;
     if(j==outer.length-1) return false;
    }
  }
  return true;
}



// squareUp
// Given n>=0, create an array length n*n with the following pattern, shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
public int[] squareUp(int n) {
  int[] result = new int[n*n];
  int[] sub= new int[n];
  int index=0;
  for(int i=0;i<n;i++){
    sub[n-i-1]=i+1;
    for(int j=0;j<n;j++) result[index++]=sub[j];
  }
  return result;
}


// seriesUp
// Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n + 1)/2.
public int[] seriesUp(int n) {
  int[] result = new int[n*(n + 1)/2];
  int count=0;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=i;j++){
      result[count++]=j;
    }
  }
  return result;
}


// maxMirror
// We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
public int maxMirror(int[] nums) {
    int max = 0;
    int count = 0;
    for(int i = 0; i < nums.length; i++) {
        for(int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
          if(nums[i + count] == nums[j])  count++;
          else {
            if(count>max) max=count;
            count = 0;
            }
        }
        if(count>max) max=count;
        count=0;
    }
    return max;
}


// countClumps
// Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.
public int countClumps(int[] nums) {
  int clumps=0;
  for(int i=0;i<nums.length-1;i++){
    if(nums[i]==nums[i+1])clumps++;
    for(;i<nums.length-1 && nums[i]==nums[i+1];i++);
  }
  return clumps;
}

