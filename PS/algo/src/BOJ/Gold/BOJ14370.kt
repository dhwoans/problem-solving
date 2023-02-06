package BOJ.Gold

fun main() {
    repeat(readln().toInt()){
        var str = readln().toCollection(ArrayList<Char>())
        val ans = ArrayList<Int>()
        while(str.size!=0){
            if(str.contains('Z')){
                ans.add(0)
                str.remove('Z')
                str.remove('E')
                str.remove('R')
                str.remove('O')
            }else if(str.contains('W')){
                ans.add(2)
                str.remove('T')
                str.remove('W')
                str.remove('O')

            }else if(str.contains('X')){
                ans.add(6)
                str.remove('S')
                str.remove('I')
                str.remove('X')
            }else if(str.contains('U')){
                ans.add(4)
                str.remove('F')
                str.remove('O')
                str.remove('U')
                str.remove('R')
            }else if(str.contains('S')){
                ans.add(7)
                str.remove('S')
                str.remove('E')
                str.remove('V')
                str.remove('E')
                str.remove('N')
            }else if(str.contains('G')){
                ans.add(8)
                str.remove('E')
                str.remove('I')
                str.remove('G')
                str.remove('H')
                str.remove('T')
            }else if(str.contains('T')&&str.contains('H')&&str.contains('R')){
                ans.add(3)
                str.remove('E')
                str.remove('E')
                str.remove('R')
                str.remove('H')
                str.remove('T')
            }else if(str.contains('F')&&str.contains('I')&&str.contains('V')&&str.contains('E')){
                ans.add(5)
                str.remove('F')
                str.remove('I')
                str.remove('V')
                str.remove('E')
            }else if(str.contains('N')&&str.contains('I')&&str.contains('N')&&str.contains('E')){
                ans.add(9)
                str.remove('N')
                str.remove('I')
                str.remove('N')
                str.remove('E')
            }else if(str.contains('O')&&str.contains('N')&&str.contains('E')){
                ans.add(1)
                str.remove('O')
                str.remove('N')
                str.remove('E')
            }
        }
        ans.sort()
        print("Case #${it+1}: ")
        ans.forEach {
            print(it)
        }
        println()
    }
}
