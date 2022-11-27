package leetcode

class NumberofDiceRollsWithTargetSum {
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        val mod = (1e9+7).toInt()
        val dp = Array(n+1){IntArray(target+1)}.apply{
            for(i in 1..target){
                if(i<=k)this[1][i] = 1
            }

        }

        for(i in 2 .. n){
            for(j in 1 .. target){
                for(k in 1..k){
                    if(j-k>=0){
                        dp[i][j]= (dp[i][j]+dp[i-1][j-k])%mod
                    }
                }

            }
        }
        return dp[n][target]
    }
}