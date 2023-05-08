package leetCode;


import java.util.HashSet;
import java.util.Set;

public class GoogleEmailFindUniqueEmails {

    public static void main(String[] args){
        String[] arr = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println("Number of unique emails - " + numUniqueEmails(arr));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        for(String email : emails){
            String local = email.split("@")[0];
            String domain = email.split("@")[1];
            local = local.replaceAll("/.", "");
            if(local.contains("+")){
                local=local.substring(0,local.indexOf('+'));
            }
            emailSet.add(local+"@"+domain);
        }
        return emailSet.size();

    }
}
