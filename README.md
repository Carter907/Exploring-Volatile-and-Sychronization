# Exploring-Volatile-and-Sychronization
I recently suggested the use of `Volatile` as a form of synchronization as I hear so much. However, I have found through experimentation that volatile is actually never  a reliable form of sychronization.
<br>
https://www.javatpoint.com/volatile-keyword-in-java#:~:text=Volatile%20keyword%20is%20used%20to,same%20time%20without%20any%20problem.
<br>
is one such example that misleads the user into thinking that `Voaltile` will allow for atomic operations on fields which is incorrect. 
