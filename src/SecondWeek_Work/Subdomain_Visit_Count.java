/*
第二周作业 子域名访问计数（Easy）811. Subdomain Visit Count
姓名：辛逸杰
学号：G20210760020092
 */
package SecondWeek_Work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null) return null;
        String[] domainAndVal = new String[2];
        Integer val;
        String[] splitdomain = new String[3];
        Map<String, Integer> domainToVal = new HashMap<>();

        for (String s : cpdomains) {
            domainAndVal = s.split(" ");
            val = Integer.valueOf(domainAndVal[0]);
            splitdomain = domainAndVal[1].split("\\.");
            splitdomain[0] = domainAndVal[1];
            if (splitdomain.length == 3)
                splitdomain[1] = splitdomain[1] + "." + splitdomain[2];
            for (String t : splitdomain) {
                domainToVal.put(t, domainToVal.getOrDefault(t, 0) + val);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainToVal.entrySet()) {
            val = entry.getValue();
            res.add(val.toString() + " " + entry.getKey());
        }
        return res;
    }
}
