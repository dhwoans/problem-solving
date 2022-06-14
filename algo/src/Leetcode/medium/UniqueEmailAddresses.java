package Leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringTokenizer st = new StringTokenizer(email, "@");
            String local = st.nextToken();
            String domain = st.nextToken();
            //.제거
            local = local.replace(".", "");
            if (local.contains("+")) {
                st = new StringTokenizer(local, "+");
                local = st.nextToken();
                String dumy = st.nextToken();
            }
            set.add(local + "@" + domain);

        }
        return set.size();
    }
}
