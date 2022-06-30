package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ5076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        while (true){
            ArrayList<String> arr = new ArrayList<>();
            String str = br.readLine();
            if(str.equals("#"))return;
            Pattern pattern = Pattern.compile("<([^>]+)>");
            Matcher matcher = pattern.matcher(str);
            boolean flag =true;
            Stack<String> stack = new Stack<>();
            while(matcher.find()){
                String temp = matcher.group();
                if(temp.contains("</")){
                    temp = temp.replaceAll("/","");
                    temp = temp.replaceAll(">","");
                    if(stack.isEmpty()){
                        flag= false;
                        break;
                    }else if(stack.peek().contains(temp)){
                        stack.pop();
                    }
                }else{
                    if(temp.contains("/>"))continue;
                    stack.add(temp);
                }
            }
            if(!stack.isEmpty())flag = false;
            if(flag) System.out.println("legal");
            else System.out.println("illegal");
        }
    }
}
