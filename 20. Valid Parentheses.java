class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){
                stk.push(curr);
            }else{    
             if(stk.isEmpty()){
                return false;
            }    
            else if( (stk.peek() == '(' && curr == ')')
            || (stk.peek() == '{' && curr == '}')
            || (stk.peek() == '[' && curr == ']')){
                stk.pop();
            }else{
                return false;
            }
            }  
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
}