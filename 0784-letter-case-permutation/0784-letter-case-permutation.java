class Solution {
    List<String> list = new ArrayList<>() ;
    public List<String> letterCasePermutation(String s) {
       StringBuilder s1 = new StringBuilder()  ;
        combinations(s,s1,0) ;
        return list ; 
    }
    public void combinations(String s ,StringBuilder s1, int n){
        if(n>=s.length()){
            list.add(s1.toString()) ;
            return ;
        }
        char ch = s.charAt(n) ;
        if(Character.isLetter(s.charAt(n))){
            s1.append(Character.toUpperCase(ch)) ;
            combinations(s,s1,n+1);
            s1.deleteCharAt(s1.length()-1) ;

            s1.append(Character.toLowerCase(ch)) ;
            combinations(s,s1,n+1);
            s1.deleteCharAt(s1.length()-1) ;
        }
        else{
            s1.append(ch) ;
            combinations(s,s1,n+1);
            s1.deleteCharAt(s1.length()-1) ;
        }
    }
}