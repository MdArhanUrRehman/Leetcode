class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();

        HashMap<String, String> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<knowledge.size(); i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        int i = 0;

        while(i < n){
            char ch = s.charAt(i);

            if(ch == '('){
                StringBuilder temp = new StringBuilder();

                i++;
                while(i<n && s.charAt(i) != ')'){
                    temp.append(s.charAt(i++));
                }

                String aux = temp.toString();

                if(map.containsKey(aux)){
                    ans.append(map.get(aux));
                }else{
                    ans.append("?");
                }
            }else{
                ans.append(ch);
            }

            i++;
        }

        return ans.toString();
    }
}