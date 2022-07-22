import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrentChargingRangeCount {
	
	int []  input = {3,3,5,4,10,11,12};

    public Map<String,String> countWithInputValue(int start , int stop) {
        long count =0;
        Map<String,String> range = new HashMap<>();
        List<Integer> intList = new ArrayList<Integer>(input.length);
        for (int i : input){
            intList.add(i);
        }
        if(intList.contains(start) && intList.contains(stop)) {
            for(int i=start;i<=stop;i++) {
                if(intList.contains(i)) {
                    int inputCount =i;
                    long seqCount = Arrays.stream(input).filter(d->d==(inputCount)).count();
                    count=count+seqCount;
                } else {
                    range.put(start +"-"+stop, "Not in Range");
                    return range;
                }
            }
            range.put(start +"-"+stop,String.valueOf(count));
            return range;
        }

        range.put(start +"-"+stop,"No match found in the reading");
        return range;
    }

}
