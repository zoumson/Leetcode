/*
Adama ZOUMA
stargue492gmail.com

Leetcode: 5. Longest Palindromic Substring
Link : https://leetcode.com/problems/longest-palindromic-substring/
*/


#ifndef LPS_h
#define  LPS_h
#include <string>

//------------------------HELPER FUNCTIONS------------------------------
// transform "aba" to "$#a#b#a#&"
// input is the original string
inline std::string preprocess(const std::string &);
// specified which index i has the longuest palindrome  length

// input is the modified string got from preprocess
inline int *fillPalLength(std::string &);

// Give the substring with the longuest palindrome
// Inputs are original string and int array from fillPalLength
inline std::string substring(const std::string &, int *);

//------------------------MAIN FUNCTION------------------------------
std::string LPS(std::string &);


#endif
