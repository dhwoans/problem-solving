package BOJ.bronze

fun main() {
   readLine()!!.forEach{
       if(it in 'a'..'z') print(it-('a'-'A'))
       else if(it in 'A'..'Z')print(it+('a'-'A'))
   }
}