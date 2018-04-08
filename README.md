# Cipher-Breaker-AI-Project-

This repository is for my Artifical Inteligence module in my final year (4th) of Software Developemnt in Galway-Mayo Technical Institute.

## What is AI?

"The theory and development of computer systems able to perform tasks
that normally require human intelligence, such as visual perception, speech
recognition, decision-making, and translation between languages."

## Introduction to the project

The field of cryptanalysis is concerned with the study of ciphers, having as its objective the
identification of weaknesses within a cryptographic system that may be exploited to convert
encrypted data (cipher-text) into unencrypted data (plain-text). Whether using symmetric or
asymmetric techniques, cryptanalysis assumes no knowledge of the correct cryptographic key
or even the cryptographic algorithm being used.
Assuming that the cryptographic algorithm is known, a common approach for breaking a cipher
is to generate a large number of keys, decrypt a cipher-text with each key and then examine the
resultant plain-text. If the text looks similar to English, then the chances are that the key is a
good one. The similarity of a given piece of text to English can be computed by breaking the
text into fixed-length substrings, called n-grams, and then comparing each substring to an
existing map of n-grams and their frequency. This process does not guarantee that the outputted
answer will be the correct plain-text, but can give a good approximation that may well be the
right answer.

## What is PlayFair Cipher


The Playfair system was invented by Charles Wheatstone, who first described it in 1854.
The Playfair cipher or Playfair square or Wheatstone-Playfair cipher is a manual symmetric encryption technique and was the first literal digram substitution cipher. The scheme was invented in 1854 by Charles Wheatstone, but bears the name of Lord Playfair for promoting its use.

The technique encrypts pairs of letters (bigrams or digrams), instead of single letters as in the simple substitution cipher and rather more complex Vigenère cipher systems then in use. The Playfair is thus significantly harder to break since the frequency analysis used for simple substitution ciphers does not work with it. The frequency analysis of bigrams is possible, but considerably more difficult. With 600 possible bigrams rather than the 26 possible monograms (single symbols, usually letters in this context), a considerably larger cipher text is required in order to be useful.

Eg: 

    P L A Y F

    I R E X M
    
    B C D G H
    
    K N O Q S
    
    T U V W Z
    
## nGram 
In the fields of computational linguistics and probability, an n-gram is a contiguous sequence of n items from a given sample of text or speech. The items can be phonemes, syllables, letters, words or base pairs according to the application. The n-grams typically are collected from a text or speech corpus. When the items are words, n-grams may also be called shingles clarification needed.

Using Latin numerical prefixes, an n-gram of size 1 is referred to as a "unigram"; size 2 is a "bigram" (or, less commonly, a "digram"); size 3 is a "trigram". English cardinal numbers are sometimes used, e.g., "four-gram", "five-gram", and so on. In computational biology, a polymer or oligomer of a known size is called a k-mer instead of an n-gram, with specific names using Greek numerical prefixes such as "monomer", "dimer", "trimer", "tetramer", "pentamer", etc., or English cardinal numbers, "one-mer", "two-mer", "three-mer", etc.

## Simulated Annealing
Simulated annealing (SA) is a probabilistic technique for approximating the global optimum of a given function. Specifically, it is a metaheuristic to approximate global optimization in a large search space. It is often used when the search space is discrete (e.g., all tours that visit a given set of cities). For problems where finding an approximate global optimum is more important than finding a precise local optimum in a fixed amount of time, simulated annealing may be preferable to alternatives such as gradient descent.

## References

[Stack Overflow](https://stackoverflow.com/)

[Java Docs](https://docs.oracle.com/en/)

[Wikipedia](https://en.wikipedia.org/wiki/Main_Page)

[Simulated Annealing Tutorials](http://www.theprojectspot.com/tutorial-post/simulated-annealing-algorithm-for-beginners/6)

[nGrams Tutorial](https://stackoverflow.com/questions/3656762/n-gram-generation-from-a-sentence)

[KeyGeneration](https://docs.oracle.com/javase/7/docs/api/javax/crypto/KeyGenerator.html)

