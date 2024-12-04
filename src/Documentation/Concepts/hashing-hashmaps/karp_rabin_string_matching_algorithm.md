# Karp Rabin String Matching Algorithm

### Problem: let's say you are given a string a = "Magd" of Size N, and another string b = "MrMagdKamal" of size M, and you have to find weather string a is a subset of string b
### Brute force approach: search in every character in b for a -> O(N*M)
### we can optimize this using karp rabin algorithm, what karp rabin does is:
### it compares the hashValue of string a in string b
### h(a) = h( b \[ i : i + len(a) ] )
### so it compares the hashValue of a to the hashValue of slots of b
### for if the above function is true it might be possible that a match is found, but not sure for many values might have the same hashValue, so if a match is found check with every charachter of a, if all characters are equal return true, else then just the hashValue is equal and the propability of this happening is 1/len(a)
