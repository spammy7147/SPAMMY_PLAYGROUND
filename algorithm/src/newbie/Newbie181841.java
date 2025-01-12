package newbie;

public class Newbie181841 {
    public String solution(String[] str_list, String ex) {
        StringBuffer sb = new StringBuffer();
        for (String s : str_list) {
            if(!s.contains(ex)) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
