
/*
Adama ZOUMA
stargue492gmail.com

Leetcode: 5. Longest Palindromic Substring
Link : https://leetcode.com/problems/longest-palindromic-substring/
*/


#include <string>
#include "LPS.h"

inline std::string preprocess(const std::string & s)
{
  // Create a new string of length 2*s + 3
  // Fill all with '#' using customized string constructor
  std::string modified_s(2*s.size()+3 , '#');

  // Extremities should be different to avoid comparison
  // When expanding palindrome
  modified_s[0] = '$';
  modified_s[modified_s.size() - 1] = '@';

  // Indexing the original string s to be copied
  int j = 0;

  // even indices are filled with original string characters one at time
  for( int i = 2; i < modified_s.size() - 1; i += 2)modified_s[i] = s[j++];

return modified_s;// return modified string
}



inline int *fillPalLength(std::string & t)
{
  // p contains the palindrome length given their center i in modified string
  int *p = new int[t.size()];

  // Initialized all to 0
  for(int i = 0; i < t.size(); i++) p[i] = 0;

  int center = 0, right = 0;
       for (int i = 1; i < t.size()-1; i++)
       {
         /*
         // Mirror to i
         // c - i = mirror - c, same distance
         // i--c--mirror, distance is 2 here
         */
           int mirror = 2*center - i;
/*
          Given index i is within the current longuest palindrome
          Mirror is located after the current center
          Length of palindrome at its mirror is at least what we have at i
          Mirror is located before the current center
          Llength of palindrome at its mirror is at least right - i
*/
           if (i < right)
           {
             int leftSide = p[mirror];
             int rightSide = right - i;
             p[i] = leftSide <= rightSide ? leftSide: rightSide;
           }


           // attempt to expand palindrome centered at i
           // check boundaries and inncreement length accordingly
           while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) p[i]++;

           // if palindrome centered at i expands past right,
           // adjust center based on expanded palindrome.
           if (i + p[i] > right) {
               center = i;
               right = i + p[i];
           }
       }


return p;
}

inline std::string substring(std::string const &s, int* p)

{
   int p_length = 2*s.size() +3;
    int length = 0;   // length of longest palindromic substring
    int center_modifified_s = 0;   // center of longest palindromic substring
    // finding the maximum in p and its location
    for (int i = 1; i < p_length -1; i++)
    {
        if (p[i] > length)
        {
            length = p[i];// length
            center_modifified_s = i;// location

        }

    }
    /*
    index from modified to original string
    -i index in modified string s,
    -j in original string s
    modified length is 2*j + 3, but two are no used Extremities ($ and @)
    -> i = 2*j + 3 --> i = (2*j + 3) - 2 = 2*j + 1  -> i --> j = (i - 1)/2
    Center in s is center_s = (center_modifified_s - 1)/2
    Left side of the palindrome is center_s - length/2
    left = center_s - length/2 = (center_modifified_s - 1)/2-length/2
    left = (center_modifified_s - 1 - length)/2
    substr(start, length)
    */
    return s.substr((center_modifified_s- 1 - length)/2, length);

}


std::string LPS(std::string & s)
{
  std::string modified_s = preprocess(s);
  int *pal_length_array = fillPalLength(modified_s);
  return substring(s, pal_length_array);
}
