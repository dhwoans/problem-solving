package BOJ.gold

fun main() {
    val (a,b) = readLine()!!.split(" ").map(String::toInt)
    val (n,m) = readLine()!!.split(" ").map(String::toInt)
    //맵 생성
    val map = Array(b){IntArray(a)}
    //로봇 위치
    val botInfo = ArrayList<Bot>()
    repeat(n){
        val (c,r,dir)= readLine()!!.split(" ").mapIndexed { index, s ->
            when(index){
                0->{s.toInt()-1}
                1->{b-s.toInt()}
                2->{s.first()}
                else -> null
            }
        }
        //맵에 위치 표시
        map[r as Int][c as Int]=it+1
        botInfo.add(Bot(r,c,dir as Char))
    }
    //명령
    repeat(m){
        val (unit,command,num) = readLine()!!.split(" ").mapIndexed { index, s ->
            when(index){
                0 ->{ s.toInt()-1}
                1 ->{ s.first()}
                2 ->{ s.toInt()}
                else ->null
            }
        }
        val robot = botInfo[unit as Int]
        //명령
        when(command as Char){
            'L'->{// 왼쪽으로 90도 회전
                repeat(num as Int){
                    when(robot.dir){
                        'N'->{robot.dir='W'}
                        'W'->{robot.dir='S'}
                        'S'->{robot.dir='E'}
                        'E'->{robot.dir='N'}
                    }
                }
            }
            'R'->{// 오른쪽으로 90도 회전
                repeat(num as Int){
                    when(robot.dir){
                        'N'->{robot.dir='E'}
                        'W'->{robot.dir='N'}
                        'S'->{robot.dir='W'}
                        'E'->{robot.dir='S'}
                    }
                }
            }
            'F'->{// 한칸 전진
                var nx = robot.x
                var ny = robot.y
                map[nx][ny]=0
                repeat(num as Int){
                    //전진
                    when(robot.dir){
                        'N'->{nx-=1}
                        'W'->{ny-=1}
                        'S'->{nx+=1}
                        'E'->{ny+=1}
                    }
                    //범위 체크
                    if(nx<0||ny<0||nx>=map.size||ny>=map[0].size){
                        println("Robot ${unit+1} crashes into the wall")
                        return
                    }
                    //충돌체크
                    if(map[nx][ny]!=0){
                        println("Robot ${unit+1} crashes into robot ${map[nx][ny]}")
                        return
                    }
                    //정보갱신
                    robot.x = nx
                    robot.y = ny
                }
                map[nx][ny]=unit+1
            }
        }
    }
    println("OK")
}

private data class Bot(var x: Int, var y: Int, var dir: Char)