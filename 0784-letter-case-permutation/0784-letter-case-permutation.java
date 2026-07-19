class Solution {
    List<String> list = new ArrayList<>() ;
    public List<String> letterCasePermutation(String s) {
       StringBuilder s1 = new StringBuilder()  ;
        combinations(s,s1,0) ;
        return list ; 
    }
    public void combinations(String s ,StringBuilder s1, int n){
        if(n==s.length()){
            list.add(s1.toString()) ;
            return ;
        }
        if (Character.isDigit(s.charAt(n))) {
            s1.append(s.charAt(n));
            combinations(s, s1, n + 1);
            return;
        }

        StringBuilder op1 = new StringBuilder(s1)  ;
        op1.append(Character.toLowerCase(s.charAt(n)));

        StringBuilder op2 = new StringBuilder(s1)  ;
        op2.append(Character.toUpperCase(s.charAt(n))) ;

        combinations(s,op1,n+1) ;
        combinations(s,op2,n+1) ;

    }
}