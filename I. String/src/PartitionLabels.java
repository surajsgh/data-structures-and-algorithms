import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        List<String> set = new ArrayList<>();
        int index = 0;

        for(int i=0; i<n; i++) {
            String previousPartition = s.substring(index, i+1);
            String upcomingPartition = s.substring(i+1, n);

            if(doesCharacterExist(previousPartition, upcomingPartition)) {
                set.remove(previousPartition);
            }
            else {
                index = i+1;
                set.add(previousPartition);
            }
        }

        for(String str: set) {
            result.add(str.length());
        }

        return result;
    }

    public boolean doesCharacterExist(String prev, String upcoming) {
        for(char ch: prev.toCharArray()) {
            if(upcoming.indexOf(ch)!=-1) {
                return true;
            }
        }
        return false;
    }
}
