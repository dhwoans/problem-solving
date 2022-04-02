package Leetcode.medium;

public class Integer_to_Roman {
    public String intToRoman(int num) {
        String[] five = {"","V","L","D"};
        String[] ten = {"I","X","C","M"};
        StringBuilder sb = new StringBuilder();
        int position =1;
        while(num!=0){
            int temp=num%10;
            num/=10;
            if(temp>5){
                if(temp==9){
                    sb.append(ten[position]).append(ten[position-1]);
                    position++;
                    continue;
                }
                for (int i = 0; i < temp-5; i++) {
                    sb.append(ten[position-1]);
                }
                sb.append(five[position]);
            }else if(temp<5){
                if(temp==4){
                    sb.append(five[position]).append(ten[position-1]);
                    position++;
                    continue;
                }
                for (int i = 0; i < temp; i++) {
                    sb.append(ten[position-1]);
                }
            }else{
                sb.append(five[position]);
            }
            position++;
        }
        return sb.reverse().toString();
    }
}